package pl.slovvik;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReadFileTest {

    private App app;
    private BufferedReader reader;

    @Before
    public void setUp() {
        app = new App();
        reader = mock(BufferedReader.class);
    }

    @Test(expected = ReadFileNameException.class)
    public void fileNameIsEmptyString() throws Exception {
        when(reader.readLine()).thenReturn("");
        String fileName = app.readFileName(reader);
        assertThat(fileName, is(""));
    }

    @Test(expected = ReadFileNameException.class)
    public void fileNameIsNull() throws Exception {
        when(reader.readLine()).thenReturn(null);
        String fileName = app.readFileName(reader);
        assertNull(fileName);
    }

    @Test
    public void fileNameShouldBeOk() throws Exception {
        when(reader.readLine()).thenReturn("FileName");
        String fileName = app.readFileName(reader);
        assertThat(fileName, is("FileName"));

    }
}
