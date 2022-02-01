package gfg;

public class MatrixRotation {
    //Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int matrix[][], int n)
    {
        int cycles = (int) Math.ceil(n/2.0);


        for (int i=0; i < cycles; i++) {
            //iterate columns of all rows of cycle
            int k= cycles+1;
            for (int j= cycles; j < matrix[0].length-cycles -1; j++) {
                int temp = matrix[i][j] ;
            }
        }

    }
}
