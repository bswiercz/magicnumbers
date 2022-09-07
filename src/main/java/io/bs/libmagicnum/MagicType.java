package io.bs.libmagicnum;

import io.bs.libmagicnum.comparators.MagicNumberComparator;

public class MagicType {
    private final String name;
    private final byte[] magicNumberBytes;
    private final Integer offset;
    private final String mimeType;
    private final MagicNumberComparator magicNumberComparator;

    public MagicType(String name, byte[] magicNumberBytes, Integer offset, String mimeType, MagicNumberComparator magicNumberComparator) {
        this.name = name;
        this.magicNumberBytes = magicNumberBytes;
        this.offset = offset;
        this.mimeType = mimeType;
        this.magicNumberComparator = magicNumberComparator;
    }
}
