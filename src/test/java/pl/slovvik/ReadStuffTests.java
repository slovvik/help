package pl.slovvik;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReadStuffTests {

    private static final String FILE_TEXT = "d fd fafda fads f";

    private App app;

    @Before
    public void setUp() {
        app = new App();
    }

    @Test(expected = ReadFileNameException.class)
    public void fileNameIsEmpty() throws Exception {
        String readStuff = app.readStuff();
        assertNull(readStuff);
    }

    @Test(expected = ReadFileNameException.class)
    public void fileNameIsNull() throws Exception {
        String readStuff = app.readStuff();
        assertNull(readStuff);
    }

    @Test(expected = ReadStuffException.class)
    public void fileNotExist() throws Exception {
        app = new App("noFile");
        String readStuff = app.readStuff();
        assertNull(readStuff);
    }

    @Test
    public void fileWithOutText() throws Exception {
        app = new App("noText.txt");
        String readStuff = app.readStuff();
        assertNotNull(readStuff);
    }

    @Test
    public void fileWithText() throws Exception {
        app = new App("Text.txt");
        String readStuff = app.readStuff();
        assertNotNull(readStuff);
        assertEquals(readStuff, FILE_TEXT);
    }
}
