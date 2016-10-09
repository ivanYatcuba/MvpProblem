package ua.edu.iyatsouba.opt.impl.mvc;

import ua.edu.iyatsouba.model.Vertex;
import ua.edu.iyatsouba.opt.Solution;

import java.util.Set;
import java.util.StringJoiner;

public class MVCSolution implements Solution<Set<Vertex>> {

    private Set<Vertex> solution;

    public MVCSolution(Set<Vertex> solution) {
        this.solution = solution;
    }

    @Override
    public Set<Vertex> getSolution() {
        return solution;
    }

    @Override
    public int compareTo(Solution o) {
        Solution<Set<Vertex>> solution2 = (Solution<Set<Vertex>>)o;
        return Integer.compare(this.solution.size(), solution2.getSolution().size()) * -1;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",", "{ ", " }");
        for(Vertex vertex : solution) {
            stringJoiner.add(String.valueOf(vertex.getVertexId()));
        }
        String vertexCount = "Vertex count is " + solution.size() + " ";
        return vertexCount + stringJoiner.toString();
    }
}
