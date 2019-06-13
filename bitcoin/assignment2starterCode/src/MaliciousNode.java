import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

import static java.util.stream.Collectors.toSet;

public class MaliciousNode implements Node {

    private double p_graph;
    private double p_malicious;
    private double p_tXDistribution;
    private int numRounds;

    private Set<Integer> validTxIds;

    private boolean[] followees;

    private Set<Transaction> pendingTransactions;

    private boolean[] blackListed;

    public MaliciousNode(double p_graph, double p_malicious, double p_txDistribution, int numRounds) {
        this.p_graph = p_graph;
        this.p_malicious = p_malicious;
        this.p_tXDistribution = p_txDistribution;
        this.numRounds = numRounds;
    }

    public void setFollowees(boolean[] followees) {
        this.followees = followees;
        this.blackListed = new boolean[followees.length];
    }

    public void setPendingTransaction(Set<Transaction> pendingTransactions) {
        this.pendingTransactions = pendingTransactions;
    }

    public Set<Transaction> sendToFollowers() {
         Set<Transaction> toSend = new HashSet<Transaction>(); //new HashSet<Transaction>(pendingTransactions);
        pendingTransactions.clear();
        // randomly add some txs
        for (Integer txId : validTxIds) {
            if (Math.random() < 0.2) {
                // System.out.println("add tx " + txId.toString());
                toSend.add(new Transaction(txId.intValue()));
            }
        }
        return toSend;
    }

    public void receiveFromFollowees(Set<Candidate> candidates) {
        Set<Integer> senders = candidates.stream().map(c -> c.sender).collect(toSet());
        for (int i = 0; i < followees.length; i++) {
            if (followees[i] && !senders.contains(i))
                blackListed[i] = true;
        }
        for (Candidate c : candidates) {
            if (!blackListed[c.sender]) {
                pendingTransactions.add(c.tx);
            }
        }
    }

    public void setValidTxIds(Set<Integer> validTxIds) {
        this.validTxIds = validTxIds;
    }
}