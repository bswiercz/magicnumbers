package io.bs.differentiator;

import io.bs.libmagicnum.FileLoader;
import io.bs.libmagicnum.FileType;
import io.bs.libmagicnum.MagicTypes;

import java.io.File;
import java.io.IOException;

public class FileDifferentiator {
    public static void main(String[] args) {
        if(args.length > 0) {
            MagicTypes magicTypes = new MagicTypes();
            for (String path : args) {
                File file = new File(path);
                byte[] loadedFileBytes = new byte[0];
                try {
                    loadedFileBytes = FileLoader.loadFile(file);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                FileType foundType = magicTypes.findTypeByBytes(loadedFileBytes);
                FileType fromExtension = FileType.fromExtension(path);

                if( fromExtension == FileType.UNKNOWN && foundType == FileType.UNKNOWN ) {
                    System.out.println("Not able to verify this file, file type unknown");
                }
                else if(fromExtension == FileType.UNKNOWN) {
                    System.out.format("Not able to verify this file, but file type is %s", foundType.mimeType);
                }
                else {
                    if( fromExtension == foundType ) {
                        System.out.format("File is %s and is consistent with its extension", foundType.mimeType);
                    }
                    else {
                        System.out.format("File is NOT VALID %s file, but is %s by magic number", FileType.fromExtension(path).mimeType, foundType.mimeType);
                    }
                }


            }
        }
        else {
            System.out.println("usage: filediff /path/to/file [.../path/to/file2 [...]]");
        }
    }
}
