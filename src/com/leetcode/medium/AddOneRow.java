package com.leetcode.medium;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author moon
 */
class TreeNode  {
    Integer val;
    TreeNode left;
    TreeNode right;
    public TreeNode(Integer x){
        val = x;
    }
}
public class AddOneRow {
    public TreeNode addOneRow(TreeNode root,int v,int d){
        if (d == 1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()){
            depth++;
            if(depth == d - 1){
                while(!queue.isEmpty()){
                    TreeNode node = queue.remove();
                    TreeNode temp = node.left;
                    node.left = new TreeNode(v);
                    node.left.left = temp;
                    temp = node.right;
                    node.right = new TreeNode(v);
                    node.right.right = temp;
                }
                break;
            }
            int n = queue.size();
            while(n>0){
                TreeNode cur = queue.remove();
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
                n--;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] array = {4,2,6,3,1,5};
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(1);
        node1.left = node2;
        node2.left = node4;
        node2.right = node5;
        AddOneRow aor = new AddOneRow();
        TreeNode root = aor.addOneRow(node1,1,3);
    }
}
