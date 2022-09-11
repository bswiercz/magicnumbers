package io.bs.magicnumbers;

import io.bs.libmagicnum.FileLoader;
import io.bs.libmagicnum.FileType;
import io.bs.libmagicnum.MagicTypes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LibMagicNumbersTest {

    private final MagicTypes magicTypes = new MagicTypes();

    @Test
    @DisplayName("GIF match test")
    void gifTest() throws IOException, URISyntaxException {
        URL imageGif = getClass().getClassLoader().getResource("imageGIF89a.gif");
        byte[] loadedFileBytes = FileLoader.loadFile(new File(imageGif.toURI()));
        Assertions.assertEquals( FileType.GIF, magicTypes.findTypeByBytes(loadedFileBytes) );
    }


    @Test
    @DisplayName("JPEG match test")
    void jpgTest() throws IOException, URISyntaxException {
        URL imageGif = getClass().getClassLoader().getResource("image.jpg");
        byte[] loadedFileBytes = FileLoader.loadFile(new File(imageGif.toURI()));
        Assertions.assertEquals( FileType.JPG, magicTypes.findTypeByBytes(loadedFileBytes) );
    }


    @Test
    @DisplayName("Txt match test")
    void textFileTest() throws IOException, URISyntaxException {
        URL imageTxt = getClass().getClassLoader().getResource("plaintext.txt");
        byte[] loadedFileBytes = FileLoader.loadFile(new File(imageTxt.toURI()));
        Assertions.assertEquals( FileType.TXT, magicTypes.findTypeByBytes(loadedFileBytes) );
    }
}
