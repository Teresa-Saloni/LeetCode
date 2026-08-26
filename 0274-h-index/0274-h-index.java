class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int arr[] = new int[n+1];
        for(int i = 0; i < n; i ++){
            if(citations[i] >= n){
                arr[n]++;
            }else{
                arr[citations[i]]++;
            }
        }
        int papers = 0;
        int h = 0;
        for(h= n; h >=0 ; h--){
            papers += arr[h];
            if(papers >= h){
                return h;
            }
        }
        return 0;
    }
}