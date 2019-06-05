package org.aion.vm.api.interfaces;

import java.math.BigInteger;
import org.aion.types.AionAddress;

/**
 * The contextual information required by a {@link VirtualMachine} relating to a specific
 * transaction.
 */
public interface TransactionContext {

    // TODO: much of these methods are already provided by transaction and since we can recover the
    // TODO: transaction we should work towards removing all of these duplicate methods in the next
    // TODO: version.

    /**
     * Returns the transaction to whom this context applies.
     *
     * @return The transaction.
     */
    TransactionInterface getTransaction();

    /**
     * Returns the side-effects that were the result of executing the corresponding transaction.
     *
     * @return The execution side-effects of the transaction.
     */
    TransactionSideEffects getSideEffects();

    /**
     * Returns the destination address as specified by the transaction.
     *
     * @return The transaction destination address or null if no destination.
     */
    AionAddress getDestinationAddress();

    /**
     * Returns the address of the account that sent this transaction.
     *
     * @return The sender address.
     */
    AionAddress getSenderAddress();

    /**
     * Returns the address of the account that sent the original external transaction to which
     * either this transaction is a descendant of, or which this transaction is.
     *
     * @return The origin address.
     */
    AionAddress getOriginAddress();

    /**
     * Returns the address of the miner.
     *
     * @return The miner's address.
     */
    AionAddress getMinerAddress();

    /**
     * Returns the amount of value to be transferred by the corresponding transaction.
     *
     * @return The amount of value to transfer.
     */
    BigInteger getTransferValue();

    /**
     * Returns the corresponding transaction data.
     *
     * @return The transaction data.
     */
    byte[] getTransactionData();

    /**
     * Returns the hash of the corresponding transaction.
     *
     * @return The transaction hash.
     */
    byte[] getTransactionHash();

    /**
     * Returns the hash of the original external transaction to which this corresponding transaction
     * is a descent or else is this same transaction.
     *
     * @return The original transaction hash.
     */
    byte[] getHashOfOriginTransaction();

    /**
     * Returns the number of the block to which this corresponding transaction belongs.
     *
     * @return The block number.
     */
    long getBlockNumber();

    /**
     * Returns the timestamp of the block to which this corresponding transaction belongs.
     *
     * @return The block timestamp.
     */
    long getBlockTimestamp();

    // TODO: block energy limit can probably be removed.

    /**
     * Returns the energy limit of the block to which this corresponding transaction belongs.
     *
     * @return The block energy limit.
     */
    long getBlockEnergyLimit();

    /**
     * Returns the energy limit of this corresponding transaction minus the basic transaction cost.
     *
     * @return The energy limit minus the cost.
     */
    long getTransactionEnergy();

    /**
     * Returns the energy price of this corresponding transaction.
     *
     * @return The energy price of the transaction.
     */
    long getTransactionEnergyPrice();

    /**
     * Returns the difficulty of the block to which this corresponding transaction belongs.
     *
     * @return The block difficulty.
     */
    long getBlockDifficulty();

    // TODO: may be better to use an object here instead of a somewhat meaningless int?

    /**
     * Returns the kind of the corresponding transaction. For example, CREATE or CALL.
     *
     * @return The transaction kind.
     */
    int getTransactionKind();

    /**
     * Returns the depth into the stack at which the corresponding transaction sits.
     *
     * @return The stack depth.
     */
    int getTransactionStackDepth();

    // TODO: can we remove flags (& stack depth?) from this API?

    /**
     * Returns the flags for the corresponding transaction.
     *
     * @return The transaction flags.
     */
    int getFlags();

    // TODO: can we remove these setters?

    void setTransactionHash(byte[] hash);

    void setDestinationAddress(AionAddress address);

    byte[] toBytes();
}
