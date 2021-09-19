package com.afterlongpractise;

import java.lang.reflect.Array;
import java.util.*;

public class GraphTraversal {

    public static void main(String[] args) {
        Integer[][] graph = new Integer[][]{{1,3},{2,3,4},{0},{},{2,5},{}};
        boolean [] visited = new boolean[graph.length];
        List<Integer> list = new ArrayList<>();
//        visit(graph, visited, 0, list);
        System.out.println(list);
        isCyclePresent(graph);
    }

    public static void visit(Integer[][] graph, boolean[] visited, int index, List<Integer> nodes) {

        visited[index] = true;
        nodes.add(index);
        System.out.println(nodes);
        Integer[] neighbours = graph[index];
        for(int val: neighbours) {
            if(visited[val]) {
                continue;
            }
            visit(graph,visited,val,nodes);
        }
    }

    public static void isCyclePresent(Integer[][] graph) {
        System.out.println(Arrays.deepToString(graph));
        Set<Integer> notVisited = new HashSet<>();
        Set<Integer> currentlyVisiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < graph.length; i++) {
            for(int j = 0 ; j < graph[i].length; j++) {
                notVisited.add(graph[i][j]);
            }
        }
        System.out.println(notVisited);
        Iterator<Integer> whiteIterator = notVisited.iterator();
        while(whiteIterator.hasNext()) {
            Integer white = whiteIterator.next();
            boolean isCyclePresent = dfs(white,graph, notVisited, currentlyVisiting, visited);
            if(isCyclePresent) {
                System.out.println("There is a cycle");
                break;
            }
        }
    }

    public static boolean dfs(Integer white, Integer[][] graph, Set<Integer> notVisited,Set<Integer> currentlyVisiting, Set<Integer> visited ) {
        moveWhiteToCurrentlyVisiting(white,notVisited,currentlyVisiting);
        Integer[] neighbours = graph[white];
        for(int val: neighbours) {
            if(visited.contains(white)) {
                continue;
            }

            if(currentlyVisiting.contains(val)) {
                return true;
            }

            if(dfs(val,graph,notVisited,currentlyVisiting,visited)) {
                return true;
            }


        }
        moveFromCurrentlyVisitingToVisited(white,currentlyVisiting,visited);
        return false;
    }

    private static void moveFromCurrentlyVisitingToVisited(Integer white, Set<Integer> currentlyVisiting, Set<Integer> visited) {
        currentlyVisiting.remove(white);
        visited.add(white);
    }

    private static void moveWhiteToCurrentlyVisiting(Integer white, Set<Integer> notVisited, Set<Integer> currentlyVisiting) {
        HashSet<Integer> notVisitedNew = new HashSet<>(notVisited);
        notVisitedNew.remove(white);
        notVisited.addAll(notVisitedNew);
        currentlyVisiting.add(white);

    }


}
