package secondChance.graph;

import java.util.*;

/*
        This algorithm is to find the minimum spanning tree.
 */
public class PrimsAlgorithm {


    public static void main(String[] args) throws Exception {

        Graph graph = new Graph(false);
        buildGraph(graph);
        primsAlgorithm(graph, new Node(0));
    }

    public static void primsAlgorithm(Graph graph, Node start) {

        HashSet<Node> visited = new HashSet<>();
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        addEdges(graph, start, pq, visited);
        int totalVertex = graph.size() - 1;
        int cost = 0;
        int counter = 0;
        List<Node> edgeList = new ArrayList<>();
        edgeList.add(start);

        while(!pq.isEmpty() && counter != totalVertex) {
            pq.forEach(v -> System.out.println(Arrays.toString(v)));
            Integer[] in = pq.poll();

            if(visited.contains(new Node(in[1]))) {
                continue;
            }

            cost += in[2];
            edgeList.add(new Node(in[1]));
            addEdges(graph, new Node(in[1]),pq,visited);
            counter++;
            System.out.println("\n");

        }

        System.out.println(edgeList + " ==== > " + cost);

    }

    public static void addEdges(Graph graph, Node node, PriorityQueue<Integer[]> pq, HashSet<Node> visited) {

        visited.add(node);

        List<Edge> neighbours = graph.getNeighbours(node);

        for(Edge edge: neighbours) {
            if(visited.contains(edge.destination)) {
                continue;
            }
            Integer[] in = new Integer[3];
            in[0] = node.value;
            in[1] = edge.destination.value;
            in[2] = edge.weight;
            pq.add(in);
        }

    }


    public static void buildGraph(Graph graph) throws Exception {
       // Node zero = new Node(0);
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        graph.addNode(zero);
        graph.addNode(one);
        graph.addNode(two);
        graph.addNode(three);
        graph.addNode(four);
        graph.addNode(five);
        graph.addNode(six);
        graph.addNode(seven);

        graph.addEdge(zero, one, 10);
        graph.addEdge(zero, three, 4);
        graph.addEdge(zero, two, 1);

        graph.addEdge(one, four, 0);
        graph.addEdge(one, two, 3);

        graph.addEdge(two, three, 2);
        graph.addEdge(two, five, 8);

        graph.addEdge(three, five, 2);
        graph.addEdge(three, six, 7);

        graph.addEdge(four, five, 1);
        graph.addEdge(four, seven, 8);

        graph.addEdge(five, seven, 9);
        graph.addEdge(five, six, 6);

        graph.addEdge(six,seven, 12);

    }


}


