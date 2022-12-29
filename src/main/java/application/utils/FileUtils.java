package application.utils;

import java.nio.file.Path;

public class FileUtils {
    private FileUtils() { }

    public static boolean isValidFile(final Path rootDirectory) {
        return rootDirectory.toFile().isDirectory();
    }
}
