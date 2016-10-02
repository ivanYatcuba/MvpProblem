package ua.edu.iyatsouba.model;

import java.util.Objects;

public class Vertex {

    private int vertexId;

    public Vertex(int vertexId) {
        this.vertexId = vertexId;
    }

    public int getVertexId() {
        return vertexId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(vertexId, vertex.vertexId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertexId);
    }
}
