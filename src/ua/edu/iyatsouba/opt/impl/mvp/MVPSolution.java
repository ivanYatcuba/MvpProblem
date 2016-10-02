package ua.edu.iyatsouba.opt.impl.mvp;

import ua.edu.iyatsouba.model.Vertex;
import ua.edu.iyatsouba.opt.Solution;

import java.util.Set;
import java.util.StringJoiner;

public class MVPSolution implements Solution<Set<Vertex>> {

    private Set<Vertex> solution;

    public MVPSolution(Set<Vertex> solution) {
        this.solution = solution;
    }

    @Override
    public Set<Vertex> getSolution() {
        return solution;
    }

    @Override
    public int compareTo(Solution o) {
        Solution<Set<Vertex>> solution2 = (Solution<Set<Vertex>>)o;
        return Integer.compare(this.solution.size(), solution2.getSolution().size());
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",", "{ ", " }");
        for(Vertex vertex : solution) {
            stringJoiner.add(String.valueOf(vertex.getVertexId()));
        }
        return stringJoiner.toString();
    }
}
