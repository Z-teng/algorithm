package bean;

import java.util.Enumeration;

/**
 * @author cennavi_zt
 * @title: TreeNode
 * @projectName algorithm
 * @description: TODO: 二叉树数据结构， 图的搜索算法基础数据结构. 简单的树，详细结可以实现TreeNode接口。
 * @date 2021/9/209:14
 */
public class TreeNode {
    public int data;
    public TreeNode leftNode;
    public TreeNode rightNode;

    public TreeNode() {
    }

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode( TreeNode leftNode, TreeNode rightNode, int data) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}
