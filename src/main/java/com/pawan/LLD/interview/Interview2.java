package com.pawan.LLD.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Pawan Saini
 * Created on 04/10/24.
 */
public class Interview2 {

    //    moneyview

    public void maxDistinctSubStrLen() {
        int k = 3;
        String str = "aaabbccd";
        int lenMax = maxLenDistinctCharSubString(str, k);
        System.out.println(lenMax);
    }

    private int maxLenDistinctCharSubString(String str,  int k) {
        int lenMax = -1;
        int l=0,r=0, n=str.length();
        Set<Character> set = new HashSet<>();
        while(r<n) {
            set.add(str.charAt(r));
            if(set.size() == k+1) {
                lenMax = Math.max(lenMax, (r-l));
                char c  =str.charAt(l);
                while(l<n && str.charAt(l)==c) {
                    l++;
                }
                set.remove(c);
            }
            r++;
        }
        if(set.size() == k) {
            lenMax = Math.max(lenMax, (r-l));
        }
        return lenMax;
    }

    public void maxContinueSeq() {
        int arr[] = {2,1,4,5,3,6,21,24,23,22,7,8,31,33,32};
        System.out.println(getMaxConSeq(arr));
    }

    private int getMaxConSeq(int arr[]) {
        int maxLen = 0, n = arr.length;

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++) {
            set.add(arr[i]);
        }
        for(int i=0; i<n;i++) {
            if(!set.contains(arr[i]-1)) {
                int start = arr[i];
                while(set.contains(start)) {
                    start++;
                }
                maxLen = Math.max(maxLen, start-arr[i]);
            }
        }
        return maxLen;
    }
}
