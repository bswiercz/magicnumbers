package io.bs.libmagicnum.comparators;

public interface MagicNumberComparator {
    boolean compareBytes(byte[] inputBytes, int offset);
}