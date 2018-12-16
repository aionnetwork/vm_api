package org.aion.vm.api.interfaces;

import java.math.BigInteger;

public interface TransactionContext {

    TransactionSideEffects getSideEffects();

    TransactionInterface getTransaction();

    Address getDestinationAddress();

    Address getSenderAddress();

    Address getOriginAddress();

    Address getMinerAddress();

    BigInteger getTransferValue();

    byte[] getTransactionData();

    byte[] getTransactionHash();

    byte[] getHashOfOriginTransaction();

    long getBlockNumber();

    long getBlockTimestamp();

    long getBlockEnergyLimit();
    long getTransactionEnergy();

    long getTransactionEnergyPrice();

    long getBlockDifficulty();

    int getTransactionKind();

    int getTransactionStackDepth();

    int getFlags();

    void setTransactionHash(byte[] hash);

    void setDestinationAddress(Address address);

    byte[] toBytes();

}
