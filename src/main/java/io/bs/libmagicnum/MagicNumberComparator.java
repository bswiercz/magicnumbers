package io.bs.libmagicnum;

interface MagicNumberComparator {
    boolean compareBytes(byte[] inputBytes, byte[] testBytes, Integer offset);
}