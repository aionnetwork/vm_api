package org.aion.interfaces.block;

import java.util.List;
import org.aion.interfaces.tx.TransactionExtend;

/** @author jin */
public interface Block<TX extends TransactionExtend, BH extends BlockHeader> {

    long getNumber();

    byte[] getParentHash();

    byte[] getHash();

    byte[] getEncoded();

    String getShortHash();

    boolean isEqual(Block<TX, BH> block);

    String getShortDescr();

    List<TX> getTransactionsList();

    BH getHeader();

    /**
     * Newly added with the refactory of API for libNc, both chains should have implemented this
     *
     * @return the ReceiptsRoot represent as a byte array
     */
    byte[] getReceiptsRoot();

    long getTimestamp();
}
