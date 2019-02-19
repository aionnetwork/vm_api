package org.aion.interfaces.tx;

import java.math.BigInteger;
import org.aion.types.Address;

/** @author jin */
public interface TransactionExtend extends Cloneable, Transaction {

    byte[] getEncoded();

    BigInteger getNonceBI();

    BigInteger getTimeStampBI();

    TransactionExtend clone();

    long getNrgConsume();

    void setEncoded(byte[] _encodedData);

    void setNrgConsume(long _nrg);

    Address getContractAddress();
}
