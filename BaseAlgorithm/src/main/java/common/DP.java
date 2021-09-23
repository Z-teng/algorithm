package common;

/**
 * @author cennavi_zt
 * @title: DP
 * @projectName algorithm
 * @description: TODO 动态规划示例
 * @date 2021/9/2311:15
 */
public class DP {

    public int stair2Problem(int steps) {
        int[] stepArr = new int[steps + 1];
        for (int i = 0; i < steps + 1; i++) {
            if (i < 3){
                stepArr[i] = i;
            }else {
                stepArr[i] = stepArr[i -1] + stepArr[i-2];
            }
        }
        return stepArr[steps];
    }

    public int stair3Problem(int steps) {
        if (steps == 1){
            return 1;
        }
        if (steps == 2){
            return 2;
        }
        if (steps == 3){
            return 4;
        }
        return stair3Problem(steps -1) + stair3Problem(steps - 2) + stair3Problem(steps - 3);
    }
}
