package com.pawan.LLD.interview;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Pawan Saini
 * Created on 11/10/24.
 */
public class Test3 {

//    Given a string s and a list of strings strList,
//    return true if s can be partitioned into a space-separated sequence of one or more strList words.
//    We can reuse the words from strList if needed.
//
//    ex: s = “knightrookbishop”, strList = ["night", "bishop", "knight", "rook"]
//    Output = true
//
//    ex: s = “catsandog”, strList = ["cats","dog","sand","and","cat"]
//    Output = false

    public Boolean isPartitionPossible(String str, List<String> list) {
        Set<String> set = new HashSet<>(list);
        int n = str.length();
        Boolean dp[][] = new Boolean[n][n];
        return partition(str, n-1, n-1, set, dp);
    }

    private Boolean partition(String str, int s, int e, Set<String> set, Boolean dp[][]) {
        if(s==0) {
            if(set.contains(str.substring(s, e+1))) {
                return true;
            }
            return false;
        }
        if(dp[s][e] != null) {
            return dp[s][e];
        }
        if(!set.contains(str.substring(s, e+1))) {
            dp[s][e] = partition(str, s-1, e, set, dp);
        } else {
            dp[s][e] = partition(str, s-1, s-1, set, dp) || partition(str, s-1, e, set, dp);
        }
        return dp[s][e];
    }
}
