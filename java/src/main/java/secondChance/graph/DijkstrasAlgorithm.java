package secondChance.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DijkstrasAlgorithm {

    public static void main(String[] args) throws Exception{

        Graph graph = new Graph(true);
        buildGraph(graph);
        graph.dfs(new Node(0), new HashSet<>());
        graph.bfs(new Node(0), new HashSet<>());
        dijkstraAlgo(graph, 0);
    }

    public static void dijkstraAlgo(Graph graph, int start) {

        int [] temp = new int[graph.size() + 1];
        Arrays.fill(temp, Integer.MAX_VALUE);
        temp[start] = 0;
        HashSet<Integer> visited = new HashSet<>();
        for(int i = 1; i < graph.size(); i++) {

            List<Edge> list = graph.getNeighbours(new Node(start));
            System.out.println(list.size());
            visited.add(start);
            for(Edge edge: list) {
                int currentWeight = temp[start] + edge.weight;
                if(temp[edge.destination.value] > currentWeight) {
                    temp[edge.destination.value] = currentWeight;
                }
                System.out.println(Arrays.toString(temp));
            }

            start = getMinNode(temp, visited);
        }

        for(int i = 0; i < temp.length; i++) {
            if(temp[i] == Integer.MAX_VALUE) {
                temp[i] = -1;
            }
        }

        System.out.println(Arrays.toString(temp));
    }

    public static int getMinNode(int [] temp, HashSet<Integer> visited ) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 0; i < temp.length; i++) {
            if(visited.contains(i)) {
                continue;
            }

            if(temp[i] < min) {
                min = temp[i];
                index = i;
            }
        }
        return index;
    }

    public static void buildGraph(Graph graph) throws Exception {
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        graph.addNode(zero);
        graph.addNode(one);
        graph.addNode(two);
        graph.addNode(three);
        graph.addNode(four);

        graph.addEdge(zero, one,7);
        graph.addEdge(one, two,6);
        graph.addEdge(one, three,20);
        graph.addEdge(one, four, 3);
        graph.addEdge(two, three, 14);
        graph.addEdge(three, four,2);
    }
}
