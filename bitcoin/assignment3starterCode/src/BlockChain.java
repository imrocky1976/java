// Block Chain should maintain only limited block nodes to satisfy the functions
// You should not have all the blocks added to the block chain in memory 
// as it would cause a memory overflow.

import java.util.ArrayList;
import java.util.HashMap;


public class BlockChain {
    private class BlockNode {
        public Block b;
        public int height;
        public UTXOPool uPool;

        public BlockNode(Block b, int height, UTXOPool uPool) {
            this.b = b;
            this.height = height;
            this.uPool = uPool;
        }
    }

    public static final int CUT_OFF_AGE = 10;
    private BlockNode maxHeightBlockNode;
    private HashMap<ByteArrayWrapper, BlockNode> blockChain;
    private TransactionPool txPool;

    /**
     * create an empty block chain with just a genesis block. Assume {@code genesisBlock} is a valid
     * block
     */
    public BlockChain(Block genesisBlock) {
        txPool = new TransactionPool();
        blockChain = new HashMap<>();

        UTXOPool uPool = new UTXOPool();
        addCoinbaseToUTXOPool(genesisBlock.getCoinbase(), uPool);
        BlockNode n = new BlockNode(genesisBlock, 1, uPool);
        ByteArrayWrapper wrapper = new ByteArrayWrapper(genesisBlock.getHash());
        blockChain.put(wrapper, n);
        maxHeightBlockNode = n;
    }

    /** Get the maximum height block */
    public Block getMaxHeightBlock() {
        return maxHeightBlockNode.b;
    }

    /** Get the UTXOPool for mining a new block on top of max height block */
    public UTXOPool getMaxHeightUTXOPool() {
        return maxHeightBlockNode.uPool;
    }

    /** Get the transaction pool to mine a new block */
    public TransactionPool getTransactionPool() {
        return txPool;
    }

    /**
     * Add {@code block} to the block chain if it is valid. For validity, all transactions should be
     * valid and block should be at {@code height > (maxHeight - CUT_OFF_AGE)}.
     * 
     * <p>
     * For example, you can try creating a new block over the genesis block (block height 2) if the
     * block chain height is {@code <=
     * CUT_OFF_AGE + 1}. As soon as {@code height > CUT_OFF_AGE + 1}, you cannot create a new block
     * at height 2.
     * 
     * @return true if block is successfully added
     */
    public boolean addBlock(Block block) {
        if (block.getPrevBlockHash() == null)
            return false;

        ByteArrayWrapper parentWrapper = new ByteArrayWrapper(block.getPrevBlockHash());
        BlockNode parent = blockChain.get(parentWrapper);
        if (parent == null)
            return false;

        int parentHeight = parent.height;
        int height = parentHeight + 1;
        if (height <= maxHeightBlockNode.height - CUT_OFF_AGE)
            return false;

        TxHandler txHandler = new TxHandler(parent.uPool);
        Transaction[] validTxs = txHandler.handleTxs(block.getTransactions().toArray(new Transaction[0]));
        if (validTxs.length != block.getTransactions().size())
            return false;

        UTXOPool uPool = txHandler.getUTXOPool();
        addCoinbaseToUTXOPool(block.getCoinbase(), uPool);

        ByteArrayWrapper wrapper = new ByteArrayWrapper(block.getHash());
        BlockNode n = new BlockNode(block, height, uPool);
        blockChain.put(wrapper, n);
        if (height > maxHeightBlockNode.height) {
            maxHeightBlockNode = n;
        }
        return true;
    }

    /** Add a transaction to the transaction pool */
    public void addTransaction(Transaction tx) {
        txPool.addTransaction(tx);
    }

    private void addCoinbaseToUTXOPool(Transaction coinbase, UTXOPool uPool) {
        for (int i = 0; i < coinbase.numOutputs(); i++) {
            UTXO u = new UTXO(coinbase.getHash(), i);
            uPool.addUTXO(u, coinbase.getOutput(i));
        }
    }
}