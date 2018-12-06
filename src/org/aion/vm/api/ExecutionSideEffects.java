package org.aion.vm.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.aion.vm.api.interfaces.Address;
import org.aion.vm.api.interfaces.IExecutionLog;
import org.aion.vm.api.interfaces.InternalTransactionInterface;

public final class ExecutionSideEffects {
    private List<InternalTransactionInterface> internalTransactions;
    private List<Address> addressesForDeletion;
    private List<IExecutionLog> executionLogs;

    public ExecutionSideEffects() {
        this.internalTransactions = new ArrayList<>();
        this.addressesForDeletion = new ArrayList<>();
        this.executionLogs = new ArrayList<>();
    }

    /**
     * Adds the internal transactions, addresses for deletion, and logs of {@code sideEffects} to
     * this {@code ExecutionSideEffects} object.
     *
     * @param sideEffects The side-effects to merge into this object.
     */
    public void mergeSideEffects(ExecutionSideEffects sideEffects) {
        if (sideEffects != null) {
            this.internalTransactions.addAll(sideEffects.internalTransactions);
            this.addressesForDeletion.addAll(sideEffects.addressesForDeletion);
            this.executionLogs.addAll(sideEffects.executionLogs);
        }
    }

    public void addInternalTransaction(InternalTransactionInterface internalTransaction) {
        this.internalTransactions.add(internalTransaction);
    }

    public void addInternalTransactions(List<InternalTransactionInterface> internalTransactions) {
        this.internalTransactions.addAll(internalTransactions);
    }

    public void markAddressForDeletion(Address address) {
        this.addressesForDeletion.add(address);
    }

    public void markAddressesForDeletion(Collection<Address> addresses) {
        this.addressesForDeletion.addAll(addresses);
    }

    public void addExecutionLog(IExecutionLog log) {
        this.executionLogs.add(log);
    }

    public void addExecutionLogs(Collection<IExecutionLog> logs) {
        this.executionLogs.addAll(logs);
    }

    public List<InternalTransactionInterface> getInternalTransactions() {
        return this.internalTransactions;
    }

    public List<Address> getAddressesMarkedForDeletion() {
        return this.addressesForDeletion;
    }

    public List<IExecutionLog> getExecutionLogs() {
        return this.executionLogs;
    }

    @Override
    public String toString() {
        return "ExecutionSideEffects { internal transactions = " + this.internalTransactions
            + ", addresses marked for deletion = " + this.addressesForDeletion
            + ", execution logs = " + this.executionLogs + " }";
    }

}
