package ua.edu.iyatsouba;

import ua.edu.iyatsouba.model.Graph;
import ua.edu.iyatsouba.opt.Algorithm;
import ua.edu.iyatsouba.opt.impl.mvp.HillClimbingMVP;
import ua.edu.iyatsouba.opt.impl.mvp.MVPSolution;
import ua.edu.iyatsouba.util.GraphReader;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        GraphReader graphReader = new GraphReader();
        Optional<Graph> graphOptional = graphReader.readGraph("resources/frb30-15-1.mis");

        if (graphOptional.isPresent()) {
            Graph graph = graphOptional.get();
            System.out.println(" v:" + graph.getVertexes().size() + " e:" + graph.getEdges().size());
            Algorithm<MVPSolution, Graph> algorithm = new HillClimbingMVP();
            System.out.println("Solution is: " + algorithm.resolve(graph));
        }
    }

}
