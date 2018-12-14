package org.aion.vm.api.interfaces;

public interface ResultCode {

    String name();

    boolean isSuccess();

    // Condition must be met: isRevert() == true => isFailed() == true
    boolean isFailed();

    boolean isRejected();

    boolean isFatal();

    boolean isRevert();

    int toInt();

    //TODO: document the expected fromInt static

}