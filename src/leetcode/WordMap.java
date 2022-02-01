package leetcode;

public class WordMap {
    public static void main(String[] args) {
        char [][]board = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        System.out.println(new WordMap().exist(board, "ABCCED"));
    }
    public boolean exist(char[][] board, String word) {

        if (board==null || board.length==0) {
            return false;
        }
        boolean visited[][]=new boolean[board.length][board[0].length];


        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[i].length;j++) {
                if (dfs(board, visited, i,j,word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }


    boolean dfs(char[][] board,  boolean visited[][], int row, int col, String word, int charIdx) {

        if (charIdx == word.length()) {
            return true;
        }

        try {
            if (row<0 || row >=board.length || col < 0 || col>=board[row].length || visited[row][col] || board[row][col] != word.charAt(charIdx)) {

                return false;
            }
        } catch (Exception ex) {
            System.out.println(String.format("board dimensions[%d,%d], current [%d, %d], word.length=%d, charIdx=%d", board.length, board[row].length,row, col, word.length(), charIdx ));
            throw ex;
        }


        visited[row][col] = true;

        boolean isWord=false;
        isWord = isWord || dfs(board, visited, row+1,col,word, charIdx+1);
        if (isWord) {
            return true;
        }
        isWord = isWord || dfs(board, visited, row-1,col,word, charIdx+1);
        if (isWord) {
            return true;
        }
        isWord = isWord || dfs(board, visited, row,col+1,word, charIdx+1);
        if (isWord) {
            return true;
        }
        isWord = isWord || dfs(board, visited, row,col-1,word, charIdx+1);
        if (isWord) {
            return true;
        }
        visited[row][col] = false;
        return false;
    }
}
