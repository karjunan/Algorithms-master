package com.datastructures.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Graph {

    static Map<Vertex,Set<Vertex>> map = new HashMap<>();

    public static void main(String[] args) throws  Exception{
        addVertex("a","b","d");
        addVertex("a","d","d");
        addVertex("d","f","d");
        addVertex("b","c","d");
        addVertex("a","l","d");
        addVertex("f","m","d");
        addVertex("m","n","d");

//        addVertex("b","a","d");

        map.forEach((k,v) -> System.out.println("Key -> " + k.data + " : :  " + v.stream().collect(Collectors.toList())));
        dfs(new Vertex("l"));
    }


    public static void bfs(Vertex v) {


    }

    public static void dfs(Vertex v) {
        if(map.containsKey(v)) {
            Set<Vertex> s = map.get(v);
            Stack<Vertex> stack = s.stream().collect(Collectors.toCollection(Stack::new));
            while(!stack.isEmpty()) {
                Vertex vx = stack.pop();
                System.out.println(vx);
                dfs(vx);
            }
        }

    }

    public static void addVertex(String start, String end, String graphType) throws  Exception {

        Vertex v1 = new Vertex(start);
        Vertex v2 = new Vertex(end);
        if(!map.containsKey(v1) && !map.containsKey(v2)) {
            Set<Vertex> s1 = new HashSet<>();
            s1.add(v2);
            map.put(v1,s1);
        } else if (map.containsKey(v1) && !map.containsKey(v2)) {
            Set<Vertex> s1 = map.get(v1);
            s1.add(v2);
            map.put(v1,s1);
        } else if(graphType.equals("d")) {
            Set<Vertex> s2 = map.get(v2);
            if(s2.contains(v1)) {
                throw new Exception("We cannot build undirected Graph");
            }
        }
    }

    static class Vertex {
        String data;
        int weight;
        int inDegree;
        int outDegree;

        Vertex(String data) {
            this.data = data;
        }

        @Override
        public int hashCode() {
             return data.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Vertex vx = (Vertex)obj;

            if(this.data.equals(vx.data)) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            StringBuffer buffer = new StringBuffer();
            return buffer.append(data).toString();
        }
    }

}


