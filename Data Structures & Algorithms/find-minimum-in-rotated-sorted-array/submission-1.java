/**
even the array is rotated, we can check for which is this ordered side from middle position
if the middle position is bigger than right, this mean that our left to midle side ir sorted
otherwise, if middle is smaller than right, so our middle to right side is the sorted one

in that case we ain't wanna search for a target, but actually for the smaller number that we can
find within our array

so we gonna always choose the side where we can find numbers smaller than our current mid value
and we gonna always consider the mid value as our miminum element until we get out of the loop

let take example 1 and do a simulation
nums = [3,4,5,6,1,2] 
mid = 2 -> 5
5 > 2 which means our left side is sorted and the smaller numbers are in the right side

look at example 2
nums = [4,5,0,1,2,3]
mid = 2 -> 0
0 < 3 which means our right side is ordered, but our mid value is smaller than the left so we still move to right side

lets try more cases 
nums = [4,5,6,7]
mid = 1 -> 5
5 < 7 which means left right side ordered, but 5 < 7 so we need to move

is kind of tricky right? haha

mid is always our smallest number, so we need to keep tracking for a smaller number than it
so mid is kind of a target also

if(mid < right && mid > left)
    move to the left side
else if (mid < right && mid < left)
    move to right side
if(mid > right && mid > left)
    move to righ side
else
    move to left side

I keep tracking for a smaller value until l > r

lets dry our solution
              l   r
nums = [3,4,5,6,1,2]
mid = 2 -> 5
minimum = min(5,5) = 5
5 > 2 && 5 > 3
l = mid + 1 = 3
mid = (3 + 5) / 2 = 4 -> 1
minimum = min(5,1) = 1
1 < 2 && 1 < 6
l = mid + 1 = 5

mid = 10 / 2 = 5
2 >= 2 && 2 <= 2

I overthinked the solution, it was so much simple I just looked it in the wrong way while trying to figure out the conditions
*/

class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while(l < r) {
            int mid = (r + l) / 2;

            if(nums[mid] > nums[r])
                l = mid + 1;
            else
                r = mid;
        }

        return nums[l];
    }
}
