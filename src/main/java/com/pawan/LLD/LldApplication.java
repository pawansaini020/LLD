package com.pawan.LLD;

import com.pawan.LLD.interview.Interview2;
import com.pawan.LLD.lld.snakeandladder.manager.GameManager;
import com.pawan.LLD.lld.snakeandladder.service.GameService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class LldApplication {

	/*Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

	You must write an algorithm that runs in O(n) time.

	Example 1:

	Input: nums = [100,4,200,1,3,2]
	Output: 4*/
	//100,4,200,1,3,2

	/*Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

	Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
	Example 1:
	Input: num1 = "123", num2 = "456"
	Output: "56088"*/




	public static void main(String[] args) {
		SpringApplication.run(LldApplication.class, args);
		int [] nums = {100,4,200,1,3,2};
		int [] nums2 = {};
		int [] num3 =  {1,3,5,6,7};
		int [] nums4 = {1};
		int [] nums5 = {1,1,0,2};
		int [] nums6 = {1,2,3,4,5};
		int [] nums7 = {0,3,7,2,5,8,4,6,0,1};

		multiplyStrings("123","456");



	}
	private static void multiplyStrings(String nums1,String nums2){
		if(nums1.equals("0") || nums2.equals(0)){
			//return "0";
		}

		int [] resultArray =  new  int [nums1.length() + nums2.length()  ];

		for(int m = nums1.length()-1 ; m >=0 ;m--){
			for(int n = nums2.length()-1 ; n>=0 ;n--){
				int temp = (nums1.charAt(m) - '0') * (nums2.charAt(n) -'0');

				int result =  temp +resultArray[m+n+1];

				int val = result%10;
				int carry = result/10;

				resultArray[m+n+1] = val ;
				resultArray[m+n] += carry;

			}

		}

		for(int i  = 0;i<nums1.length() + nums2.length() + 1 ;i++){
			System.out.println(resultArray[i]);
		}


	}

	private static int longestConsecutive(int [] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		Set<Integer> distinctElements =  new HashSet<>();
		for(int num :nums){
			distinctElements.add(num);
		}

		int longestStreak = 0;

		for(int num:nums){
			if(!distinctElements.contains(num -1)){
				int currentNum = num;
				int currentStreak = 1;
				while(distinctElements.contains(currentNum+1)){
					currentNum++;
					currentStreak++;
				}

				longestStreak = Math.max(longestStreak,currentStreak);

			}
		}

		return longestStreak;


	}

}
