/**
is there possible to the grid didn't have island at all?
can the grid be empty? at least 1 row and 1 column
can I start searching from any position?

edge case
1x1 grid
none island grid (fully 0)
1 big island grid on the entire grid (fully 1)

brute force
for each position check the neighboors, if it has neighboors check if neighboors has a value 0.
if doesn't, I check if value is 1 or other value to represent a already island. So, for each island
I may use a different number to represent, maybe starting with 1 counter. Then I increment it every
time I found a new 1. Because when I visit the neighboors I'll set them value as the current island counter
At the end I'll return counter - 1

this approach will take a O(n**2) time complexity and O(1) space complexity, as I don't need any extra
data structure to storage some data. Also I'm changing island values at the current array


optmized version
I'm thinking about using BFS or DFS, with DFS I can go deeper and color each tile attached to the same island
but I don't think DFS will be a good approach to keep tracking island when I encounter a zero.

In other hand BFS can help me keep tracking/enqueueing lands while I have neighboor lands. But I need to that
throw my array, and to prevent visiting the already visited lands I need to check if the number is zero or bigger than 1
in that way I can improve my perfomance. I'll guarantee that I gonna visit lands at most one time.

I guarantee that no lands gonna be visited twice, as I gonna marked them as visited using a island counter.
*/

class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for(int r = 0; r < grid.length; r++) {
            Queue<int[]> lands = new ArrayDeque<>();

            for(int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] == '0') 
                    continue;

                islands++;
                grid[r][c] = '0';
                lands.offer(new int[]{r,c});

                while(!lands.isEmpty()) {
                    int[] land = lands.poll();
                    int[][] dirs = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};

                    for(int[] d : dirs) {
                        int adjacentR = land[0] + d[0];
                        int adjacentC = land[1] + d[1];

                        if(adjacentR < 0 || adjacentR >= grid.length || adjacentC < 0 || adjacentC >= grid[r].length
                         || grid[adjacentR][adjacentC] == '0')
                            continue;

                        grid[adjacentR][adjacentC] = '0';
                        lands.offer(new int[] { adjacentR, adjacentC });
                    }
                }
            }
        }

        return islands;
    }
}
