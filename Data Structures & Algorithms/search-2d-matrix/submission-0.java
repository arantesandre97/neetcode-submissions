// There're sub binary search problem, where each row have ascending
// ordered numbers, right?
// So I can actually pick one row at time then apply a binary search on it
// but it will cost me a O(m * log n) time in worst case
// I was thinking about applying the binary search logic also
// in a way which I can discard the rows that have bigger or
// smaller values. That sounds good?
// I mean I can sinalize somehow after went throught a whole row
// if the I need to go to next or previous row based on my left
// pointer position. What do you think?

// matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]] target = 15
/*                    
                      5 - mid
   0 [1,2,4,8 - 1 10,11,12,13 - 2 14,20,30,40]
      0 1 2 3      0  1  2  3      0  1  2  3

    m = 3
    n = 4
    left = 0
    right = (3 * 4) - 1 = 12 - 1 = 11
    mid = 0 + 12 = 11 / 2 = 5

    5 / n = 5 / 4 = 1
    5 % n = 5 % 4 = 1

    matrix[1][2] = 11
    15 > 11
    left = mid + 1

    mid = 6 + 11 = 17 / 2 = 8

    8 / 4 = 2
    8 % 4 = 0
*/

// after thinking about it, I decided follow a consider the matrix
// as a flat array approach
// so to calculate my position in relation to my mid value
// I just need to divide by the numbers of the columns (n)
// that represent the length of rows, in that was I can find
// the row number, and using the rest of my division (current pointer - (row number * row length)) - where my current pointer is the mid of
// the flat array - I can find the position within this row
// that is equivalent to my column in a matrix

// pick my m and n length
// establish left and right, where right will be calculated as a flat array
// while left is smaller or equal to left keep looping
// calculate mid adding left and right then divide them by 2
// calculate my row dividing mid by n, and my column with the rest of this division
// check if target is equal to mid, if yes return true
// otherwise check if is greater, then set left as mid + 1
// if isn't, set right as mid - 1
// if I iterate through the whole flat array and didn't find target
// return false 


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = (m * n) - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            int row = mid / n;
            int col = mid % n;

            if(target == matrix[row][col])
                return true;
            else if (target > matrix[row][col])
                left = mid + 1;
            else
                right = mid - 1;
        }

        return false;
    }
}
