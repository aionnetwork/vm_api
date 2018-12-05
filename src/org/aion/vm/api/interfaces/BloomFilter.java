package org.aion.vm.api.interfaces;

public interface BloomFilter {

    void or(BloomFilter otherBloomFilter);

    void and(BloomFilter otherBloomFilter);

    boolean matches(BloomFilter otherBloomFilter);

    boolean contains(BloomFilter otherBloomFilter);

}
