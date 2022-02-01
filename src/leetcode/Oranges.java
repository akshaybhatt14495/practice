package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class Point {
    int r;
    int c;

    Point(int x, int y) {
        r=x;
        c=y;
    }
}
public class Oranges {

    public static void main(String[] args) {
        int oranges[][] = new int[][]{
                {2,1,1},
                {1,1,0},
                {0,1,1},
        };
        System.out.println(new Oranges().orangesRotting(oranges));
    }
    public int orangesRotting(int[][] grid) {
        Queue<Point> q = new LinkedList<>();
        int remaining=0;
        for (int i=0; i< grid.length; i++) {
            for (int j=0; j< grid[i].length;j++) {
                if (grid[i][j]==2) {
                    q.add(new Point(i,j));
                }

                if (grid[i][j]==1) {
                    remaining++;
                }
            }
        }


        int minutes=0;
        while (remaining>0) {
            int length=q.size();
            if (length==0) {
                return -1;
            }
            for (int i=0; i<length;i++) {

                Point p = q.remove();
                if (p.r < 0 || p.r >=grid.length|| p.c<0 || p.c >=grid[p.r].length) {
                    continue;
                }

                int x,y;

                int []xCord = new int []{1,0,-1,0};
                int []yCord = new int[]{0,1, 0, -1};

                for (int idx=0; idx < xCord.length; idx++){
                    x=p.r + xCord[idx] ; y=p.c + yCord[idx];
                    if (x >= 0 && x < grid.length && y>=0 && y < grid[x].length && grid[x][y] ==1) {
                        remaining--;
                        grid[x][y]=2;
                        q.add(new Point(x, y));
                    }
                }
            }
            minutes++;
        }


        return minutes;
    }

}