package lintcode;

import java.util.LinkedList;
import java.util.Queue;

public class Doors {

    public static void main(String[] args) {
        //],[],[],[
        int arr[][]= new int[][]{
                {2147483647,    -1,         0,          1},
                {2147483647,    2147483647, 2147483647, -1},
                {2147483647,    -1,         2147483647, -1},
                {0,             -1,         2147483647,  2147483647}
        };
        new Doors().wallsAndGates(arr);
    }

    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */

    public void wallsAndGates(int[][] rooms) {
        for (int i=0; i< rooms.length; i++){
            for (int j=0; j< rooms[i].length;j++){
                if (rooms[i][j]==0) {
                    bfs(rooms, i,j);
                }
            }
        }
    }


    void bfs(int[][] rooms, int row, int col) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(row,col, 0));
        rooms[row][col] = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Point p  = q.remove();
            if (p.row<0 || p.row >=rooms.length || p.col<0 || p.col >=rooms[p.row].length || rooms[p.row][p.col]==-1) {
                continue;
            }

            if (rooms[p.row][p.col]>p.val)  {
                rooms[p.row][p.col]=p.val;
                q.add(new Point(p.row+1,p.col, rooms[p.row][p.col]+1));
                q.add(new Point(p.row,p.col+1, rooms[p.row][p.col]+1));
                q.add(new Point(p.row-1,p.col, rooms[p.row][p.col]+1));
                q.add(new Point(p.row,p.col-1, rooms[p.row][p.col]+1));
            }
        }
    }


}

class Point {
    int row;
    int col;
    int val;
    Point(int row,int col, int val) {
        this.row=row;
        this.col=col;
        this.val=val;
    }
}
