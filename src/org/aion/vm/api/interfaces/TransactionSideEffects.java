package org.aion.vm.api.interfaces;

import java.util.Collection;
import java.util.List;

public interface TransactionSideEffects {

    void merge(TransactionSideEffects sideEffects);

    void markAllInternalTransactionsAsRejected();

    void addInternalTransaction(InternalTransactionInterface transaction);

    void addInternalTransactions(List<InternalTransactionInterface> transactions);

    void addToDeletedAddresses(Address address);

    void addAllToDeletedAddresses(Collection<Address> addresses);

    void addLog(IExecutionLog log);

    void addLogs(Collection<IExecutionLog> logs);

    List<InternalTransactionInterface> getInternalTransactions();

    List<Address> getAddressesToBeDeleted();

    List<IExecutionLog> getExecutionLogs();

}