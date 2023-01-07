package application.data.structures;

import application.constants.Errors;
import application.data.structures.core.Graph;
import application.exceptions.CyclicGraphException;
import application.utils.FileUtils;

import java.nio.file.Path;
import java.util.*;

public class EdgeList implements Graph {
    private final Map<Path, List<Path>> edges = new HashMap<Path, List<Path>>();

    public EdgeList(final Path rootDirectory) {
        edges.putIfAbsent(rootDirectory, new ArrayList<Path>());
    }

    /**
     * Получение всех родительских нод (пути) определенной ноды.
     * @param node Нода.
     * @return Список родитесльких нод.
     */
    private List<Path> getNodesParents(final Path node) {
        List<Path> nodes = new ArrayList<Path>();
        for (final Path keyNode : edges.keySet()) {
            if (edges.get(keyNode).contains(node)) {
                nodes.add(keyNode);
                nodes.addAll(getNodesParents(keyNode));
            }
        }
        return nodes;
    }

    @Override
    public boolean hasCyclicDependency(final Path edge) {
        final List<Path> parentNodes = getNodesParents(edge);

        for (final Path parentNode : parentNodes) {
            if (edge.equals(parentNode)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void addNode(final Path filePath) {
        edges.putIfAbsent(filePath, new ArrayList<Path>());
    }

    @Override
    public void addEdge(final Path node, final Path edge) throws CyclicGraphException, NoSuchElementException, IllegalArgumentException {
        if (!edges.containsKey(node)) {
            throw new NoSuchElementException(Errors.NODE_NOT_IN_GRAPH);
        }

        if (!FileUtils.isValidFile(edge)) {
            throw new IllegalArgumentException(Errors.FILE_IS_DIR_OR_NOT_FOUND);
        }

        if (hasCyclicDependency(edge)) {
            throw new CyclicGraphException(Errors.CYCLIC_GRAPH);
        }

        edges.get(node).add(edge);
    }

    @Override
    public void sort() {

    }
}
