package org.aion.vm.api.interfaces;

import org.aion.type.generic.Address;

/**
 * A transaction.
 *
 * <p>Both internal and external transactions must implement this interface.
 */
public interface TransactionInterface {

    /**
     * The hash of the transaction.
     *
     * @return The transaction hash.
     */
    byte[] getTransactionHash();

    /**
     * Returns the address of the account this transaction was sent by.
     *
     * @return The sender address.
     */
    Address getSenderAddress();

    /**
     * Returns the address of the account this transaction is destined for.
     *
     * @return The destination address.
     */
    Address getDestinationAddress();

    /**
     * Returns the nonce of this transaction, which is the nonce of the sender account.
     *
     * @return The sender's nonce.
     */
    byte[] getNonce();

    /**
     * Returns the amount of value to be transferred by this transaction from the sender to the
     * destination or the newly created contract.
     *
     * @return The value to transfer.
     */
    byte[] getValue();

    /**
     * Returns the transaction data.
     *
     * @return The transaction data.
     */
    byte[] getData();

    /**
     * Returns the byte signifying the {@link VirtualMachine} that must execute this transaction in
     * the case of a new contract creation.
     *
     * @return The deployment VM.
     */
    byte getTargetVM();

    /**
     * Returns the energy limit of this transaction. This is the maximum amount of energy willing to
     * be spent to execute this transaction.
     *
     * @return The energy limit.
     */
    long getEnergyLimit();

    /**
     * Returns the energy price of this transaction. This is the price per unit of energy that the
     * sender is willing to pay to execute this transaction.
     *
     * @return The energy price.
     */
    long getEnergyPrice();

    // TODO: clarify what this does - only for create?
    long getTransactionCost();

    /**
     * Returns the timestamp of this transaction.
     *
     * @return The transaction timestamp.
     */
    byte[] getTimestamp();

    /**
     * Returns {@code true} if, and only if, this transaction will deploy a new smart contract.
     *
     * @return True if this transaction creates a new contract.
     */
    boolean isContractCreationTransaction();
}
