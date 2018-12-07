package org.aion.vm.api.interfaces;

public interface TransactionContext {

    TransactionSideEffects getSideEffects();

    Address getDestinationAddress();

    Address getSenderAddress();

    Address getOriginAddress();

    Address getMinerAddress();

    DataWordStub getTransferValue();

    DataWordStub getTransactionEnergyPrice();

    DataWordStub getBlockDifficulty();

    byte[] getTransactionData();

    byte[] getTransactionHash();

    byte[] getHashOfOriginTransaction();

    long getBlockNumber();

    long getBlockTimestamp();

    long getBlockEnergyLimit();

    long getTransactionEnergyLimit();

    int getTransactionKind();

    int getTransactionStackDepth();

    int getFlags();

    void setTransactionHash(byte[] hash);

    void setDestinationAddress(Address address);

    byte[] toBytes();

}
