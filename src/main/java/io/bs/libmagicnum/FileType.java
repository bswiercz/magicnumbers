package io.bs.libmagicnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum FileType {
    GIF("image/gif", "gif"),
    JPG("image/jpeg", "jpg", "jpeg", "jpe", "jif", "jfif", "jfi"),
    TXT("text/plain", "txt"),
    UNKNOWN("other");

    public final String mimeType;
    public final List<String> extensions;

    FileType(String mimeType, String... extension) {
        this.mimeType = mimeType;
        extensions = Arrays.asList(extension);
    }

    public static FileType findByMimeType(String mimeType) {
        return Arrays.stream(FileType.values())
                .filter( fileType -> mimeType.equals(fileType.mimeType) )
                .findAny()
                .orElse(FileType.UNKNOWN);
    }
}
