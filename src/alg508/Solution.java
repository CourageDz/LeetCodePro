package alg508;

import java.util.*;

public class Solution {
    Map<Integer, Integer> sumCount;
    int max;

    public int[] findFrequentTreeSum(TreeNode root) {
        sumCount = new HashMap<>();
        max = 0;
        getSubTreeSum(root);
        List<Integer> results = new ArrayList<>();
        for (int key : sumCount.keySet()) {
            if (sumCount.get(key) == max)
                results.add(key);
        }
        int[] ret = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            ret[i] = results.get(i);
        }
        return ret;
    }

    public int getSubTreeSum(TreeNode node) {
        if (node == null)
            return 0;
        else if (node.left == null && node.right == null) {
            int numCount = sumCount.getOrDefault(node.val, 0) + 1;
            max = Math.max(max, numCount);
            sumCount.put(node.val, numCount);
            return node.val;
        } else if (node.left == null && node.right != null) {
            int sum = getSubTreeSum(node.right) + node.val;
            int numCount = sumCount.getOrDefault(sum, 0) + 1;
            max = Math.max(max, numCount);
            sumCount.put(sum, numCount);
            return sum;
        } else if (node.right == null && node.left != null) {
            int sum = getSubTreeSum(node.left) + node.val;
            int numCount = sumCount.getOrDefault(sum, 0) + 1;
            max = Math.max(max, numCount);
            sumCount.put(sum, numCount);
            return sum;
        } else {
            int sum = getSubTreeSum(node.left) + getSubTreeSum(node.right) + node.val;
            int numCount = sumCount.getOrDefault(sum, 0) + 1;
            max = Math.max(max, numCount);
            sumCount.put(sum, numCount);
            return sum;
        }
    }

    public static TreeNode stringToTreeNode(String input) {
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

    public static void main(String[] args) {
        String s1 = "(5,2,-5)";
        Solution sol = new Solution();
        TreeNode root = stringToTreeNode(s1);
        int[] results = sol.findFrequentTreeSum(root);
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }
}
