class Solution {
    // Once a calculated the result for a day I don't need to count this day anymore
    // The numbers of days stop counting when I find a warmer day
    // Can I use brute force?

    // Iterates throught the days checking for warmer days
    // A number enters in the waiting list, every time I go to a new day
    // I check if my last day was cooler, if is I count how
    // many days took before a warmer day appeared by subtracting the days waiting
    // from the current day
    // If there're still days waiting for a warmer one after I finish it they must be set to zero
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> daysWaiting = new ArrayDeque<>();

        for(int i = 0; i < temperatures.length; i++) {
            while(daysWaiting.peek() != null  && temperatures[daysWaiting.peek()] < temperatures[i]) {
                temperatures[daysWaiting.peek()] = i - daysWaiting.peek();
                daysWaiting.pop();
            }
            
            daysWaiting.push(i); 
        }

        while(!daysWaiting.isEmpty()) {
            temperatures[daysWaiting.peek()] = 0;
            daysWaiting.pop(); 
        }

        return temperatures;
    }
}
