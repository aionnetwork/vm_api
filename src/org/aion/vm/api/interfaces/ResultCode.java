package org.aion.vm.api.interfaces;

public interface ResultCode {

    String name();

    boolean isSuccess();

    boolean isFailed();

    boolean isRejected();

    boolean isFatal();

    int toInt();

    //TODO: document the expected fromInt static

}