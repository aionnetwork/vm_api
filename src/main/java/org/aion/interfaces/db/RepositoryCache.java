package org.aion.interfaces.db;

import java.math.BigInteger;
import org.aion.types.Address;
import org.aion.types.ByteArrayWrapper;


/**
 * Repository interface for individual account additions and updates.
 *
 * @implNote Tracking a repository should be done through implementing this interface.
 */
public interface RepositoryCache<AS, BSB> extends Repository<AS, BSB> {

    // setters relating to user accounts
    // -------------------------------------------------------------------------------

    /**
     * Creates a new account state in the database or cache.
     *
     * @param address the address of the account to be created
     * @return a {@link AS} object storing the newly created account state
     */
    AS createAccount(Address address);

    /**
     * Deletes the account from the cache and database.
     *
     * @param address the address of the account to be deleted
     * @implNote This method only marks the account for deletion. Removing the account from the
     *     database is done at the next flush operation.
     */
    void deleteAccount(Address address);

    /**
     * Increases by one the account associated with the given address.
     *
     * @param address the address of the account of interest
     * @return the updated value of the nonce
     */
    BigInteger incrementNonce(Address address);

    /**
     * Sets to a specific value the nonce of the account associated with the given address.
     *
     * @param address the address of the account of interest
     * @return the updated nonce value for the account
     */
    BigInteger setNonce(Address address, BigInteger nonce);

    /**
     * Adds the given value to the balance of the account associated with the given address.
     *
     * @param address the address of the account of interest
     * @param value to be added to the balance
     * @return the updated balance for the account
     */
    BigInteger addBalance(Address address, BigInteger value);

    // setters relating to contracts
    // -----------------------------------------------------------------------------------

    /**
     * Stores code associated with an account.
     *
     * @param address the address of the account of interest
     * @param code the code that will be associated with this account
     * @implNote Calling this method on already initialized code should leave the account and
     *     contract state unaltered.
     */
    void saveCode(Address address, byte[] code);

    // setters relating to storage
    // -------------------------------------------------------------------------------------

    /**
     * Store the given data at the given key in the account associated with the given address.
     *
     * @param address the address of the account of interest
     * @param key the key at which the data will be stored
     * @param value the data to be stored
     */
    void addStorageRow(Address address, ByteArrayWrapper key, ByteArrayWrapper value);

    /**
     * Remove the given storage key from the account associated with the given address.
     *
     * @param address the address of the account of interest
     * @param key the key for which the data will be removed
     */
    void removeStorageRow(Address address, ByteArrayWrapper key);

    void flushTo(Repository repo, boolean clearStateAfterFlush);
}
