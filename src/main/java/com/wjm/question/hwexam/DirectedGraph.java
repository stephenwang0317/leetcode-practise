package com.wjm.question.hwexam;

import java.util.*;

public class DirectedGraph {

    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int to = scanner.nextInt();
            graph.merge(i,new ArrayList<>(Arrays.asList(to)),(oldVal,newVal)->{
                oldVal.add(to);
                return oldVal;
            });
        }

        List<Set<Integer>> cycles = findCycles(graph);
    }

    public static List<Set<Integer>> findCycles(HashMap<Integer, List<Integer>> graph) {
        List<Set<Integer>> cycles = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> onStack = new LinkedHashSet<>();

        for (Integer node : graph.keySet()) {
            if (!visited.contains(node)) {
                dfs(graph, node, visited, onStack, cycles);
            }
        }

        return cycles;
    }

    private static void dfs(HashMap<Integer, List<Integer>> graph, int currentNode,
                            Set<Integer> visited, Set<Integer> onStack,
                            List<Set<Integer>> cycles) {
        visited.add(currentNode);
        onStack.add(currentNode);

        List<Integer> neighbors = graph.getOrDefault(currentNode, new ArrayList<>());
        for (Integer neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, visited, onStack, cycles);
            } else if (onStack.contains(neighbor)) {
                Set<Integer> cycle = new HashSet<>();

                boolean f = false;
                for (Integer integer : onStack) {
                    if (!f && !Objects.equals(integer, neighbor)) continue;
                    else {
                        f = true;
                    }
                    cycle.add(integer);
                }
                cycles.add(cycle);
            }
        }

        onStack.remove(currentNode);
    }
}
