package ua.edu.iyatsouba.model;

import java.util.Objects;

public class Edge {

    private Vertex vertexA;
    private Vertex vertexB;

    public Edge(Vertex vertexA, Vertex vertexB) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
    }

    public Vertex getVertexA() {
        return vertexA;
    }

    public Vertex getVertexB() {
        return vertexB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(vertexA, edge.vertexA) &&
                Objects.equals(vertexB, edge.vertexB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertexA, vertexB);
    }
}
