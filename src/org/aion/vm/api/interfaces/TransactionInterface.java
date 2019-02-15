package org.aion.vm.api.interfaces;

import org.aion.type.api.interfaces.Address;

public interface TransactionInterface {

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
