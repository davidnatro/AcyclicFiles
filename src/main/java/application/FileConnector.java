package application;

import application.data.structures.EdgeList;

import java.nio.file.Path;

public class FileConnector {
    private final EdgeList edgeList;

    public FileConnector(final Path rootDirectory) {
        edgeList = new EdgeList(rootDirectory);
    }

    public FileConnector(final EdgeList edgeList) {
        this.edgeList = edgeList;
    }

    public void scan() {

    }
}
