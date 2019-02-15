package org.aion.vm.api.interfaces;

import java.math.BigInteger;
import org.aion.type.api.interfaces.Address;

public interface TransactionContext {

    TransactionSideEffects getSideEffects();

    TransactionInterface getTransaction();

    Address getDestinationAddress();

    Address getContractAddress();

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
