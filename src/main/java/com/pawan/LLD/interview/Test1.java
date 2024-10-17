package com.pawan.LLD.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pawan Saini
 * Created on 10/10/24.
 */
public class Test1 {

//    given number if the column
//    find name if column

//    public static void main(String[] args) {
//        String ans = columnName(256);
//    }

    public static String columnName(int colNum) {
        StringBuilder colName = new StringBuilder();
        if(colNum<=0) {
            return colName.toString();
        }

        while(colNum>0) {
            colNum--;
            char c = (char) ('A' + colNum%26);
            colName.append(c);
            colNum /=26;
        }
        String columnName= colName.reverse().toString();
        System.out.println(columnName);
        return columnName;
    }

//    Given an array of intervals where intervals[i] = [starti, endi],
//    merge all overlapping intervals, and return an array of the non-overlapping
//    intervals that cover all the intervals in the input.



    public int[][] mergeOverLapping(int arr[][]) {
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;
        if(n==0) {
            return new int[0][0];
        }
        Arrays.sort(arr, (a,  b) -> Integer.compare(a[0], b[0]));
        int start = arr[0][0], end = arr[0][1];
        for(int i=1; i<n; i++) {
            if(arr[i][0]<=end) {
                end = Math.max(end, arr[i][1]);
            } else {
                List<Integer> ans = new ArrayList<>();
                ans.add(start);
                ans.add(end);
                res.add(ans);
                start = arr[i][0];
                end = arr[i][1];
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(start);
        ans.add(end);
        res.add(ans);
        int k = res.size();
        int[][] overlappedArr = new int[k][2];
        for(int i=0; i<k;i++) {
            overlappedArr[i][0]= res.get(i).get(0);
            overlappedArr[i][1]= res.get(i).get(1);
        }
        return overlappedArr;
    }
}
