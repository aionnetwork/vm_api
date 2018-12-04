package main.java.org.aion.vm.api;

import java.math.BigInteger;

public final class TransactionContext {
    private BigInteger blockDifficulty;
    private Address destination, origin, sender, miner;
    private byte[] transactionHash, value, data;
    private long transactionEnergyLimit, transactionEnergyPrice, blockNumber, blockTimestamp, blockEnergyLimit;
    private int depth, kind, flags;

    //TODO: error-checking should be done inside constructor here.

    private TransactionContext(byte[] transactionHash, Address destinationAddress, Address originAddress,
        Address senderAddress, long transactionEnergyLimit, long transactionEnergyPrice, byte[] value,
        byte[] data, int depth, int kind, int flags, Address minerAddress, long blockNumber,
        long blockTimestamp, long blockEnergyLimit, BigInteger blockDifficulty) {

        this.destination = destinationAddress;
        this.origin = originAddress;
        this.sender = senderAddress;
        this.miner = minerAddress;
        this.transactionEnergyLimit = transactionEnergyLimit;
        this.transactionEnergyPrice = transactionEnergyPrice;
        this.value = value;
        this.data = data;
        this.depth = depth;
        this.kind = kind;
        this.flags = flags;
        this.blockNumber = blockNumber;
        this.blockTimestamp = blockTimestamp;
        this.blockEnergyLimit = blockEnergyLimit;
        this.blockDifficulty = blockDifficulty;
        this.transactionHash = transactionHash;
    }

    public byte[] getTransactionHash() {
        return this.transactionHash;
    }

    public Address getTransactionOriginAddress() {
        return this.origin;
    }

    public Address getTransactionSenderAddress() {
        return this.sender;
    }

    public Address getTransactionDestinationAddress() {
        return this.destination;
    }

    public Address getMinerAddress() {
        return this.miner;
    }

    public long getTransactionEnergyLimit() {
        return this.transactionEnergyLimit;
    }

    public long getTransactionEnergyPrice() {
        return this.transactionEnergyPrice;
    }

    public byte[] getTransactionTransferValue() {
        return this.value;
    }

    public byte[] getTransactionData() {
        return this.data;
    }

    public int getTransactionStackDepth() {
        return this.depth;
    }

    public int getTransactionKind() {
        return this.kind;
    }

    public int getTransactionFlags() {
        return this.flags;
    }

    public long getBlockNumber() {
        return this.blockNumber;
    }

    public long getBlockTimestamp() {
        return this.blockTimestamp;
    }

    public long getBlockEnergyLimit() {
        return this.blockEnergyLimit;
    }

    public BigInteger getBlockDifficulty() {
        return this.blockDifficulty;
    }

    public final class Builder {
        private BigInteger blockDifficulty;
        private Address destination, origin, sender, miner;
        private byte[] transactionHash, value, data;
        private long transactionEnergyLimit, transactionEnergyPrice, blockNumber, blockTimestamp, blockEnergyLimit;
        private int depth, kind, flags;

        public void transactionHash(byte[] transactionHash) {
            this.transactionHash = transactionHash;
        }

        public void transactionOriginAddress(Address originAddress) {
            this.origin = originAddress;
        }

        public void transactionSenderAddress(Address senderAddress) {
            this.sender = senderAddress;
        }

        public void transactionDestinationAddress(Address destinationAddress) {
            this.destination = destinationAddress;
        }

        public void minerAddress(Address minerAddress) {
            this.miner = minerAddress;
        }

        public void transactionEnergyLimit(long energyLimit) {
            this.transactionEnergyLimit = energyLimit;
        }

        public void transactionEnergyPrice(long energyPrice) {
            this.transactionEnergyPrice = energyPrice;
        }

        public void transactionTransferValue(byte[] value) {
            this.value = value;
        }

        public void transactionData(byte[] data) {
            this.data = data;
        }

        public void transactionStackDepth(int depth) {
            this.depth = depth;
        }

        public void transactionKind(int kind) {
            this.kind = kind;
        }

        public void transactionFlags(int flags) {
            this.flags = flags;
        }

        public void blockNumber(long blockNumber) {
            this.blockNumber = blockNumber;
        }

        public void blockTimestamp(long timestamp) {
            this.blockTimestamp = timestamp;
        }

        public void blockEnergyLimit(long blockEnergyLimit) {
            this.blockEnergyLimit = blockEnergyLimit;
        }

        public void blockDifficulty(BigInteger difficulty) {
            this.blockDifficulty = difficulty;
        }

        public TransactionContext build() {
            return new TransactionContext(
                this.transactionHash,
                this.destination,
                this.origin,
                this.sender,
                this.transactionEnergyLimit,
                this.transactionEnergyPrice,
                this.value,
                this.data,
                this.depth,
                this.kind,
                this.flags,
                this.miner,
                this.blockNumber,
                this.blockTimestamp,
                this.blockEnergyLimit,
                this.blockDifficulty);
        }

    }

}