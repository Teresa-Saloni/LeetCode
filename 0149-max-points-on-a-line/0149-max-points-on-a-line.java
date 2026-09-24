class Solution {
    public int gcd(int a,int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public int maxPoints(int[][] points) {
        if(points.length <= 2)return points.length;
        int ans = 2;
        for(int i = 0; i < points.length ; i++){
            HashMap<String,Integer> map = new HashMap<>();
            for(int j = i+1;j < points.length; j++){
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int gc = gcd(Math.abs(dx),Math.abs(dy));
                dx = dx / gc;
                dy = dy / gc;
                if(dx < 0){
                    dx = -dx;
                    dy = -dy;
                }
                if(dx == 0){
                    dy = 1;
                }
                if(dy == 0){
                    dx = 1;
                }
                String slope = dx + "/" + dy;
                map.put(slope,map.getOrDefault(slope,1)+1);
                ans = Math.max(ans,map.get(slope));
            }
        }
        return ans;
    }
}