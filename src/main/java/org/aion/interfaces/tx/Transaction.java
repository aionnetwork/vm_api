package org.aion.interfaces.tx;

import org.aion.types.Address;

public interface Transaction {
    byte[] getTransactionHash();

    Address getSenderAddress();

    Address getDestinationAddress();

    byte[] getNonce();

    byte[] getValue();

    byte[] getData();

    byte getTargetVM();

    long getEnergyLimit();

    long getEnergyPrice();

    long getTransactionCost();

    byte[] getTimestamp();

    boolean isContractCreationTransaction();
}
