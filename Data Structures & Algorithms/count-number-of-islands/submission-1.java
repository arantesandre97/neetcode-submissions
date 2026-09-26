// if I count the connected land I can actually count the number os separated island, because all edges are water
// so I need to connect the ones creating a graph than search how many graphs I have. Am I in the right track?

/*
islandsColor as 2
islandsCount as 0
For each row I will check if the cell is 0 or bigger than 1
in positive case I can skip that cell, 'cause is water or already visited
otherwise I'll create a queue and color the neighbors with that current islandsColor
when my queue is empty I will increment my islandsColor and islandsCount by one
when I visited all rows elements I return my islandsCount
*/
class Solution {
    public int numIslands(char[][] grid) {
        char islandColor = '2';
        int islandsCount = 0;
        
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '0' || grid[i][j] > '1')
                    continue;
                
                Queue<int[]> lands = new ArrayDeque<>();
                grid[i][j] = islandColor;
                lands.offer(new int[] {i,j});

                while(!lands.isEmpty()) {
                    int[] land = lands.poll();
                    int upNeighbor = land[0] - 1;
                    int downNeighbor = land[0] + 1;
                    int leftNeighbor = land[1] - 1;
                    int rightNeighbor = land[1] + 1;

                    if(upNeighbor >= 0 && grid[upNeighbor][land[1]] == '1'){
                        grid[upNeighbor][land[1]] = islandColor;
                        lands.offer(new int[] {upNeighbor, land[1]});
                    }

                    if(downNeighbor < n && grid[downNeighbor][land[1]] == '1'){
                        grid[downNeighbor][land[1]] = islandColor;
                        lands.offer(new int[] {downNeighbor, land[1]});
                    }

                    if(leftNeighbor >= 0 && grid[land[0]][leftNeighbor] == '1') {
                        grid[land[0]][leftNeighbor] = islandColor;
                        lands.offer(new int[] {land[0], leftNeighbor});
                    }

                    if(rightNeighbor < m && grid[land[0]][rightNeighbor] == '1') {
                        grid[land[0]][rightNeighbor] = islandColor;
                        lands.offer(new int[] {land[0], rightNeighbor});
                    }
                }
                islandColor++;
                islandsCount++;
            }
        }

        return islandsCount;
    }
}
