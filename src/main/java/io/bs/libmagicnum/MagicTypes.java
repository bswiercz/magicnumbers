package io.bs.libmagicnum;

import io.bs.libmagicnum.comparators.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MagicTypes {
    private List<MagicType> magicTypes = Arrays.asList(
            new MagicType("GIF89a Graphics Interchange Format", new byte[]{71, 73, 70, 56, 57, 97}, 0, "image/gif", new ByteComparator()),
            new MagicType("JPEG Joint Photographic Experts Group", new byte[]{71, 73, 70, 56, 57, 97}, 0, "image/jpeg", new ByteComparator()),
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
            type.findTypeByBytes(inputBytes);
        }
    }
}
