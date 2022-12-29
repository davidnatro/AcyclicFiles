package application.data.structures;

import application.exceptions.CyclicGraphException;
import application.constants.Errors;
import application.data.structures.core.Graph;
import application.utils.FileUtils;

import java.nio.file.Path;
import java.util.*;

public class EdgeList implements Graph {
    private final Map<Path, List<Path>> edges = new HashMap<Path, List<Path>>();

    public EdgeList(final Path rootDirectory) {
        edges.putIfAbsent(rootDirectory, new ArrayList<Path>());
    }

    @Override
    public void addNode(Path filePath) {
        edges.putIfAbsent(filePath, new ArrayList<Path>());
    }

    @Override
    public void addEdge(Path node, Path edge) throws CyclicGraphException {
        if (!edges.containsKey(node)) {
            throw new NoSuchElementException(Errors.NODE_NOT_IN_GRAPH);
        }

        if (!FileUtils.isValidFile(edge)) {
            throw new IllegalArgumentException(Errors.FILE_IS_DIR_OR_NOT_FOUND);
        }

        for (final Path keyNode : edges.keySet()) {
            if (keyNode.equals(edge)) {
                throw new CyclicGraphException(Errors.CYCLIC_GRAPH);
            }
        }

        edges.get(node).add(edge);
    }

    @Override
    public void sort() {

    }
}
