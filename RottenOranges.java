import java.util.*;

public class RottenOranges {

    public static int count(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = (Queue<int[]>) new LinkedList();
        int fresh = 0;

        // Add all initially rotten oranges to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int minutes = 0;
        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            minutes++;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                for (int[] dir : directions) {
                    int row = current[0] + dir[0];
                    int col = current[1] + dir[1];

                    if (row >= 0 && row < n &&
                        col >= 0 && col < m &&
                        grid[row][col] == 1) {

                        grid[row][col] = 2;
                        fresh--;
                        queue.offer(new int[]{row, col});
                    }
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int ans = count(grid);
        System.out.println(ans);
    }
}