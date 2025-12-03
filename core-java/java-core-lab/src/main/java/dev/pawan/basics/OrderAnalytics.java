package dev.pawan.basics;

import java.util.*;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Map;
//import java.util.Queue;

public class OrderAnalytics {
    private void validateDailyOrders(int[] dailyOrders){
        if(dailyOrders == null || dailyOrders.length == 0){
            throw new IllegalArgumentException("dailyOrders must not be empty or null");
        }
    }


    //Total and Average
    // Method to calculate total orders
    public long calculateTotal(int[] dailyOrders){
        validateDailyOrders(dailyOrders);
        long total = 0;
        for(int order : dailyOrders){
            total += order;
        }
        return total;
    }

    //Method to calculate average order per day
    public  double calculateAverage(int[] dailyOrders){
        validateDailyOrders(dailyOrders);
        long total = calculateTotal(dailyOrders);
        return (double)total/(double)dailyOrders.length;
    }


    //finding min and max
    //Method to find maximum order in a single day
    public  int findMaximum(int[] dailyOrders){
        validateDailyOrders(dailyOrders);
        int maximum = dailyOrders[0];
        for(int i = 1; i < dailyOrders.length; i++){
            if(dailyOrders[i] > maximum){
                maximum = dailyOrders[i];
            }
        }
        return maximum;
    }

