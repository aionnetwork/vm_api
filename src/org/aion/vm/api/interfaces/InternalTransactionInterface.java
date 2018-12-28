package org.aion.vm.api.interfaces;

/**
 * An internal transaction is a transaction spawned as a result of the execution of some other
 * transaction, referred to as its parent.
 *
 * <p>An internal transaction is never submitted directly into a {@link VirtualMachine}.
 * Transactions submitted directly to a {@link VirtualMachine} are known as external transactions,
 * or just transactions (see {@link TransactionInterface}).
 *
 * <p>All internal transactions are spawned by the logic of some external transaction or else by the
 * logic of another internal transaction, whose original ancestor is an external transaction.
 *
 * <p>An internal transaction has a concept of being 'rejected' that is slightly different than this
 * concept for an external transaction. An internal transaction is rejected if at least one of any
 * of its ancestor transactions was un-successful.
 */
public interface InternalTransactionInterface extends TransactionInterface {

    // TODO: still need to determine which of these methods are API-level and which are not.

    /**
     * Returns the transaction hash of the transaction that spawned this internal transaction.
     *
     * @return The hash of this transaction's parent transaction.
     */
    byte[] getParentTransactionHash();

    /**
     * Returns {@code true} if, and only if, this internal transaction is rejected.
     *
     * @return True if this internal transaction is rejected.
     */
    boolean isRejected();

    /**
     * Returns the depth of the stack at the time of this internal transaction being spawned.
     *
     * @return The stack depth when this transaction is spawned.
     */
    int getStackDepth();

    /**
     * Returns the index of this internal transaction, where the index is the number of ancestors
     * this internal transaction has. Therefore, if each of these transactions were in a list, this
     * number would be the index into the list at which this transaction resides.
     *
     * @return The index of this transaction.
     */
    int getIndexOfInternalTransaction();

    /**
     * Returns a note attached to this transaction.
     *
     * @return A note.
     */
    String getNote();

    /**
     * Causes this internal transaction to be marked as rejected so that {@code isRejected() ==
     * true}. Once an internal transaction is marked as rejected it cannot be un-marked.
     */
    void markAsRejected();

    byte[] getEncoded();
}
