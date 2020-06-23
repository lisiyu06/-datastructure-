package git;


import java.util.ArrayList;
import java.util.List;

/**
 * Author: lisiyu
 * Created: 2020/6/23
 */

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) { this.val = val; }
}

/**
 * 二叉树的的分层遍历
 */

public class LayeredTraversal {
    // result 相当于一个二维数组
    // 针对当前的 ArrayList （包含所有的层）来说，每个元素又是一个 List （每一层里面的所有节点内容）
    // result 的 0 号元素对应着第 0 层节点
    // result 的 1 号元素对应着第 1 层节点
    // ...
    static List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 此处由于要把每层的结点放到一个单独的 List 中，所以之前的层序遍历就不适用了，
        // 此处还是是基于递归的方式来解决这个问题
        if (root == null) {
            return result;
        }
        // helper 方法辅助递归，第二个参数表示当前的层数（层数从 0 开始算，和 List 下标正好对上）
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int level) {
        if (level == result.size()) {
            // （两者都为 0），防止下标越界
            result.add(new ArrayList<>());
        }
        // 把当前节点添加到 result 中的合适位置
        result.get(level).add(root.val); // 等同于下面两行的效果
//        List<Integer> row = result.get(level);
//        row.add(root.val);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }
}
