package io.bs.libmagicnum;

import java.util.Arrays;

class ByteComparator implements MagicNumberComparator{

    @Override
    public boolean compareBytes(byte[] inputBytes, byte[] testBytes, Integer offset) {
        return Arrays.equals( Arrays.copyOf(testBytes, inputBytes.length), inputBytes );
    }
}
