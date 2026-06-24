class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = HashMap.newHashMap(board.length);
        Map<Integer, Set<Character>> columns = HashMap.newHashMap(board.length);
        Map<String, Set<Character>> grids = HashMap.newHashMap(board.length);

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] == '.')
                    continue;
                String gridIndex = String.valueOf(i / 3 + "," + j / 3);
                if((rows.get(i) != null && rows.get(i).contains(board[i][j]))
                    || (columns.get(j) != null && columns.get(j).contains(board[i][j]))
                    || ( grids.get(gridIndex) != null && grids.get(gridIndex).contains(board[i][j])))
                    return false;

                rows.computeIfAbsent(i, k -> new HashSet()).add(board[i][j]);
                columns.computeIfAbsent(j, k -> new HashSet()).add(board[i][j]);
                grids.computeIfAbsent(gridIndex, k -> new HashSet()).add(board[i][j]);
            }   
        }

        return true;
    } 
}
