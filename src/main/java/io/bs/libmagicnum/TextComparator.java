package io.bs.libmagicnum;

class TextComparator implements MagicNumberComparator{
    @Override
    public boolean compareBytes(byte[] inputBytes, byte[] testBytes, Integer offset) {
        return testBytes.toString().substring(offset).contains(inputBytes.toString());
    }
}
