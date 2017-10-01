package pl.slovvik;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class DeleteSpacesTests {

    private App app;

    @Before
    public void setUp() {
        app = new App("Text.txt");
    }

    @Test
    public void fileTextShouldNotConsistSpaces() throws Exception {
        app.readStuff();
        String textWithOutSpaces = app.deleteWhitespace();
        assertFalse(textWithOutSpaces.contains("\\s"));
    }
}
