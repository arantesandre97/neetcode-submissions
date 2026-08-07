class Solution {
    public int maxArea(int[] heights) {
        int mostWater = 0;
        int i = 0;
        int j = heights.length - 1;

        while(i < j) {
            int minValue = heights[i] <= heights[j] ? heights[i] : heights[j];
            int water = (j - i) * minValue;

            if(water > mostWater)
                mostWater = water;
            
            if(heights[i] <= minValue)
                i++;
            else
                j--;
        }

        return mostWater;
    }
}
