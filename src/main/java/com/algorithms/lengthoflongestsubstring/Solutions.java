package com.algorithms.lengthoflongestsubstring;

import java.util.HashSet;

public class Solutions {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int right = 0;
        int left = 0;
        int maxLength = 0;
        HashSet<Character> window = new HashSet<>();
        while (right < n) {
            Character c = s.charAt(right);
            while(window.contains(c)) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(c);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
