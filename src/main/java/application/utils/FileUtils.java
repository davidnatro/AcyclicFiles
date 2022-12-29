package application.utils;

import java.nio.file.Path;

public class FileUtils {
    private FileUtils() { }

    public static boolean isValidDirectory(final Path rootDirectory) {
        return rootDirectory.toFile().isDirectory();
    }
}
