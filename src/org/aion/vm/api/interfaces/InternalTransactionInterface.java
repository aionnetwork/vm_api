package org.aion.vm.api.interfaces;

/**
 * An internal transaction is a transaction spawned as a result of the execution of some other
 * transaction, referred to as its parent.
 */
public interface InternalTransactionInterface extends TransactionInterface {

    byte[] getParentTransactionHash();

    boolean isRejected();

    int getStackDepth();

    int getIndexOfInternalTransaction();

    String getNote();

    void markAsRejected();

    byte[] getEncoded();

}
