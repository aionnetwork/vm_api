package main.java.org.aion.vm.api.interfaces;

import java.util.List;
import main.java.org.aion.vm.api.Address;

/**
 * A log that is emitted during the execution of a transaction. The source of an execution log is
 * the {@link Address} of the smart contract in which this log event was triggered.
 *
 * <p>Each log has a list of topics and some data.
 */
public interface IExecutionLog {

    Address getLogSourceAddress();

    List<byte[]> getLogTopics();

    byte[] getLogData();

    BloomFilter getBloomFilterForLog();

}
