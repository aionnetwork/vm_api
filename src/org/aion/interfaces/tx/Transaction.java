package org.aion.interfaces.tx;

import java.math.BigInteger;
import org.aion.vm.api.interfaces.TransactionInterface;

public interface Transaction extends Cloneable, TransactionInterface {

    byte[] getEncoded();

    void setEncoded(byte[] _encodedData);

    BigInteger getNonceBI();

    BigInteger getTimeStampBI();

    Transaction clone();

    long getNrgConsume();

    void setNrgConsume(long _nrg);
}
