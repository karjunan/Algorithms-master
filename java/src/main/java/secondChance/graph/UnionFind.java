package secondChance.graph;

import java.util.Arrays;
import java.util.List;

public class UnionFind {


    public static void main(String[] args) throws Exception {
        Graph graph = new Graph(false);
        buildGraph(graph);
        List<Edge> edges = graph.getEdges();
        int vertexSize = graph.size() + 1;
        int [] parent = new int[vertexSize];
        Arrays.fill(parent, -1);

        UnionFind unionFind = new UnionFind();
        edges.sort((k,v)-> Integer.compare(k.source.value,v.source.value));
        for(Edge edge: edges) {
            IndexAndValue id1 = unionFind.find(parent,edge.source.value);
            IndexAndValue id2 = unionFind.find(parent,edge.destination.value);

            System.out.println(id1.index + " == " + + id1.value + " ::: " + id2.index + " === " + id2.value);
            if(id1.index  == id2.index) {
                continue;
            }

            unionFind.union(parent,id1.index, id2.index);
        }



    }

    public  IndexAndValue find(int [] parent, int value) {

        int current = value;
        IndexAndValue indexAndValue = new IndexAndValue(parent[value],value);
        while(current > 0 && current  != parent[current] ) {
            indexAndValue.index = current;
            indexAndValue.value = parent[current];
            current = parent[current];

        }

        return indexAndValue;
    }

    public void union(int [] parent, int node1, int node2) {

        int node1Value = parent[node1] * -1;
        int node2Value = parent[node2] * -1;

        System.out.println(" Node1 Value and Node 2 value " + node1Value + " === " + node2Value);
        System.out.println(Arrays.toString(parent));
        if(node1Value > node2Value) {
            parent[node1] = (node1Value + node1Value) * - 1;
            parent[node2] = node1;
        } else {
            parent[node2] = (node1Value + node1Value) * - 1;
            parent[node1] = node2;
        }
        System.out.println(Arrays.toString(parent));
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
        Node eight = new Node(8);

        graph.addNode(one);
        graph.addNode(two);
        graph.addNode(three);
        graph.addNode(four);
        graph.addNode(five);
        graph.addNode(six);
        graph.addNode(seven);
        graph.addNode(eight);


        graph.addEdge(one, three, 7);
        graph.addEdge(one, two, 1);

        graph.addEdge(two, four, 5);
        graph.addEdge(two, five, 6);

        graph.addEdge(three, four, 2);


        graph.addEdge(five, seven, 9);
        graph.addEdge(five, six, 3);

        graph.addEdge(six, eight,8);

        graph.addEdge(seven, eight,4);




    }
    class IndexAndValue {
        int index;
        int value;
        IndexAndValue(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

}
