package application.data.structures;

import application.data.structures.core.Graph;

import java.nio.file.Path;
import java.util.*;

public class EdgeList implements Graph {
    private final Path rootDirectory;

    private Map<Path, List<Path>> edges = new HashMap<Path, List<Path>>();

    public EdgeList(final Path rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    @Override
    public void addNode(Path filePath) {
        edges.putIfAbsent(filePath, new ArrayList<Path>());
    }

    @Override
    public void addEdge(Path node, Path edge) {
        if (!edges.containsKey(node)) {
            throw new NoSuchElementException("Данный файл отсутвует в графе!");
        }

        edges.get(node).add(edge);
    }
}
