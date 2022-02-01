package leetcode;

import java.util.LinkedList;
import java.util.List;


public class SpiralMatrix {
    public static void main(String[] args) {
        System.out.println(new SpiralMatrix().spiralOrder(new int[][]{
                {1,2,3}, {4,5,6}, {7,8,9}
        }));
    }
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new LinkedList<>();

        if (matrix.length==0) {
            return result;
        }

        int direction=0;
        int totalElements = matrix.length * matrix[0].length;
        int upRow=0, bottomRow=matrix.length-1, leftCol=0, rightCol=matrix[0].length-1;

        int i=0, j=0;
        while (result.size() <  totalElements) {
            switch (direction) {
                case 0: { // leftToRight
                    if (j > rightCol) {
                        direction = (direction+1)%4;
                        upRow++;
                        j=rightCol;
                        i=i+1;

                    } else {
                        result.add(matrix[i][j]);
                        j++;
                    }
                    break;
                }
                case 1: { // top to bottom
                    if ( i> bottomRow) {
                        direction = (direction+1)%4;
                        rightCol--;
                        i=bottomRow;
                        j--;
                    } else {
                        result.add(matrix[i][j]);
                        i++;
                    }
                    break;

                }
                case 2: {
                    if (j < leftCol) {
                        direction = (direction+1)%4;
                        bottomRow--;
                        j=leftCol;
                        i--;
                    } else {
                        result.add(matrix[i][j]);
                        j--;
                    }
                    break;
                }
                case 3: {
                    if (i <upRow) {
                        direction = (direction+1)%4;
                        leftCol++;
                        i=upRow;
                        j++;
                    } else {
                        result.add(matrix[i][j]);
                        i--;
                    }
                    break;
                }

            }
        }

        return result;
    }
}
