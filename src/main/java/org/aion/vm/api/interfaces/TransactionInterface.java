package main.java.org.aion.vm.api.interfaces;

import java.math.BigInteger;
import main.java.org.aion.vm.api.Address;

public interface TransactionInterface {

    byte[] getTransactionHash();

    Address getSenderAddress();

    Address getDestinationAddress();

    BigInteger getNonce();

    byte[] getValue();

    byte[] getData();

    byte getTransactionType();

    long getEnergyLimit();

    long getEnergyPrice();

    byte[] getTimestamp();

    boolean isContractCreationTransaction();

}
