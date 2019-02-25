package org.aion.interfaces.block;

import java.math.BigInteger;

/** @author jay */
public interface PowBlockHeader extends BlockHeader {

    byte[] getDifficulty();

    BigInteger getDifficultyBI();

    void setDifficulty(byte[] _diff);

    byte[] getPowBoundary();
}
