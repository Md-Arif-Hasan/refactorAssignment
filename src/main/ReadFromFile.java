package main;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFromFile {
    String path;

    public ReadFromFile(String path) {
        this.path = path;
    }

    public String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}