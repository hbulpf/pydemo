import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CloneGraph {

    /**
     * DFS方法
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return cloneGraph(node, new HashMap<UndirectedGraphNode, UndirectedGraphNode>());
    }

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> cloneMap) {
        if (node == null) {
            return null;
        }
        if (cloneMap.containsKey(node)) {
            return cloneMap.get(node);
        }
        UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
        /**
         * 要注意这里这个克隆的节点不能在for循环之后再加到map，否则会死循环
         */
        cloneMap.put(node, cloned); // visited = true;
        for(UndirectedGraphNode neighbor: node.neighbors){
            cloned.neighbors.add(cloneGraph(neighbor, cloneMap));
        }
        return cloned;
    }

    /**
     * BFS方法
     */
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if (node == null) return null;

        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap(); //store visited nodes

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label); //new node for return
        map.put(node, newNode); //add first node to HashMap

        LinkedList<UndirectedGraphNode> queue = new LinkedList(); //to store **original** nodes need to be visited
        queue.add(node); //add first **original** node to queue

        while (!queue.isEmpty()) { //if more nodes need to be visited
            UndirectedGraphNode n = queue.pop(); //search first node in the queue
            UndirectedGraphNode cloned = map.get(n);

            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!map.containsKey(neighbor)) { //add to map and queue if this node hasn't been searched before
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                cloned.neighbors.add(map.get(neighbor)); //add neighbor to new created nodes
            }
        }

        return newNode;
    }
}
