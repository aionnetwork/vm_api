package org.aion.type;

import java.util.Arrays;
import org.aion.interfaces.Bytesable;
import org.aion.util.HexConvert;

/**
 * The address class is a byte array wrapper represent fixed-32bytes array for the kernel account
 * (public key) has more security compare with 20bytes address blockchain system.
 *
 * @author jay
 */
public final class Address implements Comparable<Address>, Bytesable<Address>, Cloneable {
    private static final short SIZE = 32;
    private static final Address zeroAddr = Address.wrap(new byte[SIZE]);
    private static final Address emptyAddr = Address.wrap(new byte[0]);

    private byte[] address;
    private int hashCode = 0;

    public Address(final byte[] in) {

        if (in == null) {
            throw new IllegalArgumentException("Null input!");
        }

        if (in.length != SIZE && in.length != 0) {
            throw new IllegalArgumentException();
        }

        setupData(in);
    }

    public Address(final ByteArrayWrapper in) {

        if (in == null) {
            throw new IllegalArgumentException("Null input!");
        }

        byte[] data = in.getData();
        if (data == null || (data.length != SIZE && data.length != 0)) {
            throw new IllegalArgumentException();
        }

        setupData(data);
    }

    public Address(final String in) {

        if (in == null) {
            throw new IllegalArgumentException();
        }

        byte[] hexByte = HexConvert.hexStringToBytes(in);

        if (hexByte.length != SIZE && hexByte.length != 0) {
            throw new IllegalArgumentException();
        }

        setupData(hexByte);
    }

    public static Address wrap(final byte[] addr) {
        return new Address(addr);
    }

    public static Address wrap(final String addr) {
        return new Address(addr);
    }

    public static Address wrap(final ByteArrayWrapper addr) {
        return new Address(addr);
    }

    public static Address ZERO_ADDRESS() {
        return zeroAddr;
    }

    public static Address EMPTY_ADDRESS() {
        return emptyAddr;
    }

    private void setupData(final byte[] in) {
        this.address = in;
        this.hashCode = Arrays.hashCode(in);
    }

    @Override
    public final String toString() {
        return HexConvert.bytesToHexString(address);
    }

    public final ByteArrayWrapper toByteArrayWrapper() {
        return ByteArrayWrapper.wrap(this.address);
    }

    @Override
    public final byte[] toBytes() {
        return this.address;
    }

    @Override
    public final Address clone() {
        if (this.address.length == 0) {
            return emptyAddr;
        } else {
            return new Address(Arrays.copyOf(this.address, SIZE));
        }
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Address)) {
            return false;
        } else {
            byte[] otherAddress = ((Address) other).toBytes();
            return Arrays.equals(this.address, otherAddress);
        }
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }

    @Override
    public int compareTo(Address o) {
        return Arrays.compare(this.address, o.toBytes());
    }

    public int compareTo(byte[] o) {
        return Arrays.compare(this.address, o);
    }

    @Override
    public final Address fromBytes(byte[] bs) {
        return new Address(bs);
    }

    public boolean isEmptyAddress() {
        return Arrays.equals(address, emptyAddr.toBytes());
    }

    public boolean isZeroAddress() {
        return Arrays.equals(address, zeroAddr.toBytes());
    }
}
