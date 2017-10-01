package pl.slovvik;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

public class App {

    private String fileName;
    private String fileString;

    public App() {
    }

    public App(String fileName) {
        this.fileName = fileName;
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

    public String readFileName(BufferedReader reader) throws IOException {
        System.out.print("Please specify file name: ");
        fileName = reader.readLine();
        if (fileName == null || fileName.length() == 0) throw new ReadFileNameException("");
        return fileName;
    }

    public String readStuff() throws IOException {
        if (fileName != null && !fileName.equals("")) {
            InputStream targetFile = getClass().getClassLoader().getResourceAsStream(fileName);
            if (targetFile != null) {
                fileString = IOUtils.toString(targetFile, "UTF-8");
                targetFile.close();
            } else {
                throw new ReadStuffException("Cannot find file");
            }
        } else throw new ReadFileNameException("Cannot find file with empty file name");
        return fileString;
    }

    public String deleteWhitespace(String fileString) {
        return StringUtils.deleteWhitespace(String.valueOf(fileString));
    }
}
