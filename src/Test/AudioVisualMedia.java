/*
package Test;

import Module.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Module.AudioVisualMedia;
import Module.Media;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AudioVisualMediaTest {

    private AudioVisualMedia audioVisualMedia;

    @BeforeEach
    public void setUp() {
        List<String> whereWatch = Arrays.asList("Netflix", "Amazon Prime");
        audioVisualMedia = new AudioVisualMedia("Inception", 2010, 2012, 1, 10, "inception", whereWatch);
    }
    @Test
    public void testGetOriginalTitle() {
        assertEquals("Inception", audioVisualMedia.getOriginalTitle());
    }

    @Test
    public void testSetOriginalTitle() {
        audioVisualMedia.setOriginalTitle("Interstellar");
        assertEquals("Interstellar", audioVisualMedia.getOriginalTitle());
    }

    @Test
    public void testGetWhereWatch() {
        List<String> expectedWhereWatch = Arrays.asList("Netflix", "Amazon Prime");
        assertEquals(expectedWhereWatch, audioVisualMedia.getWhereWatch());
    }

    @Test
    public void testSetWhereWatch() {
        List<String> newWhereWatch = Arrays.asList("HBO Max", "Disney+");
        audioVisualMedia.setWhereWatch(newWhereWatch);
        assertEquals(newWhereWatch, audioVisualMedia.getWhereWatch());
    }
}

 */