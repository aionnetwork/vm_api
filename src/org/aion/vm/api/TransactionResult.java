package org.aion.vm.api;

import java.util.List;
import org.aion.vm.api.interfaces.InternalTransactionInterface;
import org.aion.vm.api.interfaces.KernelInterface;
import org.aion.vm.api.utils.HexUtilities;

public final class TransactionResult {
    private ExecutionSideEffects sideEffects;
    private KernelInterface kernel;
    private ResultCode code;
    private byte[] output;
    private long energyRemaining;

    /**
     * Constructs a new {@code TransactionResult} with no side-effects, with zero energy remaining,
     * with an empty byte array as its output and {@link ResultCode#SUCCESS} as its result code.
     */
    public TransactionResult() {
        this.sideEffects = new ExecutionSideEffects();
        this.code = ResultCode.SUCCESS;
        this.output = new byte[0];
        this.energyRemaining = 0;
        this.kernel = null;
    }

    /**
     * Constructs a new {@code TransactionResult} with no side-effects and with the specified result
     * code, remaining energy and output.
     *
     * @param code The transaction result code.
     * @param energyRemaining The energy remaining after executing the transaction.
     * @param output The output of executing the transaction.
     */
    public TransactionResult(ResultCode code, long energyRemaining, byte[] output) {
        this.sideEffects = new ExecutionSideEffects();
        this.code = code;
        this.output = output;
        this.energyRemaining = energyRemaining;
        this.kernel = null;
    }

    public void addInternalTransactionsToSideEffects(List<InternalTransactionInterface> internalTransactions) {
        this.sideEffects.addInternalTransactions(internalTransactions);
    }

    public void addSideEffects(ExecutionSideEffects sideEffects) {
        this.sideEffects.mergeSideEffects(sideEffects);
    }

    public void setResultCodeAndEnergyRemaining(ResultCode code, long energyRemaining) {
        this.output = (output == null) ? new byte[0] : output;
        this.energyRemaining = energyRemaining;
    }

    public void setResultCode(ResultCode code) {
        if (code == null) {
            throw new NullPointerException("Cannot set null result code.");
        }
        this.code = code;
    }

    public void setKernelInterface(KernelInterface kernel) {
        this.kernel = kernel;
    }

    public void setOutput(byte[] output) {
        this.output = (output == null) ? new byte[0] : output;
    }

    public void setEnergyRemaining(long energyRemaining) {
        this.energyRemaining = energyRemaining;
    }

    public ExecutionSideEffects getExecutionSideEffects() {
        return this.sideEffects;
    }

    public ResultCode getResultCode() {
        return this.code;
    }

    public byte[] getOutput() {
        return this.output;
    }

    public long getEnergyRemaining() {
        return this.energyRemaining;
    }

    public KernelInterface getKernelInterface() {
        return this.kernel;
    }

    @Override
    public String toString() {
        return "TransactionResult { code = " + this.code
            + ", energy remaining = " + this.energyRemaining
            + ", output = " + HexUtilities.bytesToHexString(this.output) + " }";
    }

    public String toStringWithSideEffects() {
        return "TransactionResult { code = " + this.code
            + ", energy remaining = " + this.energyRemaining
            + ", output = " + HexUtilities.bytesToHexString(this.output)
            + ", side-effects = " + this.sideEffects + " }";
    }

}
