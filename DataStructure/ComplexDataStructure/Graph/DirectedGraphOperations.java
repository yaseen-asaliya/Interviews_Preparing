package DataStructure.ComplexDataStructure.Graph;

import java.util.*;

public class DirectedGraphOperations {
    HashMap<Integer, List<Integer>> adjacentList;

    DirectedGraphOperations() {
        adjacentList = new HashMap<>();
    }

    void addEdgeDirected(int src, int dest){
        if(!adjacentList.containsKey(src)){
            adjacentList.put(src,new ArrayList<>());
        }

        if(!adjacentList.containsKey(dest)){
            adjacentList.put(dest,new ArrayList<>());
        }

        adjacentList.get(src).add(dest);
        //adjacentList.get(dest).add(src); // for undirected graph
    }
    public void depthFirstSearch(HashMap<Integer, List<Integer>> adjacentList, int source){
        if(adjacentList == null){
            return;
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(source);

        while(!stack.empty()){
            int current = stack.pop();
            System.out.println(current);

            for(int item : adjacentList.get(current)){
                stack.push(item);
            }
        }
    }

    public void depthFirstSearchRec(HashMap<Integer, List<Integer>> adjacentList, int source){
        System.out.println(source);

        for(int item : adjacentList.get(source)){
            depthFirstSearch(adjacentList,item);
        }

    }

    public void breadthFirstSearch(HashMap<Integer, List<Integer>> adjacentList, int source){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()){
            int current = queue.poll();
            System.out.println(current);

            for(int item : adjacentList.get(current)){
                queue.add(item);
            }
        }
    }

    // DFS traversal
    boolean hasPathDFS(int src, int dest) {
        if(src == dest) return true;

        for(int item : adjacentList.get(src)){
            if(hasPathDFS(item,dest)) {
                return true;
            }
        }
        return false;
    }

    // BFS traversal
    boolean hasPathBFS(int src, int dest) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while(!queue.isEmpty()){
            int current = queue.poll();
            if(current == dest){
                return true;
            }

            for(int item : adjacentList.get(current)){
                queue.add(item);
            }
        }
        return false;
    }

    public void printAdjacentList(HashMap<Integer, List<Integer>> adjacentList) {
        for (Integer key : adjacentList.keySet()) {
            System.out.print(key + ": ");

            for (int listItem : adjacentList.get(key)) {
                System.out.print(listItem + " ");
            }

            System.out.println();
        }
    }


    public static void main(String[] args) {
        System.out.println("===== Directed Graph =======");

        DirectedGraphOperations graph = new DirectedGraphOperations();

        graph.addEdgeDirected(1,3);
        graph.addEdgeDirected(1,2);
        graph.addEdgeDirected(2,4);
        graph.addEdgeDirected(3,5);
        graph.addEdgeDirected(4,6);

        System.out.println("Graph Values:");
        graph.printAdjacentList(graph.adjacentList);

        System.out.println("\nDepth First Search:");
        graph.depthFirstSearch(graph.adjacentList,1);

        System.out.println("\nDepth First Search Recursive:");
        graph.depthFirstSearchRec(graph.adjacentList,1);

        System.out.println("\nBreath First Search:");
        graph.breadthFirstSearch(graph.adjacentList,1);

        System.out.println("\nBreath First Search Recursive:");
        System.out.println("It's better to solve it using iteration.");

        System.out.println(graph.hasPathDFS(1,6));
        System.out.println(graph.hasPathDFS(1,5));

        System.out.println(graph.hasPathBFS(1,6));
        System.out.println(graph.hasPathBFS(1,5));

    }
}
