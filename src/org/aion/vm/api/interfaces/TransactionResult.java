package org.aion.vm.api.interfaces;

public interface TransactionResult {

    KernelInterface getKernelInterface();

    ResultCode getResultCode();

    byte[] getReturnData();

    long getEnergyRemaining();

    void setKernelInterface(KernelInterface kernel);

    void setResultCode(ResultCode resultCode);

    void setReturnData(byte[] returnData);

    void setEnergyRemaining(long energyRemaining);

    byte[] toBytes();

    //TODO: document the fromBytes static

}
