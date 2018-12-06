package org.aion.vm.api.interfaces;

import java.math.BigInteger;

/**
 * An interface into the statefulness of the kernel.
 */
public interface KernelInterface {

    //TODO: better name for this class?

    /**
     * Creates an account with the specified address.
     *
     * @param address The account to create.
     */
    void createAccount(Address address);

    /**
     * Returns true if, and only if, the specified address has account state. That is, it has a
     * positive nonce or balance or contains contract code.
     *
     * @param address The address whose existence is to be decided.
     * @return True if the account exists.
     */
    boolean hasAccountState(Address address);

    /**
     * Sets the code of an account.
     *
     * @param address the account address
     * @param code    the immortal code
     */
    void putCode(Address address, byte[] code);

    /**
     * Retrieves the code of an account.
     *
     * @param address the account address
     * @return the code of the account, or NULL if not exists.
     */
    byte[] getCode(Address address);

    /**
     * Put a key-value pair into the account's storage.
     *
     * @param address the account address
     * @param key     the storage key
     * @param value   the storage value
     */
    void putStorage(Address address, byte[] key, byte[] value);

    /**
     * Get the value that is mapped to the key, for the given account.
     *
     * @param address the account address
     * @param key     the storage key
     */
    byte[] getStorage(Address address, byte[] key);

    /**
     * Deletes an account.
     * This is used to implement the self-destruct functionality.
     *
     * @param address the account address
     */
    void deleteAccount(Address address);

    /**
     * Returns the balance of an account.
     *
     * @param address the account address
     * @return The balance of the specified address.
     */
    BigInteger getBalance(Address address);

    /**
     * Adds/removes the balance of an account.
     *
     * @param address the account address
     * @param delta   the change
     */
    void adjustBalance(Address address, BigInteger delta);

    /**
     * Returns the nonce of an account.
     *
     * @param address the account address
     * @return the nonce
     */
    long getNonce(Address address);

    /**
     * Increases the nonce of an account by 1.
     *
     * @param address the account address
     */
    void incrementNonce(Address address);

    /**
     * Returns {@code true} if, and only if, the specified address has a nonce equal to the provided
     * nonce.
     *
     * @param address The address whose nonce is to be compared.
     * @param nonce The nonce to compare against the account's nonce.
     * @return True if the nonce of the address equals the given nonce.
     */
    boolean accountNonceEquals(Address address, long nonce);

    /**
     * Returns {@code true} if, and only if, the specified address has funds that are greater than
     * or equal to the provided amount.
     *
     * @param address The address whose balance is to be compared.
     * @param amount The amount to compare against the account's balance.
     * @return True if the balance of the account is {@code >=} amount.
     */
    boolean accountBalanceIsAtLeast(Address address, BigInteger amount);

    /**
     * Returns {@code true} if, and only if, the specified energy limit is a valid quantity for a
     * contract creation transaction.
     *
     * This is a kernel-level concept, and the correct energy rules will be injected into the vm by
     * the kernel-side implementation of this interface.
     *
     * This check should only be performed in exactly ONE place, immediately before an external
     * transaction is actually run.
     *
     * @param energyLimit The energy limit to validate.
     * @return True if the energy limit is a valid quantity.
     */
    boolean isValidEnergyLimitForCreate(long energyLimit);

    /**
     * Returns {@code true} if, and only if, the specified energy limit is a valid quantity for a
     * transaction that is not for contract creation.
     *
     * This is a kernel-level concept, and the correct energy rules will be injected into the vm by
     * the kernel-side implementation of this interface.
     *
     * This check should only be performed in exactly ONE place, immediately before an external
     * transaction is actually run.
     *
     * @param energyLimit The energy limit to validate.
     * @return True if the energy limit is a valid quantity.
     */
    boolean isValidEnergyLimitForNonCreate(long energyLimit);


}
