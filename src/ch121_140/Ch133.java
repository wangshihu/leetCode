package ch121_140;

import com.huihui.util.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by hadoop on 2015/6/6 0006.
 */
public class Ch133 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)
            return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        map.put(node, result);
        for(UndirectedGraphNode neighbor:node.neighbors){
            UndirectedGraphNode cloneNeighbor = new UndirectedGraphNode(neighbor.label);
            result.neighbors.add(cloneNeighbor);
            map.put(neighbor, cloneNeighbor);
            queue.add(neighbor);
        }
        while(!queue.isEmpty()){
            UndirectedGraphNode currentNode = queue.poll();
            UndirectedGraphNode cloneNode = map.get(currentNode);
            for(UndirectedGraphNode neighbor:currentNode.neighbors){
                UndirectedGraphNode cloneNeighbor = map.get(neighbor);
                if(cloneNeighbor!=null)
                    cloneNode.neighbors.add(cloneNeighbor);
                else {
                    cloneNeighbor = new UndirectedGraphNode(neighbor.label);
                    cloneNode.neighbors.add(cloneNeighbor);
                    map.put(neighbor,cloneNeighbor);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        UndirectedGraphNode node = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        node.neighbors.add(node1);
        node.neighbors.add(node2);
        node1.neighbors.add(node);
        node1.neighbors.add(node2);
        node2.neighbors.add(node);
        node2.neighbors.add(node1);
        node2.neighbors.add(node2);

        UndirectedGraphNode clone = new Ch133().cloneGraph(node);
        System.out.println(clone);

    }
}
