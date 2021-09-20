package common;

import bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author cennavi_zt
 * @title: BreathFirstSearch
 * @projectName algorithm
 * @description: TODO： 广度优先搜索算法
 * @date 2021/9/209:19
 */
public class FirstSearch {

    /**
     * 广度优先遍历，使用 队列 实现
     * @param head 根节点
     */
    public void breathFirstSearch(TreeNode head) {
        if (head == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>() {
        };
        queue.add(head);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");

            if (node.leftNode != null){
                queue.add(node.leftNode);
            }
            if (node.rightNode != null){
                queue.add(node.rightNode);
            }
        }

    }

    /**
     * 深度优先搜索, 先遍历左边，然后遍历右边。与入栈顺序相关
     * @param head
     */
    public void deepFirstSearch(TreeNode head) {
        if (head == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.data + " ");

            if (node.rightNode != null){
                stack.push(node.rightNode);
            }

            if (node.leftNode != null){
                stack.push(node.leftNode);
            }
        }
    }
}
