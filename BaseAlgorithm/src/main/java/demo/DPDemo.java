package demo;

import common.DP;

/**
 * @author cennavi_zt
 * @title: DPDemo
 * @projectName algorithm
 * @description: TODO 动态规划示例
 * @date 2021/9/2311:16
 */
public class DPDemo {
    public static void main(String[] args) {
        stair2Problem();
        stair3Problem();
    }

    /**
     * 三步问题。有个小孩正在上楼梯，楼梯有 n 阶台阶，小孩一次可以上 1 阶、2 阶或 3 阶。实现一种方法，计算小孩有多少种上楼梯的方式。
     * 状态转移方程：
     *  f(i) = f(i-1) + f(i-2) + f(i-3)
     */
    private static void stair3Problem() {
        DP dp = new DP();
        int stairs = 5;
        int steps = dp.stair3Problem(stairs);
        System.out.println("三步台阶问题:台阶数为 "+ stairs + " 时， 这个人一共有 " + steps + " 种走法。");
    }

    /**
     * 台阶问题
     * 有n个阶梯，一个人每一步只能跨一个台阶或是两个台阶，问这个人一共有多少种走法？
     * 解析：
     * 状态转移方程：
     *  f(i) = f(i-1) + f(i-2)
     */
    public static void stair2Problem() {
        DP dp = new DP();
        int stairs = 10;
        int steps = dp.stair2Problem(stairs);
        System.out.println("两步台阶问题:台阶数为 "+ stairs + " 时， 这个人一共有 " + steps + " 种走法。");
    }
}
