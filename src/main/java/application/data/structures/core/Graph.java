package application.data.structures.core;

import application.exceptions.CyclicGraphException;

import java.nio.file.Path;

public interface Graph {
    /**
     * Проверка графа на наличие циклов.
     * @return true, если в графе есть цикл, иначе false.
     */
    boolean hasCyclicDependency();

    /**
     * Добавляет ноду в граф.
     * @param filePath Путь до файла(ноды).
     */
    void addNode(final Path filePath);

    /**
     * Добавляет направленное ребро от ноды fromNode к ноде toNode.
     * @param fromNode Нода от которой идет ребро.
     * @param toNode Нода к которой идет ребро.
     */
    void addEdge(final Path fromNode, final Path toNode) throws CyclicGraphException;

    void sort();
}
