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
                FileType typeByBytes = magicTypes.findTypeByBytes(loadedFileBytes);

            }
        }
        else {
            System.out.println("usage: filediff /path/to/file [.../path/to/file2 [...]]");
        }
    }
}
