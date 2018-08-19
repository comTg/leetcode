package top.vetoer.Array;

import top.vetoer.TimeHelper;

public class MaxAreaOfIsland {
    int[][] grid;
    boolean[][] seen;

    public int area(int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || seen[r][c] || grid[r][c] == 0)
            return 0;
        seen[r][c] = true;
        return (1 + area(r + 1, c) + area(r - 1, c) + area(r, c - 1) + area(r, c + 1));
    }

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                ans = Math.max(ans,area(r,c));
            }
        }
        return ans;
    }

    // a simple dfs solution
    int dfs(int[][] grid,int i ,int j,int m,int n,int area){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == 0)
            return area;
        grid[i][j] = 0;
        area++;
        area = dfs(grid,i+1,j,m,n,area);
        area = dfs(grid,i,j+1,m,n,area);
        area = dfs(grid,i-1,j,m,n,area);
        area = dfs(grid,i,j-1,m,n,area);
        return area;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland mai = new MaxAreaOfIsland();
        int[][] grid_t = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int[][] grid_1 = {{1}};
        long start = TimeHelper.start();
        int r = mai.maxAreaOfIsland(grid_1);
        TimeHelper.runTime(start);
        System.out.println(r);
    }
}
