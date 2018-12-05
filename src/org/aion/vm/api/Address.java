package org.aion.vm.api;

import java.util.Arrays;
import org.aion.vm.api.utils.HexUtilities;

public final class Address {

    //TODO: class is not immutible ... do we want it to be? Then array copying.
    //TODO: otherwise we need to document this, bc technically zero_address can alter..

    /**
     * The number of bytes in an {@code Address}.
     */
    public static final int SIZE = 32;

    public static final Address ZERO_ADDRESS = new Address(new byte[SIZE]);

    private final byte[] address;

    public Address(byte[] address) {
        if (address == null) {
            throw new NullPointerException("Cannot create address from null bytes.");
        }
        if (address.length != SIZE) {
            throw new IllegalArgumentException("Invalid address size: " + address.length);
        }
        this.address = address;
    }

    public Address(String address) {
        this(HexUtilities.hexStringToBytes(address));
    }

    public Address wrap(byte[] address) {
        return new Address(address);
    }

    public Address wrap(String address) {
        return new Address(address);
    }

    public byte[] toBytes() {
        return this.address;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Address)) {
            return false;
        }
        Address otherAsAddress = (Address) other;
        return Arrays.compare(this.address, otherAsAddress.address) == 0;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.address);
    }

    @Override
    public String toString() {
        return "Address { 0x" + HexUtilities.bytesToHexString(this.address) + " }";
    }

}
