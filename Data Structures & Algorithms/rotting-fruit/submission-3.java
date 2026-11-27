/*
1. Constraints and 2 examples of your own.
No rotten fruit is guaranteed to be placed within the grid
The grid can have from 1 to 10 lines and the same range for columns
So the grid cannot be void

Example:
Input: grid = [
[2,2,0]
[0,2,2]
[0,2,2]
]
minute 0 = 1 fruit rotten
minute 1 = 3 fruits rotten
minute 2 = 4 fruits rotten
minute 3 = 5 fruits rotten
minute 4 = all 6 fruits rotten
Output: 4

Input: grid = [
[1,0,1]
[0,2,0]
[1,0,1]
]
minute 0 = 1 fruit rotten
minute 1 = 1 fruits rotten
Output: -1

2. 5 edge cases, one per category: 
size: one line and multiple columns grid 
values: full grid with rotten fruits
structure: rotten fruits only connected by diagonals
semantics: one isolated rotten fruit
termination: one fresh fruit isolated from other fresh or rotten fruits

3. Brute force and its Big O.
Check every fruit in the grid if is rotten, make the neighbors rotten to, do that until no fresh fruit be turned in rotten
if the total of find fruits if different from rotten fruits, return -1 other wise return the counter of each round taken

4. The pattern you chose and why.
Using a BFS is a good way to keep tracking the rotten fruits, because we don't wanna enqueue fresh fruit, as they cannot
make other fruits rotten. The strategy is to process only the rotten fruits each minute, so we can track how many minutes
took to all fruits got rotten. Maybe we'll need a fresh fruit controll also, because I'm think in a way to check if all
fruits got rotten, otherwise I will return -1.

5. The invariant: "I guarantee X because Y".

I guarantee that every rotten fruit neighbor gonna me rotted right before enqueueing it, so my queue gonna always have
only rotten fruits. Because only rotten fruits can affect fresh fruits.

Alternative version to check:
I guarantee that every round I gonna only spread the rot in adjacent fresh fruits, so in that way I can count how many
minutes it took to get all fruits to be rotten.

*/

/*
search for rotten fruit in the grid and enqueueing them
also count the fresh fruits, so I can use as base to return minutes or -1
if queue size == 0, return -1 (early return)
start the minutes counter
else keep tracking rotten fruits until my queue is empty
for each round I gonna loop through all enqueued rotten fruits
and check for horizontally and vertically neighbors
if a neighbors is a fresh fruit(1), I rot and enqueue it, also decrease the fresh fruits count
finally I increment the minutes counter
when my queue is empty I check for fresh fruits counter, if is 0 I'll return minutes counter
otherwise return -1
*/
class Solution {
    public int orangesRotting(int[][] grid) {
        int freshCount = 0;
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        Deque<int[]> rottenFruits = new ArrayDeque<>();

        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] == 2)
                    rottenFruits.offer(new int[]{r,c});
                else if(grid[r][c] == 1)
                    freshCount++;
            }
        }

        int minutes = 0;
        while(!rottenFruits.isEmpty() && freshCount > 0) {
            int currentRottenFruits = rottenFruits.size();
            for(int i = 0; i < currentRottenFruits; i++) {
                int[] rottenFruit = rottenFruits.poll();

                for(int[] dir : dirs) {
                    int r = rottenFruit[0] + dir[0];
                    int c = rottenFruit[1] + dir[1];

                    if(r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] != 1)
                        continue;
                    
                    grid[r][c] = 2;
                    freshCount--;
                    rottenFruits.offer(new int[]{r,c});
                }
            }
            minutes++;
        }

        return freshCount == 0 ? minutes : -1;
    }
}
