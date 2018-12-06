package org.aion.vm.api.interfaces;

import java.math.BigInteger;

public interface TransactionInterface {

    byte[] getTransactionHash();

    Address getSenderAddress();

    Address getDestinationAddress();

    BigInteger getNonce();

    //TODO: decide: BigInteger or byte[]?
    byte[] getValue();

    byte[] getData();

    byte getTransactionType();

    long getEnergyLimit();

    long getEnergyPrice();

    //TODO: should this be a byte[]? It is long everywhere else..
    byte[] getTimestamp();

    boolean isContractCreationTransaction();

}
