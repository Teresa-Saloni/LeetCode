class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination )return true;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean visited[] = new boolean[n];
        Queue <Integer> q = new LinkedList<>();
        q.offer(source);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int next : graph.get(curr)){
                if(destination == next){
                    return true;
                }
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        return false;
    }
}