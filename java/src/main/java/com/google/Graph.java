package com.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingQueue;

public class Graph {

    Map<String,Set<String>> map = null;

    public static void main(String[] args) {

        Map<String, Set<String>> map = new ConcurrentHashMap<>();
        Graph graph = new Graph(map);
        graph.addVertex("Chennai");
        graph.addVertex("Banglore");
        graph.addVertex("Cochin");
        graph.addVertex("Hyderabad");
        graph.addVertex("Delhi");
        graph.addEdge("Chennai","Delhi");
        graph.addEdge("Chennai","Banglore");
        graph.addEdge("Banglore","Hyderabad");
        graph.addEdge("Cochin","Chennai");
        graph.addEdge("Delhi","Banglore");
        graph.addEdge("Delhi","Chennai");
        graph.addEdge("Hyderabad","Banglore");
        System.out.println(graph.map);
        graph.removeEdge("Banglore","Chennai");
        System.out.println(graph.map);

//        graph.removeVertex("chennai");
        List<String> neighbours = new ArrayList<>();
        List<String> neighbours1 = new ArrayList<>();
        graph.dfs("banglore", new HashMap<>(), neighbours);
        graph.bfs("banglore",new HashMap<>(), neighbours1);
        System.out.println(neighbours);
        System.out.println(neighbours1);

    }


    public void bfs(String vertex, Map<String,Boolean> visited, List<String> neighbours) {
        if(!map.containsKey(vertex)) {
            return;
        }

        Queue<String> queue = new LinkedBlockingQueue<>();
        queue.add(vertex);
        while(!queue.isEmpty()) {
            String ver = queue.poll();
            neighbours.add(ver);
            visited.put(ver,true);
            if(map.containsKey(ver) ) {
                for(String s: map.get(ver)) {
                    if(visited.containsKey(s)){
                        continue;
                    } else {
                        queue.add(s);
                    }

                }
            }
        }

    }

    public void dfs(String vertex, Map<String,Boolean> bool, List<String> neighbours) {

        if(!map.containsKey(vertex)) {
            return;
        }

        bool.put(vertex,true);
        neighbours.add(vertex);

        for(String str: map.get(vertex)) {
            if(bool.containsKey(str)) {
                continue;
            }
            dfs(str,bool,neighbours);
       }

    }

    public Graph( Map<String,Set<String>> vertex ) {
        this.map = vertex;
    }

    public void addVertex(String vertexName) {

        this.map.put(vertexName.toLowerCase(), new ConcurrentSkipListSet<>());

    }

    public void removeVertex(String vertex1) {

        if(map.containsKey(vertex1.toLowerCase())) {
            Set<String> set = map.get(vertex1.toLowerCase());
            for(String s: set) {
                removeEdge(s,vertex1);
            }
        }
        map.remove(vertex1);
    }


    public void removeEdge(String vertex1, String vertex2) {
        if(map.containsKey(vertex1.toLowerCase())) {
            Set<String> set = map.get(vertex1.toLowerCase());
            set.remove(vertex2.toLowerCase());
            map.put(vertex1.toLowerCase(),set);
        }

        if(map.containsKey(vertex2.toLowerCase())) {
            Set<String> set = map.get(vertex2.toLowerCase());
            set.remove(vertex1.toLowerCase());
            map.put(vertex2.toLowerCase(),set);
        }
    }

    public void addEdge(String vertex1, String vertex2) {
        this.map.compute(vertex1.toLowerCase(), (k,v) -> {
            if( v == null ) {
                Set<String> list =  new ConcurrentSkipListSet<>();
                list.add(vertex2.toLowerCase());
                return list;
            } else {
                v.add(vertex2.toLowerCase());
            }
            return v;
        });

        this.map.compute(vertex2.toLowerCase(), (k,v) -> {
            if( v == null ) {
                Set<String> list =  new ConcurrentSkipListSet<>();
                list.add(vertex1.toLowerCase());
            } else {
                v.add(vertex1.toLowerCase());
            }
            return v;
        });
    }


}
