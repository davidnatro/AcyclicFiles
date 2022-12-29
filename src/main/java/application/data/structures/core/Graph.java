package application.data.structures.core;

import java.nio.file.Path;

public interface Graph {
    /**
     * Добавляет ноду в граф.
     * @param filePath Путь до файла(ноды).
     */
    void addNode(Path filePath);

    /**
     * Добавляет направленное ребро от ноды fromNode к ноде toNode.
     * @param fromNode Нода от которой идет ребро.
     * @param toNode Нода к которой идет ребро.
     */
    void addEdge(Path fromNode, Path toNode);
}
