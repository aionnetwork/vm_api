package org.aion.vm.api.interfaces;

import java.util.List;
import org.aion.type.api.interfaces.Address;

/**
 * A log that is emitted during the execution of a transaction. The source of an execution log is
 * the {@link Address} of the smart contract in which this log event was triggered.
 *
 * <p>Each log has a list of topics and some data.
 */
public interface IExecutionLog {

    Address getSourceAddress();

    List<byte[]> getTopics();

    byte[] getData();

    IBloomFilter getBloomFilterForLog();

    byte[] getEncoded();

}
