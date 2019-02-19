package org.aion.interfaces.block;

import java.util.List;

/** @author jay */
public interface BlockSummary {
    List<?> getReceipts();

    Block getBlock();
}
