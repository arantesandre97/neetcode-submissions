// can cars start from same position? the position are unique
// can start from a position forward from target? then travel back? the travel is considered only foward, because the car positions is always
// behind the target
// can a car start in target position? nope, like mentioned in the above answer

// we need to calculate the number of fleets where a fleet is a non empty set of cars, incluing a car travelling alone.
// cars aren't allowed to pass another car ahead of them in this highway, so they must travel in the same speed as the car
// ahead of them. when I car catch up another, they became a fleet.

// edge cases:
// all cars that are ahead of each other have a lower speed then the car behind it
// all cars that are ahead of each other haver a higher speed then the car behind it

/**
brute force

sort the cars positions in decreasing order
calculate the travel time for each car
then for each car, besides the first one, we check if the car ahead of it
has a lower time travel. If it has, we change the current car travel time
to this value. Otherwise keep as it is.
finally we traverse the array checking for different travel time

the sort process using algorithm like merge sort can gives us O(n log n) in average
the other array traverse costs O(n). So the complexity time would be O(n log n) overwall in that case
can we follow with that solution?

can we optmize that solution?
yes we can, instead of traverse the array 4 times, we can do just two loops maybe
one for sort the car fleet and other to calculate the fleets
to know what are the current fleets at the highway we can use a stack and every time
we calculate a car travel time, we check if that time if greater or less than the current
fleet. If if greater, that means the car gonna join the fleet, otherwise not. So, if the
car doesn't join a already existing fleet, it'll became a new fleet.

actually we will need 3 loops, even in that optimized solution, but I think its a more elegant and sofiscated solution
that helps in future code maintenances

what do u think, can I follow up and do some code here?

concatenatedPositionAndSpeedArray as cps
sort(cps)
fleetStack

forEach ps in cps
    travelTime = (target - position) / speed

    if fleetStack.isEmpty || fleetStack.peek() < travelTime //this mean a slower car is travelling in highway
        fleetStack.push(travelTime)

return fleetStack.size()

Input: target = 10, position = [1,4], speed = [3,2]
[[1,3],[4,2]] concat
[[1,3],[4,2]] sort

fleet [3]

tt = 9 / 3 = 3
fleet.push(3)

tt = 6 / 2 = 3
3 == 3

return 1;
*/

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] ps = new int[position.length][2];

        for(int i = 0; i < position.length; i++) {
            ps[i] = new int[]{position[i],speed[i]};
        }

        Arrays.sort(ps, (a,b) -> b[0] - a[0]);

        Deque<Double> fleet = new ArrayDeque<>();

        for(int i = 0; i < ps.length; i++) {
            double travelTime = (double) (target - ps[i][0]) / ps[i][1];
            if(fleet.isEmpty() || fleet.peek() < travelTime)
                fleet.push(travelTime);
        }

        return fleet.size();
    }
}
