package io.bs.magicnumbers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class MagicParser {
    private final static int BYTES_TO_READ = 32;

    private final static byte[] GIF = {71, 73, 70, 56, 57, 97};

    byte[] loadFile(File inputFile) throws IOException {

        if (!inputFile.exists()) {
            throw new IOException("Specified file not exist");
        }
        if (!inputFile.canRead()) {
            throw new IOException("Cannot read specified file (you have enough permissions?)");
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
        return readBytes;
    }

    public boolean parseBytesAsGIF89a(File inputFile) throws IOException {
        byte[] inputBytes = loadFile(inputFile);
        return Arrays.equals( Arrays.copyOf(inputBytes, GIF.length), GIF );
    }
}
