package application.utils;

import java.nio.file.Path;

public class FileUtils {
    private FileUtils() { }

    public static boolean isValidDirectory(final Path directory) {
        return directory.toFile().isDirectory();
    }

    public static boolean isValidFile(final Path file) {
        return file.toFile().isFile();
    }
}
