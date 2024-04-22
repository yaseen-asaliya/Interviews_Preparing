package DataStructure.ComplexDataStructure.Graph;

import java.util.*;

class Node {
    int data;
    int distance;
    Node(int data, int distance){
        this.data = data;
        this.distance = distance;
    }
}
public class UndirectedGraphOperations {
    HashMap<Integer, List<Integer>> adjacentList;

    UndirectedGraphOperations() {
        adjacentList = new HashMap<>();
    }

    void addEdgeUndirected(int src, int dest){
        if(!adjacentList.containsKey(src)){
            adjacentList.put(src,new ArrayList<>());
        }

        if(!adjacentList.containsKey(dest)){
            adjacentList.put(dest,new ArrayList<>());
        }

        adjacentList.get(src).add(dest);
        adjacentList.get(dest).add(src); // for undirected graph
    }

    // DFS traversal
    boolean hasPathDFS(int src, int dest, Set<Integer> visited) {
        if(src == dest) return true;

        // To avoid cycle
        if(visited.contains(src))return false;
        visited.add(src);

        for(int item : adjacentList.get(src)){
            if(hasPathDFS(item,dest, visited)){
                return true;
            }
        }
        return false;
    }

    // BFS traversal
    boolean hasPathBFS(int src, int dest) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        Set<Integer> set = new HashSet<>();

        while(!queue.isEmpty()){
            int current = queue.poll();
            if(current == dest)return true;

            if(set.contains(current)) {
                continue;
            }
            set.add(current);

            for(int item : adjacentList.get(current)){
                if(!set.contains(item))
                    queue.add(item);
            }
        }

        return false;
    }

    private int DFS(int src, Set<Integer> visited) {
        if(visited.contains(src))return 0;
        visited.add(src);

        for(Integer item : adjacentList.get(src)){
            DFS(item,visited);
        }
        return 1;
    }

    public int connectedComponentCount() {
        int count= 0;
        Set<Integer> set = new HashSet<>();

        for(Integer key : adjacentList.keySet()){
            count += DFS(key, set);
        }
        return count;

    }

    private int BFSCount(int src, Set<Integer> visited) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while(!queue.isEmpty()){
            int current = queue.poll();
            if(visited.contains(current))continue;
            visited.add(current);
            count++;
            for(Integer item : adjacentList.get(current)){
                queue.add(item);
            }

        }
        return count;
    }

    public int largestComponent() {
        int largest = 0;
        Set<Integer> visited = new HashSet<>();

        for(Integer key : adjacentList.keySet()) {
            int temp_max = BFSCount(key, visited);
            if(temp_max > largest)
                largest = temp_max;
        }
        return largest;

    }

    // Find the shortest path by number of edges
    public int shortestPath(int src, int dest) {
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(new Node(src, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.data == dest) {
                return current.distance;
            }

            for (int item : adjacentList.get(current.data)) {
                if (!visited.contains(item)){
                    visited.add(item);
                    queue.add(new Node(item, current.distance + 1));
                }
            }
        }

        return -1;
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
        System.out.println("===== Undirected Graph =======");

        UndirectedGraphOperations undirectedGraph = new UndirectedGraphOperations();
        undirectedGraph.addEdgeUndirected(1,2);
        undirectedGraph.addEdgeUndirected(3,1);
        undirectedGraph.addEdgeUndirected(3,5);
        undirectedGraph.addEdgeUndirected(3,4);
        undirectedGraph.addEdgeUndirected(6,7); // cycle
        undirectedGraph.addEdgeUndirected(2,3); // cycle



        System.out.println("Undirected Graph Values:");
        undirectedGraph.printAdjacentList(undirectedGraph.adjacentList);

        System.out.println(undirectedGraph.hasPathDFS(1,3, new HashSet<>()));

        System.out.println(undirectedGraph.hasPathBFS(1,6));

        System.out.print("# of connected component is : ");
        System.out.println(undirectedGraph.connectedComponentCount());

        System.out.print("Largest connected component is : ");
        System.out.println(undirectedGraph.largestComponent());

        undirectedGraph.adjacentList.clear();

        undirectedGraph.addEdgeUndirected(1,3);
        undirectedGraph.addEdgeUndirected(1,2);
        undirectedGraph.addEdgeUndirected(2,4);
        undirectedGraph.addEdgeUndirected(3,5);
        undirectedGraph.addEdgeUndirected(4,5);
        undirectedGraph.printAdjacentList(undirectedGraph.adjacentList);

        System.out.println(undirectedGraph.shortestPath(1,5));


    }
}
