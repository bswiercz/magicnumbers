package io.bs.libmagicnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum FileType {
    GIF("image/gif", "gif", "giff"),
    JPG("image/jpg", "jpg", "jpeg", "jp2"),
    BMP("image/bitmap", "bmp");

    public final String mimeType;
    public final List<String> extensions;

    FileType(String mimeType, String... extension) {
        this.mimeType = mimeType;
        extensions = Arrays.asList(extension);
    }
}
