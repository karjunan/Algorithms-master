package secondChance.graph;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BellmanFordAlgorithm {

    public static void main(String[] args) throws Exception {
        Graph graph = new Graph(true);
        buildGraph(graph);
        Set<Node> vertex = graph.getNodes();
        List<Edge> edges = graph.getEdges();
        int[] result = computeSSSP(graph, vertex, edges);
        System.out.println("Result is =====>> " + Arrays.toString(result));
    }

    private static int[] computeSSSP(Graph graph, Set<Node> vertex, List<Edge> edges) {

        int [] result = new int[vertex.size() + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        result[1] = 0;

       //edges = edges.stream().sorted((k,v) -> Integer.compare(k.source.value, v.source.value)).collect(Collectors.toList());

        for(int i = 0; i < result.length-1; i++) {
            for(int j = 0; j < edges.size(); j++) {
                Node source = edges.get(j).source;
                Node destination = edges.get(j).destination;
                int weight = edges.get(j).weight;

                result[destination.value] = Integer.min(result[destination.value], result[source.value]  + weight);

            }
        }
        System.out.println(Arrays.toString(result));
        //System.out.println(" Trying to detect cycle !! ");

        for(int i = 0; i < result.length-1; i++) {
            for(int j = 0; j < edges.size(); j++) {
                Node source = edges.get(j).source;
                Node destination = edges.get(j).destination;
                int weight = edges.get(j).weight;
                if(result[destination.value] > result[source.value]  + weight) {
                    result[destination.value] = Integer.MAX_VALUE;
                    System.out.println(" A cycle is found !!");
                    break;
                }

            }
        }
        System.out.println(Arrays.toString(result));

        return result;
    }


    public static void buildGraph(Graph graph) throws Exception {
        // Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        graph.addNode(one);
        graph.addNode(two);
        graph.addNode(three);
        graph.addNode(four);
        graph.addNode(five);
        graph.addNode(six);
        graph.addNode(seven);


        graph.addEdge(one, two, 6);
        graph.addEdge(one, three, 5);
        graph.addEdge(one, four, 5);

        graph.addEdge(two, five, -1);

        graph.addEdge(three, two, -2);
        graph.addEdge(three, five, 1);

        graph.addEdge(four, three, -2);
        graph.addEdge(four, six, -1);

        graph.addEdge(five, seven, 3);
        graph.addEdge(five, three, 1);

        graph.addEdge(six, seven, 3);

    }

}
