class Solution {
    // To trap water I need two bars with heights differents from zero, and a free 
    // space between them 
    // That free space could be a bar with height shorter than both bars arround it, 
    // or even no height at all 
    // How to calculate the amount of water trapped between those bars? Took the
    // taller bars from right and left side then calculate. The maximum amount of water which
    // a bar can trap is directly afected by the shorter bar next to it. If I have a bar with
    // height 2 on left side and 3 on right side, considering my bar has 1, it can trap just 1
    // water unit because the left bar limited it.

    // Iterate throught the array and calculate the tallest bar from left to right, and a second
    // time from right to left for every position
    // Finally iterate a third time through the array calculating the amount of water 
    // which that index can trap. min (tallestLeft[i], tallestRight[i]) - height[i]
    // Adding the amount to a result, then when the whole array was iterated the third time, return result

    public int trap(int[] height) {
        int totalWaterAmount = 0;

        int[] tallestLeftBars = calculateTallestLeftBars(height);
        int[] tallestRightBars = calculateTallestRightBars(height);

        for(int i = 1; i < height.length - 1; i++) {
            int waterAmount = Math.min(tallestLeftBars[i], tallestRightBars[i]) - height[i];
            totalWaterAmount += waterAmount < 0 ? 0 : waterAmount; 
        }

        return totalWaterAmount;
    }

    public int[] calculateTallestLeftBars(int[] height) {
        int[] tallestLeftBars = new int[height.length];
        int tallestBar = 0;

        for(int i = 0; i < height.length; i++) {
            if(height[i] > tallestBar) {
                tallestBar = height[i];
            }

            tallestLeftBars[i] = tallestBar;
        }

        return tallestLeftBars;
    }

    public int[] calculateTallestRightBars(int [] height) {
        int[] tallestRightBars = new int[height.length];
        int tallestBar = 0;
        
        for(int i = height.length - 1; i >= 0; i--) {
            if(height[i] > tallestBar) {
                tallestBar = height[i];
            }

            tallestRightBars[i] = tallestBar;
        }

        return tallestRightBars;
    }
}