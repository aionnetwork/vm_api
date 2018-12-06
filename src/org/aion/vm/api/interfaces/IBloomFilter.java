package org.aion.vm.api.interfaces;

public interface IBloomFilter {

    byte[] getBloomFilterBytes();

    void or(IBloomFilter otherBloomFilter);

    void and(IBloomFilter otherBloomFilter);

    boolean matches(IBloomFilter otherBloomFilter);

    boolean contains(IBloomFilter otherBloomFilter);

}
