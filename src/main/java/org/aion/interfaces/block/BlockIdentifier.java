package org.aion.interfaces.block;

/** @author jay */
public interface BlockIdentifier {

    byte[] getHash();

    long getNumber();
}
