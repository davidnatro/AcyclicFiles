package application;

import application.constants.Menu;
import application.data.structures.EdgeList;
import application.data.structures.core.Graph;
import application.utils.FileUtils;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public final class App {
    private static final Scanner scanner = new Scanner(System.in);

    private static Path getRootDirectory() {
        System.out.print(Menu.ROOT_DIRECTORY_INPUT + " ");
        return Paths.get(scanner.nextLine());
    }

    public void run() {
        Path rootDirectory = getRootDirectory();
        if (rootDirectory.toString().equals(Menu.QUIT_COMMAND) || !FileUtils.isValidFile(rootDirectory)) {
            return;
        }

        Graph edgeList = new EdgeList(rootDirectory);
    }
}
