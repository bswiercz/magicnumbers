package io.bs.magicnumbers.libmagicnum;

public class MagicType {
    private final String name;
    private final byte[] magicNumberBytes;
    private final String mimeType;

    public MagicType(String name, byte[] magicNumberBytes, String mimeType) {
        this.name = name;
        this.magicNumberBytes = magicNumberBytes;
        this.mimeType = mimeType;
    }
}
