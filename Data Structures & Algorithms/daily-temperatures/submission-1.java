class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> ngeIdxStack = new Stack<Integer>();
        int[] ngeIdxDiff = new int[n];
    
        for(int i = n-1; i>=0; i--) {
            int ngeIdx = -1;
            if(!ngeIdxStack.isEmpty()) {
                ngeIdx = ngeIdxStack.peek();
            }
            while(ngeIdx != -1 
                && temperatures[ngeIdx] <= temperatures[i]) {
                ngeIdxStack.pop();
                if(ngeIdxStack.isEmpty()) {
                    ngeIdx = -1;
                } else {
                    ngeIdx = ngeIdxStack.peek();
                }
            }
            if(ngeIdx == -1) {
                ngeIdxDiff[i] = 0;
            } else {
                ngeIdxDiff[i] = ngeIdx-i;
            }
            ngeIdxStack.push(i);
        }
        return ngeIdxDiff;
    }
}
