package alg865;

import java.util.*;

public class Solution {
    //运行报错，通过56/57
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Map<Integer, Integer> parentNode = new HashMap<>();
        List<Integer> nodeList = new ArrayList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            int n = nodeQueue.size();
            nodeList.clear();
            for (int i = 0; i < n; i++) {
                TreeNode node = nodeQueue.pollFirst();
                nodeMap.put(node.val, node);
                nodeList.add(node.val);
                if (node.left != null) {
                    nodeQueue.offerLast(node.left);
                    parentNode.put(node.left.val, node.val);
                }
                if (node.right != null) {
                    nodeQueue.offerLast(node.right);
                    parentNode.put(node.right.val, node.val);
                }
            }
        }
        boolean isSame = false;
        Integer[] parent = nodeList.toArray(new Integer[nodeList.size()]);
        if (nodeList.size() == 1) {
            return nodeMap.get(nodeList.get(0));
        }
        while (!isSame) {
            isSame = true;
            for (int i = 0; i < nodeList.size(); i++) {
                parent[i] = parentNode.get(parent[i]);
                if (i > 0 && parent[i] != parent[i - 1]) {
                    isSame = false;
                }
            }
        }
        return nodeMap.get(parent[0]);
    }

    public static void main(String[] args) {
//        String s1="(3,5,1,6,2,9,8,null,null,7)";
        String s1 = "(0,1,3,null,2)";
        Solution sol = new Solution();
        TreeNode root = sol.stringToTreeNode(s1);
        TreeNode result = sol.subtreeWithAllDeepest(root);
        System.out.println(result.val);

    }

    public TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

}

