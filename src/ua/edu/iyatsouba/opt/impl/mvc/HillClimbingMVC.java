package ua.edu.iyatsouba.opt.impl.mvc;

import ua.edu.iyatsouba.model.Edge;
import ua.edu.iyatsouba.model.Graph;
import ua.edu.iyatsouba.model.Vertex;
import ua.edu.iyatsouba.opt.Algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class HillClimbingMVC implements Algorithm<MVCSolution, Graph> {

    @Override
    public MVCSolution resolve(Graph data) {
        MVCSolution currentSolution = new MVCSolution(new LinkedHashSet<>(data.getVertexes()));
        boolean found;
        long iterationCount = 0;
        do {
            found = true;
            MVCSolution newSolution = getBestSolution(getNeighbourSolutions(data, currentSolution));
            System.out.println("i: " + iterationCount + " " + newSolution);
            if(newSolution.compareTo(currentSolution) > 0) {
                currentSolution = newSolution;
                found = false;
            }
            iterationCount++;
        } while (!found);
        return currentSolution;
    }


    private Set<MVCSolution> getNeighbourSolutions(Graph graph, MVCSolution MVCSolution) {
        Set<MVCSolution> neighbourSolutionSet = new LinkedHashSet<>();
        neighbourSolutionSet.add(MVCSolution);
        for(Vertex vertex: graph.getVertexes()) {
            MVCSolution potentialSolution = new MVCSolution(new HashSet<>(MVCSolution.getSolution()));
            if(MVCSolution.getSolution().contains(vertex)) {
                potentialSolution.getSolution().remove(vertex);
            } else {
                potentialSolution.getSolution().add(vertex);
            }

            if(isSolutionCorrect(graph, potentialSolution)) {
                neighbourSolutionSet.add(potentialSolution);
            }
        }

        return neighbourSolutionSet;
    }

    private boolean isSolutionCorrect(Graph graph, MVCSolution MVCSolution) {
        for(Edge edge: graph.getEdges()) {
            if (!MVCSolution.getSolution().contains(edge.getVertexA()) && !MVCSolution.getSolution().contains(edge.getVertexB())) {
                return false;
            }
        }
        return true;
    }

    private MVCSolution getBestSolution(Set<MVCSolution> MVCSolutions) {
        MVCSolution MVCSolution = Collections.max(MVCSolutions);

        List<MVCSolution> solutionSet = MVCSolutions.stream().
                filter(solution -> MVCSolution.compareTo(solution) == 0).
                collect(Collectors.toList());

        if(solutionSet.size() == 1) {
            return MVCSolution;
        } else {
            int idx = new Random().nextInt(solutionSet.size());
            return solutionSet.get(idx);
        }
    }

}
