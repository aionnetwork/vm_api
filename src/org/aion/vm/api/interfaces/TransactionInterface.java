package org.aion.vm.api.interfaces;

public interface TransactionInterface {

    byte[] getTransactionHash();

    Address getSenderAddress();

    Address getDestinationAddress();

    byte[] getNonce();

    byte[] getValue();

    byte[] getData();

    byte getTransactionType();

    long getEnergyLimit();

    long getEnergyPrice();

    byte[] getTimestamp();

    boolean isContractCreationTransaction();

}
