package org.aion.interfaces.block;

import java.util.List;
import org.aion.interfaces.tx.Transaction;

/** @author jin */
public interface BlockInterface {

    BlockHeader getHeader();

    List<Transaction> getTransactionsList();

    boolean isEqual(BlockInterface block);
}
