package demo;

import bean.TreeNode;
import common.FirstSearch;

/**
 * @author cennavi_zt
 * @title: SearchDemo
 * @projectName algorithm
 * @description: TODO: 图形搜索算法示例，涉及深度优先搜索算法与广度优先搜索算法
 * @date 2021/9/209:20
 */
public class SearchDemo {
    public static void main(String[] args) {
        // 构建树
        TreeNode head = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);

        head.leftNode = second;
        head.rightNode = three;
        second.leftNode = four;
        second.rightNode = five;
        three.leftNode = six;
        three.rightNode = seven;
        four.leftNode = eight;
        four.rightNode = nine;


        System.out.println("广度优先遍历结果：");
        new FirstSearch().breathFirstSearch(head);
        System.out.println();
        System.out.println("深度优先搜索结果：");
        new FirstSearch().deepFirstSearch(head);


    }
}
