class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int l = 0, r = 0;
        Map<Character, Integer> charFirstIdxMap = new HashMap<>();
        while(r<s.length()) {
            char currChar = s.charAt(r);
            if(charFirstIdxMap.containsKey(currChar)) {
                l = Math.max(l, charFirstIdxMap.get(currChar) + 1);
            }
            charFirstIdxMap.put(currChar, r);
            maxLength = Math.max(maxLength, r-l+1);
            r++;
        }
        return maxLength;
    }
}
