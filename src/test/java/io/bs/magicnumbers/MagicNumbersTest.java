package io.bs.magicnumbers;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class MagicNumbersTest {

    private final MagicParser magicParser = new MagicParser();

    @Test
    @DisplayName("Simple GIF89a match")
    void simpleMatchGIF89a() throws IOException, URISyntaxException {
        URL imageGif = getClass().getClassLoader().getResource("imageGIF89a.gif");
        Assertions.assertEquals( true, magicParser.parseBytesAsGIF89a(new File(imageGif.toURI())) );
    }
}
