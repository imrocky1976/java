
import java.security.*;

public class BlockHandler {
    private BlockChain blockChain;

    /** assume blockChain has the genesis block */
    public BlockHandler(BlockChain blockChain) {
        this.blockChain = blockChain;
    }

    /**
     * add {@code block} to the block chain if it is valid.
     * 
     * @return true if the block is valid and has been added, false otherwise
     */
    public boolean processBlock(Block block) {
        if (block == null)
            return false;
        return blockChain.addBlock(block);
    }

    /** create a new {@code block} over the max height {@code block} */
    public Block createBlock(PublicKey myAddress) {
        Block parent = blockChain.getMaxHeightBlock();
        byte[] parentHash = parent.getHash();
        Block current = new Block(parentHash, myAddress);
        UTXOPool uPool = blockChain.getMaxHeightUTXOPool();
        TransactionPool txPool = blockChain.getTransactionPool();
        TxHandler handler = new TxHandler(uPool);
        Transaction[] txs = txPool.getTransactions().toArray(new Transaction[0]);
        Transaction[] rTxs = handler.handleTxs(txs);
        for (int i = 0; i < rTxs.length; i++)
            current.addTransaction(rTxs[i]);

        current.finalize();
        if (blockChain.addBlock(current))
            return current;
        else
            return null;
    }

    /** process a {@code Transaction} */
    public void processTx(Transaction tx) {
        blockChain.addTransaction(tx);
    }

    public static void main(String[] args) {
        KeyPairGenerator keyPairGen = null;
        try {
            keyPairGen = KeyPairGenerator.getInstance("RSA");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        keyPairGen.initialize(1024);
        // 通过对象 KeyPairGenerator 获取对象KeyPair
        KeyPair keyPair = keyPairGen.generateKeyPair();

        // 通过对象 KeyPair 获取RSA公私钥对象RSAPublicKey RSAPrivateKey
        // RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        // RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Block b = new Block(null, keyPair.getPublic());
        b.finalize();

        BlockHandler bh = new BlockHandler(new BlockChain(b));

        Block b1 = new Block(b.getHash(), keyPair.getPublic());
        b1.finalize();

        Transaction tx = new Transaction();
        tx.addInput(b.getCoinbase().getHash(), 0);
        tx.addOutput(20, keyPair.getPublic());
        tx.addSignature(Crypto.signate(keyPair.getPrivate(), tx.getRawDataToSign(0)), 0);
        tx.finalize();

        bh.processTx(tx);
        bh.processBlock(b1);
        return;
    }
}
