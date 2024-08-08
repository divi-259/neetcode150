class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        double arr[][] = new double[position.length][2];
        for(int i=0; i<position.length; i++) {
            arr[i][0] = (double)position[i];
            arr[i][1] = (double)speed[i];
        }
        Arrays.sort(arr, (a,b) -> Double.compare(a[0],b[0]));
        double timetoreach[] = new double[arr.length];
        int ans = 1;
        timetoreach[n-1] = (target-arr[n-1][0])/arr[n-1][1];
        for(int i=arr.length-2; i>=0; i--) {
            double time = (target-arr[i][0])/arr[i][1];
            if(time <= timetoreach[i+1])
            {
                timetoreach[i] = timetoreach[i+1];
            }
            else {
                timetoreach[i] = time;
                ans++;
            }
        }

        return ans;
    }
}
