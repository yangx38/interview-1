package hatecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : WallsandGates
 * Creator : duqiang
 * Date : Sep, 2018
 * Description : 286. Walls and Gates
 */
public class WallsandGates {
    /**
     * You are given a m x n 2D grid initialized with these three possible values.

     -1 - A wall or an obstacle.
     0 - A gate.
     INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume
     that the distance to a gate is less than 2147483647.
     Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate,
     it should be filled with INF.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.


     For example, given the 2D grid:
     INF  -1  0  INF
     INF INF INF  -1
     INF  -1 INF  -1
     0  -1 INF INF

     After running your function, the 2D grid should be:
     3  -1   0   1
     2   2   1  -1
     1  -1   2  -1
     0  -1   3   4

     time : O(4^n)
     space : O(4^n)

     * @param rooms
     */

    // space : O(n)
    // thinking process:
    
    //this problem is to say in a 2D array, 
    //we have 3 types of elements, INF empty room, -1 means wall, 0 means gate
    // so we need to find for each room, the smallest steps to gate, 
    // each move(4 directions) will be 1. and mark each room with steps to nearest gate
    
    //we can start from each room, and we use BFS to visit each gate and get the nearest one. 
    //another way is to visit by dfs, we start from gate, and record each steps in each room until 
    //we find next shorter ones
    
    //dfs exit condition: rooms[i][j] < dis , dis start value is 0. and we set room value 
    //in dfs function
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j, int dis) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length 
                // gate is -1, dis is at least 0 so it is good
                || rooms[i][j] < dis) return;
        //we set the distance first
        rooms[i][j] = dis;
        dfs(rooms, i - 1, j, dis + 1);
        dfs(rooms, i + 1, j, dis + 1);
        dfs(rooms, i, j + 1, dis + 1);
        dfs(rooms, i, j - 1, dis + 1);
    }

    public void wallsAndGates2(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int row = top[0], col = top[1];
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row - 1, col});
            }
            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row + 1, col});
            }
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col - 1});
            }
            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col + 1});
            }
        }
    }
}
