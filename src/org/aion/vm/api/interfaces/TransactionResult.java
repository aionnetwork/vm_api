package org.aion.vm.api.interfaces;

public interface TransactionResult {

    KernelInterface getKernelInterface();

    ResultCode getResultCode();

    byte[] getOutput();

    long getEnergyRemaining();

    void setKernelInterface(KernelInterface kernel);

    void setResultCode(ResultCode resultCode);

    void setOutput(byte[] output);

    void setEnergyRemaining(long energyRemaining);

    byte[] toBytes();

    //TODO: document the fromBytes static

}
