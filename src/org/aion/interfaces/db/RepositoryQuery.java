package org.aion.interfaces.db;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.aion.vm.api.types.Address;
import org.aion.vm.api.types.ByteArrayWrapper;

/** Repository interface for information retrieval. */
public interface RepositoryQuery<AS> {

    /**
     * Checks if the database contains an account state associated with the given address.
     *
     * @param address the address of the account of interest
     * @return {@code true} if the account exists, {@code false} otherwise
     */
    boolean hasAccountState(Address address);

    /**
     * Loads the account (and contract) state associated with the given address into the given hash
     * maps.
     *
     * @param address the address of the account of interest
     * @param accounts a map representing a cache of {@link AS} where the account state will be
     *     loaded
     * @param details a map representing a cache of {@link ContractDetails >} where the contract
     *     details will be loaded
     */
    void loadAccountState(
            Address address, Map<Address, AS> accounts, Map<Address, ContractDetails> details);

    /**
     * Retrieves the current state of the account associated with the given address.
     *
     * @param address the address of the account of interest
     * @return a {@link AS} object representing the account state as is stored in the database or
     *     cache
     */
    AS getAccountState(Address address);

    /**
     * Retrieves the current balance of the account associated with the given address.
     *
     * @param address the address of the account of interest
     * @return a {@link BigInteger} value representing the current account balance
     */
    BigInteger getBalance(Address address);

    /**
     * Retrieves the current nonce of the account associated with the given address.
     *
     * @param address the address of the account of interest
     * @return a {@link BigInteger} value representing the current account nonce
     */
    BigInteger getNonce(Address address);

    /**
     * Checks if the database contains contract details associated with the given address.
     *
     * @param addr the address of the account of interest
     * @return {@code true} if there are contract details associated with the account, {@code false}
     *     otherwise
     */
    boolean hasContractDetails(Address addr);

    /**
     * Retrieves the contract details of the account associated with the given address.
     *
     * @param addr the address of the account of interest
     * @return a {@link ContractDetails} object representing the contract details as are stored in
     *     the database or cache
     */
    ContractDetails getContractDetails(Address addr);

    /**
     * Retrieves the code for the account associated with the given address.
     *
     * @param address the address of the account of interest
     * @return the code associated to the account in {@code byte} array format
     */
    byte[] getCode(Address address);

    /**
     * Retrieves the transformed code for the account associated with the given address.
     *
     * @param address the address of the account of interest
     * @return the transformed code associated to the account in {@code byte} array format
     */
    byte[] getTransformedCode(Address address);

    /**
     * Returns the transaction type used to deploy the contract indicating which VM was used.
     *
     * @return the transaction type used to deploy the contract indicating which VM was used
     */
    InternalVmType getVmType(Address contract);

    /**
     * Returns a byte array from contract storage representing an encoding of the object graph for
     * the given contract.
     *
     * @param contract the account address
     * @return a byte array from contract storage representing an encoding of the object graph for
     *     the given contract
     */
    byte[] getObjectGraph(Address contract);

    /**
     * Retrieves the entries for the specified key values stored at the account associated with the
     * given address.
     *
     * @param address the address of the account of interest
     * @param keys the collection of keys of interest (which may be {@code null})
     * @return the storage entries for the specified keys, or the full storage if the key collection
     *     is {@code null}
     * @apiNote When called with a null key collection, the method retrieves all the storage keys.
     */
    Map<ByteArrayWrapper, ByteArrayWrapper> getStorage(
            Address address, Collection<ByteArrayWrapper> keys);

    //    /**
    //     * Retrieves the storage size the account associated with the given address.
    //     *
    //     * @param address
    //     *            the address of the account of interest
    //     * @return the number of storage entries for the given account
    //     */
    //    int getStorageSize(Address address);
    //
    //    /**
    //     * Retrieves all the storage keys for the account associated with the given
    //     * address.
    //     *
    //     * @param address
    //     *            the address of the account of interest
    //     * @return the set of storage keys, or an empty set if the given account
    //     *         address does not exist
    //     */
    //    Set<ByteArrayByteArrayWrapper> getStorageKeys(Address address);

    /**
     * Retrieves the stored value for the specified key stored at the account associated with the
     * given address.
     *
     * @param address the address of the account of interest
     * @param key the key of interest
     * @return a {@link ByteArrayWrapper} representing the data associated with the given key
     */
    ByteArrayWrapper getStorageValue(Address address, ByteArrayWrapper key);

    /**
     * Retrieves the stored transactions for recovering pool tx.
     *
     * @return the list of transactions encoded bytes.
     */
    List<byte[]> getPoolTx();

    /**
     * Retrieves the stored transactions for recovering caching tx.
     *
     * @return the list of transactions encoded bytes.
     */
    List<byte[]> getCacheTx();
}
