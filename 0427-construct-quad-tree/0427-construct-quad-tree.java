class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }

    private Node build(int[][] grid, int row, int col, int size) {

        // Check if all values in this square are the same
        boolean same = true;
        int val = grid[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != val) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        // If all values are same -> leaf node
        if (same) {
            return new Node(val == 1, true);
        }

        // Otherwise divide into 4 parts
        int half = size / 2;

        Node topLeft =
            build(grid, row, col, half);

        Node topRight =
            build(grid, row, col + half, half);

        Node bottomLeft =
            build(grid, row + half, col, half);

        Node bottomRight =
            build(grid, row + half, col + half, half);

        return new Node(
            true,
            false,
            topLeft,
            topRight,
            bottomLeft,
            bottomRight
        );
    }
}