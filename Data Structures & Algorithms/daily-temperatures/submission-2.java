class Solution {
    // Once a calculated the result for a day I don't need to count this day anymore
    // The numbers of days stop counting when I find a warmer day
    // Can I use brute force?

    // Brute force would work, but re-scans days I've already resolved — wasteful
    // Instead: keep a "waiting list" of day indices that haven't found a warmer day yet
    // The waiting list stays sorted so the coolest day sits on top

    // For each new day, check the day on TOP of the waiting list (not just the last one added)
    // If today is warmer than it, that day's wait is over — the count is today's index minus its index
    // Keep checking the new top of the list, since one warmer day can resolve several waiting days at once
    // Once nothing left on top is cooler than today, today itself joins the waiting list

    // Anything still on the waiting list after the loop never found a warmer day, so its answer is 0
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
