class Solution {
    // Once a calculated the result for a day I don't need to count this day anymore
    // The numbers of days stop counting when I find a warmer day
    // Can I use brute force?

    // Iterates throught the days checking if is warmer then my current day
    // If isn't count grows 1, if is return count
    // If finish the whole array and didn't find any warmer day, return 0
    public int[] dailyTemperatures(int[] temperatures) {
        for(int i = 0; i < temperatures.length; i++) {
            temperatures[i] = calculateDaysBeforeWarmerDay(temperatures[i], i + 1, temperatures);
        }

        return temperatures;
    }

    public int calculateDaysBeforeWarmerDay(int dayTemperature, int dayOffset, int[] temperatures) {
        int count = 1;
        for(int i = dayOffset; i < temperatures.length; i++) {
            if(temperatures[i] > dayTemperature)
                return count;
            else
                count++; 
        }

        return 0;
    }
}
