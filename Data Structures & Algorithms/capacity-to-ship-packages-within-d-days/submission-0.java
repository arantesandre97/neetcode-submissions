// is there a minimum or maximum quantity of package there a ship can carry by day? at least one
// how many packages can we have to ship? I mean interval of numbers of packages 1 to 50,000
// what are the bounds for the packages weights? 1 to 500 pounds

/**
So the problem consists in ship a number of packages within d days, I gonna call the days quantity
as d but we have to respect the package order when loading the ship and define the minimum of ship
capacity, in terms of weights, which we need to delivery all packages within that time window
*/

/**
1 day available to ship
all packages with same weight
1 package to delivery
/

/**

well the most obvious way to do that is to define a range of minumum and maximum capacity that our
ship can have which will be the heaviest package and the sum of all packages, considering scenarios
like one day to delivery all packages so we just need to loop from minumum to maximum trying to find
a value that fits the packages in numbers of day i.e. simulate the delivery service by loading the
ship until reach the current capacity and moving the delivery for next day if it reach ship max
capacity. If the delivery services pass the days threshold e can jump for the next possible capacity
this will give us a O(n**2) time complexity and a O(1) space complexity

Well our possible capacities, I gonna call it as an array, is sorted. So I thought in a way to
optimize that solution using binary search where we can navigate through the values with a O(log n)
time complexity. But it's important to point, that doesn't make our solution complexity time as
O(log n) at all, because we still need to calculate if with the current capacity we can delivery
them within the target days


optimal solution
lowCapBound = max(weights)
highCapBound = sum(weights)
minimumCap = lowCapBound

while (lowCapBound <= highCapBound)
    cap = (lowCapBound + highCapBound) / 2
    if(packagesCanBeDelivered(cap,packages,days))
        minimumCap = cap;
        highCapBound = cap - 1;
    else
        lowCapBound = cap + 1;

return minimumCap

dry run
[1,2,3,4,5] days = 5

lo = 1
hi = 15

lo < hi
(1 + 15) / 2 = 8

packagesCanBeDelivery with 8? yes
1,2,3
4
5

hi = 7

(1+7)/2 = 4

packagesCanBeDelivery with 4? no
1,2
3
4
5 X

lo = 5

(5+7)/2 = 6
packagesCanBeDelivery with 6? yes
1,2,3
4
5

hi = 5

(5+5)/2 = 5

packagesCanBeDelivery with 5? yes
1,2,3
4
5

hi = 4

lo > hi
loop end

result 5

I just need to think a little about the logic of package fit

I guess the logic will be

if(weight > capacity)
    return false
else if (currCapacity + weight <= capacity)
    currCapacity += weight
else
    currDays++
    currCapacity = weight

if(currDays > days)
    return false

out of the loop
    return true
*/

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lowCapBound = Arrays.stream(weights).max().getAsInt();
        int highCapBound = Arrays.stream(weights).sum();
        int minimumCap = lowCapBound;

        while(lowCapBound <= highCapBound) {
            int cap = (lowCapBound + highCapBound) / 2;
            if(canDeliveryWithDays(weights, days, cap)){
                minimumCap = cap;
                highCapBound = cap - 1;
            }
            else
                lowCapBound = cap + 1;
        }

        return minimumCap;
    }

    private Boolean canDeliveryWithDays(int[] weights, int days, int capacity) {
        int currLoad = 0;
        int currDays = 1;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > capacity)
                return false;
            else if (currLoad + weights[i] <= capacity)
                currLoad += weights[i];
            else {
                currDays++;
                currLoad = weights[i];
            }

            if (currDays > days)
                return false;
        }

        return true;
    }
}