package secondChance.graph;

import java.util.*;

public class Graph {
    static Map<Node, List<Edge>> root = null;
    boolean isDirected = false;

    Graph(boolean isDirected) {
        root = new HashMap<>();
        this.isDirected = isDirected;
    }

    public void bfs(Node root, HashSet<Node> visited) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if(visited.contains(current)) {
                continue;
            }
            visited.add(current);
            System.out.print(current.value+" ");
            List<Edge> list = getNeighbours(current);
            for(Edge n: list) {
                queue.add(n.destination);
            }
        }
        System.out.println("");
    }

    public  void dfs(Node root, HashSet<Node> visited) {
        if(root == null || visited.contains(root)) {
            return;
        }
        visited.add(root);
        System.out.println(root.value + " ");

        List<Edge> neighbours = getNeighbours(root);

        for(Edge neighbour: neighbours) {
            dfs(neighbour.destination, visited);
        }

    }

    public  List<Edge> getNeighbours(Node node) {
        if(!root.containsKey(node)) {
            return new LinkedList<>();
        }

        return  root.get(node);
    }

    public Set<Node> getNodes() {
        return root.keySet();
    }


    public  void addEdge(Node source, Node destination, int weight) throws  Exception {

        if(!root.containsKey(source)) {
            throw new Exception("No source node present with the provided input");
        }

        if(!root.containsKey(destination)) {
            throw new Exception("No destination node present with the provided input");
        }

        List<Edge> neighbours = root.get(source);
        neighbours.add(new Edge(source,destination,weight));
        root.put(source,neighbours);

        if(!isDirected) {
            neighbours = root.get(destination);
            neighbours.add(new Edge(destination,source, weight));
            root.put(destination, neighbours);
        }

    }

    public List<Edge> getEdges() {
        List<Edge> edgeList = new ArrayList<>();
        for(Map.Entry<Node, List<Edge>> map : root.entrySet()) {
            edgeList.addAll(map.getValue());
        }

        return edgeList;
    }

    public  void addNode(Node source) throws  Exception {
        if(root.containsKey(source)) {
            throw  new Exception("source node already exists");
        }
        root.put(source, new LinkedList<>());
    }


    public int size() {
        return root.size();
    }





}
