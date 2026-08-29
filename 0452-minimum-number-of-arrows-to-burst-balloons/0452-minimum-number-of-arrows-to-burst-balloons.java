class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));   // sort by END

        int arrows = 1;
        int arrowPos = points[0][1];          // shoot at the first balloon's end

        for (int[] p : points) {
            if (p[0] > arrowPos) {            // this balloon starts after the arrow → not burst
                arrows++;
                arrowPos = p[1];              // new arrow at ITS end
            }
        }
        return arrows;
    }
}