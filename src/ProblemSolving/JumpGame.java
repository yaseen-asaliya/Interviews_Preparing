package ProblemSolving;

/*
You are given an integer array nums. You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.


*/
public class JumpGame {
    public boolean canJump(int[] nums) { // { 2,3,4,1,2 }
        int maxReachable = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > maxReachable) {
                return false;
            }
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }

        return true;
    }
}
