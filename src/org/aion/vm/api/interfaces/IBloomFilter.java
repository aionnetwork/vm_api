package org.aion.vm.api.interfaces;

public interface IBloomFilter {
    int SIZE = 256;

    byte[] getBloomFilterBytes();

    void or(IBloomFilter otherBloomFilter);

    void and(IBloomFilter otherBloomFilter);

    boolean matches(IBloomFilter otherBloomFilter);

    boolean contains(IBloomFilter otherBloomFilter);

}
