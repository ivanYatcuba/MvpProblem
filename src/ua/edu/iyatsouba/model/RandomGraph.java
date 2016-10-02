package ua.edu.iyatsouba.model;

import java.util.Set;

public class RandomGraph implements Graph {

    private Set<Vertex> vertices;
    private Set<Edge> edges;

    public RandomGraph(Set<Vertex> vertices, Set<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    @Override
    public Set<Vertex> getVertexes() {
        return vertices;
    }

    @Override
    public Set<Edge> getEdges() {
        return edges;
    }
}
