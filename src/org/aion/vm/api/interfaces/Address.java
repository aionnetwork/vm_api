package org.aion.vm.api.interfaces;

/**
 * A public-facing account address.
 *
 * <p>The address consists of {@value SIZE} bytes, which is given by the {@code toBytes()} method.
 *
 * <p>All implementations of this interface must satisfy the following condition: {@code
 * toBytes().length == SIZE}
 */
public interface Address {

    /** The number of bytes in an {@code Address}. */
    int SIZE = 32;

    /**
     * The bytes that make up the {@code Address}.
     *
     * @return The bytes of the address.
     */
    byte[] toBytes();

    // TODO: what is an 'empty address' and how does it differ from a zero address?
    // TODO: this is here for agreeableness with the kernel, but we need to answer this question.

    boolean isEmptyAddress();

    /**
     * Returns {@code true} if, and only if, all of the bytes in this {@code Address} are zero
     * bytes.
     *
     * @return True if this address consists only of zero bytes.
     */
    boolean isZeroAddress();
}
