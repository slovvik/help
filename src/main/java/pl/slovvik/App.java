package pl.slovvik;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class App {

    private String fileName;
    private String fileString;

    public App() {
    }

    public App(String fileName, String fileString) {
        this.fileName = fileName;
        this.fileString = fileString;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileString() {
        return fileString;
    }

    public void setFileString(String fileString) {
        this.fileString = fileString;
    }

    public String readFileName(BufferedReader reader) throws Exception {
        fileName = reader.readLine();
        if (fileName == null || fileName.length() == 0) throw new ReadFileNameException("");
        return fileName;
    }

    public String readStuff(String fileName) throws IOException {
        InputStream targetFile;
        targetFile = getClass().getResourceAsStream(fileName);
        if (targetFile != null) {
            fileString = IOUtils.toString(targetFile, "UTF-8");
        }
        return fileString;
    }


    public String deleteWhitespace(String fileString) {
        String updatedText = StringUtils.deleteWhitespace(String.valueOf(fileString));
        return updatedText;
    }
}
