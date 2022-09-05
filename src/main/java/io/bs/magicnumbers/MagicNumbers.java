package io.bs.magicnumbers;

import java.io.File;
import java.io.IOException;

public class MagicNumbers {

    public static void main(String[] args) {
        MagicParser magicParser = new MagicParser();
        try {
            boolean isgif = magicParser.parseBytesAsGIF(new File("/home/pawlacz/image.gif"));
            System.out.format("%b", isgif);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
