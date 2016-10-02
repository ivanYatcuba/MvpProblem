package ua.edu.iyatsouba.util;

import ua.edu.iyatsouba.model.Edge;
import ua.edu.iyatsouba.model.Graph;
import ua.edu.iyatsouba.model.RandomGraph;
import ua.edu.iyatsouba.model.Vertex;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class GraphReader {

    public Optional<Graph> readGraph(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
        File file;
        if(url != null) {
           file = new File(url.getFile());
        } else {
            return Optional.empty();
        }


        final boolean[] isNotFirsLine = {false};
        try (Stream<String> stream = Files.lines(file.toPath())) {

            Set<Vertex> vertexSet = new HashSet<>();
            Set<Edge> edges = new HashSet<>();


            stream.forEach(s -> {
                if(isNotFirsLine[0]) {
                    String[] params = s.split(" ");
                    String vertexAStr =  params[1];
                    String vertexBStr =  params[2];

                    int vertexAId = Integer.parseInt(vertexAStr);
                    int vertexBId = Integer.parseInt(vertexBStr);

                    Vertex vertexA = new Vertex(vertexAId);
                    Vertex vertexB = new Vertex(vertexBId);

                    vertexSet.add(vertexA);
                    vertexSet.add(vertexB);

                    edges.add(new Edge(vertexA, vertexB));
                } else {
                    isNotFirsLine[0] = true;
                }


            });
            return Optional.of(new RandomGraph(vertexSet, edges));
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
