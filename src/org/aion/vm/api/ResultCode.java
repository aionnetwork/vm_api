package org.aion.vm.api;

import java.util.HashMap;
import java.util.Map;

/**
 * An enumeration representing the execution status of a transaction.
 */
public enum ResultCode {

    SUCCESS(0, ResultCategory.SUCCESS),

    INVALID_NONCE(101, ResultCategory.REJECTED),

    INVALID_ENERGY_LIMIT(102, ResultCategory.REJECTED),

    INSUFFICIENT_BALANCE(103, ResultCategory.REJECTED),

    VM_INTERNAL_ERROR(-2, ResultCategory.FAILED),

    VM_REJECTED(-1, ResultCategory.REJECTED),

    OUT_OF_ENERGY(2, ResultCategory.FAILED),

    BAD_INSTRUCTION(3, ResultCategory.FAILED),

    BAD_JUMP_DESTINATION(4, ResultCategory.FAILED),

    STACK_OVERFLOW(5, ResultCategory.FAILED),

    STACK_UNDERFLOW(6, ResultCategory.FAILED),

    REVERT(7, ResultCategory.FAILED),

    STATIC_MODE_ERROR(8, ResultCategory.FAILED),

    FAILED_INVALID_DATA(9, ResultCategory.FAILED),

    UNCAUGHT_EXCEPTION(10, ResultCategory.FAILED),

    ABORT(11, ResultCategory.FAILED),

    FAILED(12, ResultCategory.FAILED);

    private enum ResultCategory {SUCCESS, REJECTED, FAILED }

    private static Map<Integer, ResultCode> integerMapping = new HashMap<>();
    private ResultCategory category;
    private int value;

    static {
        for (ResultCode code : ResultCode.values()) {
            integerMapping.put(code.value, code);
        }
    }

    ResultCode(int value, ResultCategory category) {
        this.value = value;
        this.category = category;
    }

    public boolean isSuccess() {
        return this.category == ResultCategory.SUCCESS;
    }

    public boolean isRejected() {
        return this.category == ResultCategory.REJECTED;
    }

    public boolean isFailed() {
        return this.category == ResultCategory.FAILED;
    }

    public int toInt() {
        return this.value;
    }

    public ResultCode fromInt(int code) {
        ResultCode result = integerMapping.get(code);
        if (result == null) {
            throw new IllegalArgumentException("No ResultCode whose integer representation is: " + code);
        }
        return result;
    }

}