    //Method to  find index of maximum order
    public int indexOfMaximum(int[] dailyOrders){
        validateDailyOrders(dailyOrders);
        int maximum = dailyOrders[0];
        int maxIndex = 0;
        for(int i = 1; i < dailyOrders.length; i++){
            if(dailyOrders[i] > maximum){
                maximum = dailyOrders[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    //Method to find Minimum Orders in a Day
    public int findMinimum(int[] dailyOrders){
        validateDailyOrders(dailyOrders);
        int minimum = dailyOrders[0];
        for(int i = 1; i < dailyOrders.length; i++){
            if(dailyOrders[i] < minimum){
                minimum = dailyOrders[i];
            }
        }
        return minimum;
    }

    //Method to Find Day Index of Minimum Orders
    public int indexOfMinimum(int[] dailyOrders){
        validateDailyOrders(dailyOrders);
        int minValue = dailyOrders[0];
        int minIndex = 0;
        for(int i = 1; i < dailyOrders.length; i++){
            if(dailyOrders[i] < minValue){
                minValue = dailyOrders[i];
                minIndex = i;
            }

        }
        return minIndex;
    }

    //Cumulative Orders(Prefix sum)
    public int[] cumulativeOrders(int[] dailyOrders){
        validateDailyOrders(dailyOrders);
        int[] cumulative = new int[dailyOrders.length];
        int runningTotal = 0;
        for(int i = 0; i < dailyOrders.length; i++){
            runningTotal += dailyOrders[i];
            cumulative[i] = runningTotal;
        }
        return cumulative;
    }

    //Running Maximum (Prefix Maximum Array)
    public int[] runningMaximum(int[] dailyOrders){
        validateDailyOrders(dailyOrders);
        int[] runningMax = new int[dailyOrders.length];
        int maxSoFar = dailyOrders[0];
        runningMax[0] = maxSoFar;
        for(int i = 1; i < dailyOrders.length; i++){
            if(dailyOrders[i] > maxSoFar){
                maxSoFar = dailyOrders[i];
            }
            runningMax[i] = maxSoFar;
        }
        return runningMax;
    }

//    Fixed-size sliding window
//    🧩 Problem: Maximum Sum of Any Subarray of Size k
    public int maxSumSubarrayOfSizeK(int[] dailyOrders, int k){
        validateDailyOrders(dailyOrders);
        if(k < 1 || k > dailyOrders.length){
            throw new IllegalArgumentException("dailyOrders must have a value between 1 and " + (dailyOrders.length - 1));
        }
        int windowSum = 0;
        for(int i = 0; i < k; i++){
            windowSum += dailyOrders[i];
        }
       int maxWindowSum = windowSum;
        for(int i = k; i < dailyOrders.length; i++){
            windowSum += dailyOrders[i] - dailyOrders[i - k];// Adding element at k index and subtracting element from left(like first, then second, soon)
            if(maxWindowSum < windowSum){
                maxWindowSum = windowSum;
            }
        }
        return maxWindowSum;
    }
//🧩 New Task: Maximum Average Subarray of Size k
    public double maxAverageSubarrayOfSizeK(int[] dailyOrders, int k){
        validateDailyOrders(dailyOrders);
        if(k < 1 || k > dailyOrders.length){
            throw new IllegalArgumentException("k must have a value between 1 and " + dailyOrders.length);
        }
        int windowSum = 0;
        //First Window
        for(int i = 0; i < k; i++){
            windowSum += dailyOrders[i];
        }
        double maxAvgSoFar = (double) windowSum/k;
        //Sliding window
        for(int i = k; i < dailyOrders.length; i++){
            windowSum += dailyOrders[i] - dailyOrders[i - k];
            double maxAvg = (double) windowSum / k;
            if(maxAvgSoFar < maxAvg){
                maxAvgSoFar = maxAvg;
            }
        }
        return maxAvgSoFar;
    }



//    Variable-Size Sliding Window (Still Beginner-Friendly)
//    🧩 Problem: Longest Subarray With Sum ≤ S (Non-Negative Integers)
      public int longestSubarrayWithSumAtMostS(int[] dailyOrders, int S){
        validateDailyOrders(dailyOrders);
        if(S < 0){
            throw new IllegalArgumentException("S must be greater than or equal to 0");
        }
        int windowStart = 0, maxLengthSoFar = 0, windowSum = 0;
        for(int windowEnd = 0; windowEnd < dailyOrders.length; windowEnd++){
            windowSum += dailyOrders[windowEnd];
            while(windowSum > S) {
                windowSum -= dailyOrders[windowStart];
                windowStart++;
            }
            maxLengthSoFar = Math.max(maxLengthSoFar, windowEnd - windowStart + 1);
        }
        return maxLengthSoFar;
      }


      //🧩 Sliding Window Problem #3 (Very Important)
      //Longest Substring With At Most K Distinct Characters
      //(For arrays → "Longest Subarray With At Most K Distinct Integers")
      //This is a variable-size sliding window with a frequency map.

      public int longestSubarrayWithAtMostKDistinct(int[] productCategories, int k){
        validateDailyOrders(productCategories);
        if(k < 1 || k > productCategories.length){
            throw new IllegalArgumentException("k must have a value between 1 and " + productCategories.length);
        }
        Map<Integer,Integer> freq =  new HashMap<>();
        int windowStart = 0,  maxLengthSoFar = 0;
        for(int windowEnd = 0; windowEnd < productCategories.length; windowEnd++){
            int category = productCategories[windowEnd];
            freq.put(category,freq.getOrDefault(category,0)+1);

            // Step 6: If distinct categories exceed k, shrink window from the left side
            while(freq.size() > k){
                // Reduce count of the category at windowStart (since we are removing it from window)
                freq.put(productCategories[windowStart],freq.get(productCategories[windowStart]) - 1);
                // If count becomes 0, remove that category completely from map (no longer in window)
                if(freq.get(productCategories[windowStart]) == 0){
                     freq.remove(productCategories[windowStart]);
                 }

                // Move windowStart forward (shrink window from left)
                windowStart++;
            }
            maxLengthSoFar = Math.max(maxLengthSoFar, windowEnd - windowStart + 1);
        }
        return maxLengthSoFar;
      }

//   🚀 NOW LEVEL UP: Medium-Level Sliding Window (Classic LeetCode)
//🧠 Sliding Window Problem #4 (Medium)
//   Longest Subarray After Deleting One Element (Max Consecutive Ones III Variant)
     public int longestStreakWithOneDeletion(int[] arr){
        validateDailyOrders(arr);
        int windowStart = 0, maxStreak = 0, zeroCount = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            //count zeros
            if(arr[windowEnd] == 0){
                 zeroCount++;
            }
            // if zero count is greater than 1, enter the while loop
            while(zeroCount > 1){
                // check if any element(with windowStart index) equal to zero,if yes then decrement zeroCount
                if(arr[windowStart] == 0){
                    zeroCount--;
                }
                // shrink from left
                windowStart++;
            }
            //update maxStreak
            maxStreak = Math.max(maxStreak, windowEnd - windowStart + 1);
        }
        return maxStreak - 1;
     }

//    PROBLEM (Frequency / HashMap):
//    Return the first non-repeating element in an array
     public int firstNonRepeating(int[] dailyOrders){
        validateDailyOrders(dailyOrders);
        Map<Integer,Integer> freqMap =  new HashMap<>();
        for(int x : dailyOrders){
            freqMap.put(x,freqMap.getOrDefault(x,0)+1);
        }
        for(int x : dailyOrders){
            if(freqMap.get(x) == 1){
                return x;
            }
        }

        return -1;
     }

//    Next Challenge (Medium): First Unique Element in a Stream
//    ✔ HashMap to count frequencies
//    ✔ Queue to track order of arrival
     public int firstUniqueInStream(int[] stream){
        validateDailyOrders(stream);
        Map<Integer, Integer> freqMap = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(int x : stream){
            freqMap.put(x,freqMap.getOrDefault(x,0)+1);
            q.offer(x);

            while(!q.isEmpty() && freqMap.get(q.peek()) > 1){
                q.poll();
            }

        }
         return q.isEmpty() ? -1 : q.peek();

     }


}
