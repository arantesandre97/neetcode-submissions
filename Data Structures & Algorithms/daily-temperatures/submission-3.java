// Can the temperatures be negative?
// Can my temperature array have none element?
// Can the temperatures be duplicated? or is supposed to each day has a different temperature?

// edge case:
// one element array
// array with the same temperature every day
// array where the temperature decrease every day

/**
brute force: for each day traverse the array searching for a higher temperature, if we find it set the current
counter + 1 as the number of days. If not, number of days will not be set and equal to zero. That solution gives
us a O(n**2) time complexity and a O(1) space complexity, because we can use the same array to store the result.

but I can think in a better approach, would me to introduce that idea?

well I was thinking about using a monotonic stack to store days, so for each day we look at the stack and check
if the stacked days are colder than the current one. For do that we get the peek and compare with the current one,
then loop the stack until we have colder days. The idea is to store the temperatures indices, instead of the actual
value. Because in that way we can know which index of our result we need to update. And we just need to start our
result array with 0s, so if a temperature is never removed from the stack this mean a warmer day wasn't found.

Each loop I guarantee that only days which ain't have a warmer day after stay stacked. Because every time that I found 
a higher temperature, I'll pop the days cooler then this one. So, a day can't stay in the stack if a warmer day appear
right after it.

Stack temperatureStack
int[] result

forEach t in temperature:
    while(temperatureStack.size != 0 && temperaures[temperatureStack.peek] < t)
        result[temperatureStack.peek] = i - temperatureStack.peek;
        temperatureStack.pop()

    temperature.push(t)

return result;
          t
[30,38,30,36]  stack=[1]

res = [1,0,1,0]

30 < 38
38 > 30
30 < 36

So my time complexity with that approach is O(n) but my space complexity is O(n) either (because I'll store all temperature in that stack in
worst case like the second and third edge case that I mentioned before). 
Which gives me a better time complexity
against the brute force solution, but takes me a little more space requirement.
*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> temperatureStack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            while(!temperatureStack.isEmpty() && temperatures[temperatureStack.peek()] < temperatures[i]) {
                result[temperatureStack.peek()] = i - temperatureStack.peek();
                temperatureStack.pop();
            }

            temperatureStack.push(i);
        }

        return result;
    }
}
