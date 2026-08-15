package leet_code._100;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if ((p != null && q == null) || (p == null && q != null))
            return false;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(p);
        q2.add(q);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode t1 = q1.poll();
            TreeNode t2 = q2.poll();
            if (t1.val != t2.val)
                return false;
            if ((t1.left != null && t2.left == null) ||
                    (t1.left == null && t2.left != null)) {
                return false;
            } else {
                if (t1.left != null && t2.left != null) {
                    q1.add(t1.left);
                    q2.add(t2.left);
                }
            }
            if ((t1.right != null && t2.right == null) ||
                    (t1.right == null && t2.right != null)) {
                return false;
            } else {
                if (t1.right != null && t2.right != null) {
                    q1.add(t1.right);
                    q2.add(t2.right);
                }
            }
        }
        return true;
    }

    public boolean isSameTreeDfs(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    public boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p != null || q != null)
            return false;
        return dfs(p.left, q.left) && dfs(p.right, q.right);
    }
}
