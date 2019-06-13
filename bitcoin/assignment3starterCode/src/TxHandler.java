import java.util.ArrayList;

public class TxHandler {

    private UTXOPool lgUTXOPool;

    public UTXOPool getUTXOPool() { return this.lgUTXOPool; }

    /**
     * Creates a public ledger whose current UTXOPool (collection of unspent transaction outputs) is
     * {@code utxoPool}. This should make a copy of utxoPool by using the UTXOPool(UTXOPool uPool)
     * constructor.
     */
    public TxHandler(UTXOPool utxoPool) {
        this.lgUTXOPool = new UTXOPool(utxoPool);
    }

    /**
     * @return true if:
     * (1) all outputs claimed by {@code tx} are in the current UTXO pool, 
     * (2) the signatures on each input of {@code tx} are valid, 
     * (3) no UTXO is claimed multiple times by {@code tx},
     * (4) all of {@code tx}s output values are non-negative, and
     * (5) the sum of {@code tx}s input values is greater than or equal to the sum of its output
     *     values; and false otherwise.
     */
    public boolean isValidTx(Transaction tx) {
        // (1) all outputs claimed by {@code tx} are in the current UTXO pool
        for (int i = 0; i < tx.numInputs(); i++) {
            Transaction.Input input = tx.getInput(i);
            UTXO utxo = new UTXO(input.prevTxHash, input.outputIndex);
            if (!lgUTXOPool.contains(utxo)) {
                return false;
            }
        }
        // (2) the signatures on each input of {@code tx} are valid
        for (int i = 0; i < tx.numInputs(); i++) {
            Transaction.Input input = tx.getInput(i);
            UTXO utxo = new UTXO(input.prevTxHash, input.outputIndex);
            Transaction.Output prevOutput = lgUTXOPool.getTxOutput(utxo);
            if (prevOutput == null) {
                return false;
            }
            if (!Crypto.verifySignature(prevOutput.address, tx.getRawDataToSign(i), input.signature)) {
                return false;
            }
        }
        // (3) no UTXO is claimed multiple times by {@code tx}
        ArrayList<UTXO> utxos = new ArrayList<UTXO>();
        for (int i = 0; i < tx.numInputs(); i++) {
            Transaction.Input input = tx.getInput(i);
            UTXO utxo = new UTXO(input.prevTxHash, input.outputIndex);
            utxos.add(utxo);
        }
        for (int i = 0; i < utxos.size(); i++) {
            for (int j = i + 1; j < utxos.size(); j++) {
                if (utxos.get(i).compareTo(utxos.get(j)) == 0) {
                    return false;
                }
            }
        }
        // (4) all of {@code tx}s output values are non-negative
        for (Transaction.Output op : tx.getOutputs()) {
            if (op.value < 0.0) {
                return false;
            }
        }
        // (5) the sum of {@code tx}s input values is greater than or equal to the sum of its output
        //     values
        double sumInputs = 0.0;
        for (Transaction.Input input : tx.getInputs()) {
            UTXO utxo = new UTXO(input.prevTxHash, input.outputIndex);
            Transaction.Output prevOutput = lgUTXOPool.getTxOutput(utxo);
            sumInputs += prevOutput.value;
        }
        double sumOutputs = 0.0;
        for (Transaction.Output op : tx.getOutputs()) {
            sumOutputs += op.value;
        }
        if (sumInputs < sumOutputs) {
            return false;
        }
        return true;
         /**
        UTXOPool uniqueUtxos = new UTXOPool();
        double previousTxOutSum = 0;
        double currentTxOutSum = 0;
        for (int i = 0; i < tx.numInputs(); i++) {
            Transaction.Input in = tx.getInput(i);
            UTXO utxo = new UTXO(in.prevTxHash, in.outputIndex);
            Transaction.Output output = lgUTXOPool.getTxOutput(utxo);
            if (!lgUTXOPool.contains(utxo)) return false;
            if (!Crypto.verifySignature(output.address, tx.getRawDataToSign(i), in.signature))
                return false;
            if (uniqueUtxos.contains(utxo)) return false;
            uniqueUtxos.addUTXO(utxo, output);
            previousTxOutSum += output.value;
        }
        for (Transaction.Output out : tx.getOutputs()) {
            if (out.value < 0) return false;
            currentTxOutSum += out.value;
        }
        return previousTxOutSum >= currentTxOutSum;*/
    }

    /**
     * Handles each epoch by receiving an unordered array of proposed transactions, checking each
     * transaction for correctness, returning a mutually valid array of accepted transactions, and
     * updating the current UTXO pool as appropriate.
     */
    public Transaction[] handleTxs(Transaction[] possibleTxs) {
        ArrayList<Transaction> acceptedTXs = new ArrayList<Transaction>();
//        boolean[] acceptedFlags = new boolean[possibleTxs.length];
//        for (int i = 0; i < acceptedFlags.length; i++) {
//            acceptedFlags[i] = false;
//        }
//        while (true) {
//            boolean hasValidTx = false;
            for (int i = 0; i < possibleTxs.length; i++) {
//                if (acceptedFlags[i] == true) {
//                    continue;
//                }
                Transaction tx = possibleTxs[i];
                if (isValidTx(tx)) {
//                    hasValidTx = true;
//                    acceptedFlags[i] = true;
                    acceptedTXs.add(tx);
                    for (int j = 0; j < tx.numInputs(); j++) {
                        Transaction.Input input = tx.getInput(j);
                        UTXO utxo = new UTXO(input.prevTxHash, input.outputIndex);
                        lgUTXOPool.removeUTXO(utxo);
                    }
                    for (int j = 0; j < tx.numOutputs(); j++) {
                        UTXO utxo = new UTXO(tx.getHash(), j);
                        lgUTXOPool.addUTXO(utxo, tx.getOutput(j));
                    }
                }
            }
//            if (!hasValidTx) {
//                break;
//            }
//        }
        Transaction[] txs = new Transaction[acceptedTXs.size()];
        int i = 0;
        for (Transaction tx : acceptedTXs) {
            txs[i++] = tx;
        }
        return txs;
    }

}
