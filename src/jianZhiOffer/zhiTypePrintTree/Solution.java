package jianZhiOffer.zhiTypePrintTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        deque.offerLast(pRoot);
        boolean flag = true;
        ArrayList<Integer> inList = new ArrayList<>();
        while (!deque.isEmpty()) {
            TreeNode p = deque.pollLast();
            inList.add(p.val);
            if (flag) {
                if (p.left != null) {
                    stack.offerLast(p.left);
                }
                if (p.right != null) {
                    stack.offerLast(p.right);
                }
            } else {
                if (p.right != null) {
                    stack.offerLast(p.right);
                }
                if (p.left != null) {
                    stack.offerLast(p.left);
                }
            }
            if (deque.isEmpty()) {
                deque = new LinkedList<>(stack);
                stack.clear();
                list.add(new ArrayList<>(inList));
                inList.clear();
                flag = !flag;
            }
        }
        return list;
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
        String s = "{8,6,10,5,7,9,11}";
        TreeNode root = stringToTreeNode(s);
        Solution sol = new Solution();
        ArrayList<ArrayList<Integer>> list = sol.Print(root);
        for (ArrayList<Integer> inlist : list) {
            for (int i = 0; i < inlist.size(); i++) {
                System.out.printf(" " + inlist.get(i));
            }
            System.out.println();
        }
    }

}