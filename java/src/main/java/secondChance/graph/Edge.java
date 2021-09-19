package secondChance.graph;

public class Edge {

    Node source;
    Node destination;

    Integer weight;

    Edge(Node source, Node destination, Integer weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}