package io.bs.libmagicnum;

import java.util.Arrays;
import java.util.List;

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

    public static FileType fromMimeType(String mimeType) {
        return Arrays.stream(FileType.values())
                .filter( fileType -> mimeType.equals(fileType.mimeType) )
                .findAny()
                .orElse(FileType.UNKNOWN);
    }
    public static FileType fromExtension(String path) {
        String ext = path.substring(path.lastIndexOf('.')+1);
        return Arrays.stream(FileType.values())
                .filter( fileType -> fileType.extensions.contains(ext) )
                .findAny()
                .orElse(FileType.UNKNOWN);
    }
}
