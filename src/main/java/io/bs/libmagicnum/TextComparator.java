package io.bs.libmagicnum;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

class TextComparator implements MagicNumberComparator{
    @Override
    public boolean compareBytes(byte[] inputBytes, byte[] testBytes, Integer offset) {
        String testBytesStr = new String(testBytes, StandardCharsets.UTF_8);
        String inputBytesStr = new String(inputBytes, StandardCharsets.UTF_8);
        return inputBytesStr.substring(offset).contains(testBytesStr);
    }
}
