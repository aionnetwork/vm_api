package org.aion.interfaces.tx;

import java.util.List;

/** @author jay */
public interface TxReceipt<TX extends Transaction, LOG> {
    void setTransaction(TX tx);

    void setLogs(List<LOG> logs);

    void setNrgUsed(long nrg);

    void setExecutionResult(byte[] result);

    void setError(String error);
}
