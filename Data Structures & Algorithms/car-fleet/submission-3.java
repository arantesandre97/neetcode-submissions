class Solution {
    /**
     * CAR FLEET - Derivation Notes
     *
     * Q1: What's the alone-time formula for a single car?
     * A1: time = (target - position) / speed
     *
     * Q2: If car A (behind) has alone-time <= car B's (ahead), does A catch B
     *     before the target? What if A's alone-time is greater?
     * A2: If A's time <= B's time, A catches up and merges into B's fleet.
     *     If A's time > B's time, A never catches up -> separate fleets.
     *
     * Q3: What effective time does a merged fleet travel at?
     * A3: The fleet's arrival time is always the time of the FRONT car
     *     (the one that was already there). A merged car adopts that time;
     *     it never keeps its own separate time going forward.
     *
     * Q4: Which direction should we process cars in?
     * A4: Closest-to-target backward (sort by position descending), because
     *     a car's fate only depends on the fleet(s) ahead of it, so that
     *     info must already be resolved before we process the car.
     *
     * Q5: What's the one piece of info needed about "the fleet ahead"?
     * A5: Just its arrival time -- nothing else about the fleet matters.
     *
     * Q6: What structure keeps position and speed glued together while sorting?
     * A6: An array of pairs/tuples (position, speed), sorted by position.
     *     No hashmap needed (no lookups), no linked list needed (no mid-list
     *     insertion).
     *
     * Q7: What's the exact stack rule?
     * A7: If the stack is empty -> push (new fleet).
     *     Else compare current arrival time to the stack's top:
     *       - current > top  -> push (new fleet forms)
     *       - current <= top -> joins existing fleet (do nothing)
     *
     * Q8: What does the final stack represent?
     * A8: Its size = number of fleets. Each stack entry = one fleet's
     *     arrival time.
     */

    // Zip position/speed into pairs, sort by position descending.
    // Iterate through sorted pairs, compute arrival time for each.
    // Maintain a stack: if empty or current time > stack top, push (new fleet); otherwise skip
    // (joins existing fleet). Return stack size.
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        Deque<Double> carFleets = new ArrayDeque<>();

        for (int[] car : cars) {
            double arriveTime = (double) (target - car[0]) / car[1]; 
            
            if(carFleets.isEmpty() || arriveTime > carFleets.peek())
                carFleets.push(arriveTime);   
        }

        return carFleets.size();
    }
}
