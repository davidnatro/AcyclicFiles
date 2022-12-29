package application.data.structures;

import application.data.structures.core.Graph;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EdgeList implements Graph {
    private final Path rootDirectory;

    private Map<Path, List<Path>> edges = new HashMap<Path, List<Path>>();

    public EdgeList(final Path rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    @Override
    public void addNode() {

    }

    @Override
    public void addEdge(Node node) {

    }
}
