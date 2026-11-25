/**
 * 1. CONSTRAINTS + 2 EXAMPLES
 * The grid has at least 1 row and 1 column.
 * It's possible to have no island at all (fully 0).
 * I can start searching from any position.
 * Input: grid = [
    ["0","1","1","1","0"],
    ["0","1","0","1","0"],
    ["1","1","0","0","0"],
    ["0","0","0","0","0"]
  ]
 * Output: 1
 * Input: grid = [
    ["1","1","0","0","1"],
    ["1","1","0","0","1"],
    ["0","0","1","0","0"],
    ["0","0","0","1","1"]
  ]
 * Output: 4
 *
 * 2. EDGE CASES (one per category)
 * Size:          1x1 grid
 * Empty:         none island grid (fully 0)
 * Full:          1 big island on the entire grid (fully 1)
 * Shape:         1 row, several columns: [1,0,1,1] -> 2.
 *                Catches a wrong row bounds check (up/down neighbors fall outside).
 * Many islands:  ["1","0","1"] / ["1","0","1"] -> 2.
 *                Catches counting the same island twice if I don't mark on enqueue.
 *
 * 3. BRUTE FORCE + BIG O
 * For each 1, I run a traversal with its own visited set, so I redo the
 * traversal m * n times. Time: O( (m*n) * (m*n) ).
 * Space: O(m*n)
 * Brute force is way slower than the optimal solution.
 *
 * 4. PATTERN AND WHY
 * BFS, because it helps me keep enqueueing lands while I have neighbor lands.
 * Time: O(m*n). Space: O(1) (visited) + O(min(m,n)) (queue):
 * the queue only holds the frontier.
 * Why not DFS: Same time as BFS, O(m*n). The difference is space:
 * a recursive DFS can go m*n frames deep (a snake-shaped island) and overflow
 * the call stack in Java, while the BFS queue only holds the frontier.
 *
 * 5. INVARIANT
 * I guarantee that I'll visit a land once, because I mark them as visited
 * while enqueueing it. And that prevents an enqueued land from being
 * enqueued again.
 */

class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int[][] dirs = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
        Queue<int[]> lands = new ArrayDeque<>();

        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] == '0') 
                    continue;

                islands++;
                grid[r][c] = '0';
                lands.offer(new int[]{r,c});

                while(!lands.isEmpty()) {
                    int[] land = lands.poll();

                    for(int[] d : dirs) {
                        int adjacentR = land[0] + d[0];
                        int adjacentC = land[1] + d[1];

                        if(adjacentR < 0 || adjacentR >= grid.length || adjacentC < 0 || adjacentC >= grid[adjacentR].length
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
