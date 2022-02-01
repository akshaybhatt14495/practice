package gfg;

public class Sudoku {
    public static void main(String[] args) {
        char board[][]  = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(board);
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[i].length;j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void solveSudoku(char[][] board) {

        recursive(board, 0, 0);

    }

    static boolean recursive(char[][] board, int row, int col) {

        if (row==8&&col ==9) {
            return true;
        }
        if (col==9) {
            col=0;
            row++;
        }



        if (board[row][col]!='.')  {
            return recursive(board, row, col+1);
        }

        for (int i=1; i<10;i++) {
            if (validateBoard(board, row, col, (char)('0'+i))) {
                board[row][col] = (char)('0'+i);
                if (recursive(board,  row, col+1)) {
                    return true;
                }
            }
            board[row][col] = '.';
        }
        return false;

    }

    static boolean validateBoard(char[][] board, int row, int col, char c) {
        //row check
        char current=c;
        for (int i=0; i<=8;i++) {
            if (board[i][col] == current) {
                return false;
            }
        }

        //col check
        for (int i=0; i<=8;i++) {
            if ( board[row][i] == current) {
                return false;
            }
        }

        //grid check
//        for (int i=(row/3)*3; i<(row/3+1)*3;i++) {
//            for (int j=(col/3)*3; j<(col/3+1)*3;j++) {
//                if (i!=row && j!=col && board[i][j] == current) {
//                    return  false;
//                }
//            }
//        }
        int startRow = row - row % 3, startCol
                = col - col % 3;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++)
                if (board[i + startRow][j + startCol] == current)
                    return false;
        }


        return true;
    }
}
