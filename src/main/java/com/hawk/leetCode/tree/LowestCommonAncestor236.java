package com.hawk.leetCode.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 题目描述：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先（一个节点也可以是它自己的祖先）
 * 示例：
 *     3
 *    / \
 *   5   1
 *  / \ / \
 * 6  2 0  8
 *   / \
 *  7   4
 *  输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 输出：3
 */
public class LowestCommonAncestor236 {

    /**
     * 存储父节点
     * 解题思路：我们可以用哈希表存储所有节点的父节点
     * 然后我们就可以利用节点的父节点信息从 p 结点开始不断往上跳，并记录已经访问过的节点
     * 再从 q 节点开始不断往上跳，如果碰到已经访问过的节点，那么这个节点就是我们要找的最近公共祖先
     */
    private Map<Integer, TreeNode> parent = new HashMap<>();

    private Set<Integer> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }
}
