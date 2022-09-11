package io.bs.libmagicnum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MagicTypes {
    private List<MagicType> magicTypes = Arrays.asList(
            new MagicType("GIF89a Graphics Interchange Format", new byte[]{71, 73, 70, 56, 57, 97}, 0, "image/gif", new ByteComparator()),
            new MagicType("GIF87a Graphics Interchange Format", new byte[]{0x47, 0x49, 0x46, 0x38, 0x37, 0x61}, 0, "image/gif", new ByteComparator()),
            new MagicType("JPEG Joint Photographic Experts Group", new byte[]{(byte) 255, (byte) 216, (byte) 255}, 0, "image/jpeg", new ByteComparator()),
            new MagicType("plain text", new byte[]{}, 0, "text/plain", new TextComparator())
    );

    public void addMagicType(MagicType magicType) {
        List<String> mimeList = magicTypes.stream()
                .map(magicType1 -> magicType.getMimeType())
                .collect(Collectors.toList());
        if( !mimeList.contains(magicType.getMimeType()) ) {
            this.magicTypes.add(magicType);
        }
    }

    public FileType findTypeByBytes(byte[] inputBytes) {
        for(MagicType type : magicTypes) {
            FileType typeByBytes = type.findTypeByBytes(inputBytes);
            if( typeByBytes != FileType.UNKNOWN ) {
                return typeByBytes;
            }
        }
        return FileType.UNKNOWN;
    }
}
