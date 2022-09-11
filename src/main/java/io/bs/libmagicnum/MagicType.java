package io.bs.libmagicnum;

class MagicType {
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

    public FileType findTypeByBytes(byte[] inputBytes) {
        boolean result = magicNumberComparator.compareBytes(inputBytes, magicNumberBytes, offset);
        if(result) {
            return FileType.fromMimeType(mimeType);
        }
        else {
            return FileType.UNKNOWN;
        }
    }

    public String getMimeType() {
        return mimeType;
    }
}
