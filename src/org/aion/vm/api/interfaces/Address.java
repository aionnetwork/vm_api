package org.aion.vm.api.interfaces;

/** A {@value SIZE}-byte sized public-facing account address. */
public interface Address {

    /** The number of bytes in an {@code Address}. */
    int SIZE = 32;

    /**
     * The bytes that make up the {@code Address}.
     *
     * @return The bytes of the address.
     */
    byte[] toBytes();

    boolean isEmptyAddress();

    boolean isZeroAddress();
}
