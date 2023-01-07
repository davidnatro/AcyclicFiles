package application;

import application.constants.Commands;
import application.constants.Errors;
import application.constants.Menu;
import application.data.structures.EdgeList;
import application.exceptions.CyclicGraphException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileConnector {
    private final EdgeList edgeList;
    private final Path rootDirectory;

    public FileConnector(final Path rootDirectory) {
        edgeList = new EdgeList();
        edgeList.addNode(rootDirectory);

        this.rootDirectory = rootDirectory;
    }

    private Path parseRequire(final String require) {
        return Path.of(require);
    }

    private void printSortedList(final List<Path> sortedList) throws IOException {
        for (final Path file : sortedList) {
            System.out.println(Files.readAllLines(file));
        }
    }

    public void scan() {
        File[] rootFiles = rootDirectory.toFile().listFiles();

        for (final File file : rootFiles) {
            edgeList.addNode(file.toPath());

            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String input = null;

                while ((input = reader.readLine()) != null) {
                    String[] words = input.split(" ");
                    if (words[0].equals(Commands.REQUIRE)) {
                        edgeList.addEdge(file.toPath(), parseRequire(words[1]));
                    }
                }

            } catch (final FileNotFoundException exception) {
                System.out.println(Errors.FILE_IS_DIR_OR_NOT_FOUND);
                return;
            } catch (final IOException exception) {
                System.out.println(Errors.ACCESS_DENIED);
                return;
            } catch (final CyclicGraphException exception) {
                System.out.println(Errors.CYCLIC_GRAPH);
                return;
            } catch (final Exception exception) {
                System.out.println(Errors.FILE_IS_DIR_OR_NOT_FOUND);
                return;
            }
        }

        List<Path> sortedList = edgeList.sortedList();

        try {
            printSortedList(sortedList);
        } catch (final IOException exception) {
            System.out.println(Errors.FILE_IS_DIR_OR_NOT_FOUND);
        }
    }
}
