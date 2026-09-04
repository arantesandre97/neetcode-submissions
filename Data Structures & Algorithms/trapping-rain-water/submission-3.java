class Solution {
    // To trap water I need two "walls" (bars) with a gap between them where water can sit.
    // The walls don't need to be nonzero themselves — what matters is that BOTH walls
    // (the tallest bar to the left and the tallest bar to the right of a given index)
    // must be taller than the bar at that index. That difference is what allows water
    // to sit on top of it.
    // That gap could be a bar with height shorter than both bars around it, or even a
    // bar with height 0.
    // How to calculate the amount of water trapped at a given index? Take the tallest
    // bar on the left side and the tallest bar on the right side, then the water level
    // is capped by the SHORTER of those two walls — water always spills over the lower
    // wall first, no matter how tall the other one is. If I have a wall of height 2 on
    // the left and height 3 on the right, and my bar has height 1, it can trap just
    // 1 water unit, because the left wall (the shorter one) limits it.

    // Iterate throught the array and calculate the tallest bar from left to right, and a second
    // time from right to left for every position
    // Finally iterate a third time through the array calculating the amount of water
    // which that index can trap. min (tallestLeft[i], tallestRight[i]) - height[i]
    // Adding the amount to a result, then when the whole array was iterated the third time, return
    // result

    public int trap(int[] height) {
        int totalWaterAmount = 0;

        int[] tallestLeftBars = calculateTallestLeftBars(height);
        int[] tallestRightBars = calculateTallestRightBars(height);

        for (int i = 1; i < height.length - 1; i++) {
            int waterAmount = Math.min(tallestLeftBars[i], tallestRightBars[i]) - height[i];
            totalWaterAmount += waterAmount < 0 ? 0 : waterAmount;
        }

        return totalWaterAmount;
    }

    public int[] calculateTallestLeftBars(int[] height) {
        int[] tallestLeftBars = new int[height.length];
        int tallestBar = 0;

        for (int i = 0; i < height.length; i++) {
            if (height[i] > tallestBar) {
                tallestBar = height[i];
            }

            tallestLeftBars[i] = tallestBar;
        }

        return tallestLeftBars;
    }

    public int[] calculateTallestRightBars(int[] height) {
        int[] tallestRightBars = new int[height.length];
        int tallestBar = 0;

        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > tallestBar) {
                tallestBar = height[i];
            }

            tallestRightBars[i] = tallestBar;
        }

        return tallestRightBars;
    }
}