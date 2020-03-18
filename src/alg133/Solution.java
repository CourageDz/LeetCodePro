package alg133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Integer, UndirectedGraphNode> newNodes = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    public UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null)
            return null;
        if (newNodes.containsKey(node.label))
            return newNodes.get(node.label);
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        newNodes.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}
