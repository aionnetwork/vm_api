package org.aion.type.interfaces;

/** @author jin */
public interface Bytesable<T> {

    byte[] NULL_BYTE = new byte[] {(byte) 0x0};

    byte[] toBytes();

    T fromBytes(byte[] bs);
}
