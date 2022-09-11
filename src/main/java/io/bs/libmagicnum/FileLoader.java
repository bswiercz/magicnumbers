package io.bs.libmagicnum;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileLoader {

    public static int BYTES_TO_READ = 32;

    public FileType loadFileAndAnalyze(File inputFile) throws IOException {
        if (!inputFile.exists()) {
            throw new IOException("Specified file does not exist");
        }
        if (!inputFile.canRead()) {
            throw new IOException("Cannot read specified file (do you have enough permissions?)");
        }

        int bytesToRead = BYTES_TO_READ;
        long filesize = inputFile.length();

        if(filesize < BYTES_TO_READ) {
            bytesToRead = (int) filesize;
        }

        FileInputStream input;
        byte[] readBytes = new byte[bytesToRead];
        input = new FileInputStream(inputFile);
        int readLength = input.readNBytes(readBytes, 0, bytesToRead);

        if(readLength <= 0) {
            System.out.println("No meta info for filename");
        }

        if(readLength < readBytes.length) {
            readBytes = Arrays.copyOf(readBytes, readLength);
        }
        return MagicTypes;
    }
}
