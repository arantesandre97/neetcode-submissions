// what are the nums array bounds?
// what are the numbers values interval?
// can the array has duplicated numbers, or can restrictly only has non duplicated numbers?

// the problem consists in found start and ending position of a target number, then return those
// positions or [-1,-1] if the number isn't found

// edge cases:
// empty array
// one element array
// a array with just one number repeated many times

/**
brute force:
tranverse the array searching for the target, every time we found the target we compare the current
position to two variables starting position and end position, where we switch the values if starting
position is still -1 and end position always get the last position we found the target

this solution gives us a O(n) time complexity solution and O(1) space

but as our array is ordered, a better choice will be use a binary search that gives us a better
complexity time with the same space complexity

optimal solution:
the idea consist in traverse the array two times, one binary search for find the start position and
other for the end position the different will be that in the first case if we found the target we'll
store it and move the right pointer to the left side, to search for a smaller index position. And
for the last we do the inverse. It's like to search for the first true and the last true in a array
of falses and trues

I can guarantee that I'll not dicard the earlier index in the first search, because I'll always
discard the right side where the later index are present. And vice-versa.
*/

/**
pseudo code

left = 0
right = nums.length - 1

startPosition = -1

while left < right
    mid = left + (right - left) / 2  //prevents Integer overflow because the numbers values are
between -10**9 and 10**9 if nums[mid] == target startPosition = mid right = mid - 1 else if
nums[mid] > target right = mid - 1 else left = mid + 1



left = 0
right = nums.length - 1

endPosition = - 1
while left < right
    mid = left + (right - left) / 2
    if nums[mid] == target
        endPosition = mid
        left = mid + 1
    else if nums[mid] > target
        right = mid - 1
    else
        left = mid + 1

return startPosition, endPosition
*/

/**
l
       m
       r
[5,7,7,8,8,10] 8

search start position
mid = 0 + 2 = 2
nums[mid] = 7
7 < 8
l = 3

mid = 3 + 1 = 4
nums[mid] = 8
8 == 8
right = 4

mid = 3 + 0 = 3
nums[mid] = 8
8 == 8
right = 3

left == right

search end position
         l
         m
            r
[5,7,7,8,8,10] 8

mid = 0 + 2 = 2
nums[mid] = 7
7 < 8
l = 3

mid = 3 + 1 = 4
nums[mid] = 8
8 == 8
left = 4

mid = 4 + 0 = 4
nums[mid] = 8
8 == 8


4 < 5

*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int startPosition = -1;
        int endPosition = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                startPosition = mid;
                right = mid - 1;
            } else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        if(startPosition == -1)
            return new int[]{startPosition,endPosition};

        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                endPosition = mid;
                left = mid + 1;
            } else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return new int[]{startPosition,endPosition};
    }
}