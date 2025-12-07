package dev.pawan.miniprojects.orders;

import java.util.*;
public class OrderAnalyticsService {
    //Validate Orders
    private void validateOrders(int[] orders) {
        if(orders == null || orders.length == 0) {
            throw new IllegalArgumentException("Orders cannot be null or empty");
        }
    }

    //Calculate Totals
    public long calculateTotal(int[] orders) {
        validateOrders(orders);
        long total = 0;
        for (int order : orders) {
            total += order;
        }
        return total;
    }

    //Calculate Average
    public double calculateAverage(int[] orders) {
        validateOrders(orders);
        long sum = calculateTotal(orders);
        return (double) sum / orders.length;
    }

    //Find Maximum Order
    public int findMaximum(int[] orders) {
        validateOrders(orders);
        int maxOrder = orders[0];
        for (int i = 1; i < orders.length; i++) {
            if(orders[i] > maxOrder) {
                maxOrder = orders[i];
            }
        }
        return maxOrder;
    }

    //Index of Maximum Order
    public int indexOfMaximum(int[] orders) {
        validateOrders(orders);
        int maxOrder = orders[0];
        int maxIndex = 0;
        for (int i = 1; i < orders.length; i++) {
            if(orders[i] > maxOrder) {
                maxOrder = orders[i];
                maxIndex = i;
            }

        }
        return maxIndex;
    }

    //Cumulative Orders (runningTotal)
    public int[] cumulativeOrders(int[] orders) {
        validateOrders(orders);
        int[]  cumulative = new int[orders.length];
        int runningTotal = 0;
        for (int i = 0; i < orders.length; i++) {
            runningTotal += orders[i];
            cumulative[i] = runningTotal;
        }
        return cumulative;
    }

    //Running Maximum
    public int[] runningMaximum(int[] orders) {
        validateOrders(orders);
        int[] runningMaximum = new int[orders.length];
        int maxSoFar = orders[0];
        runningMaximum[0] = maxSoFar;
        for (int i = 1; i < orders.length; i++) {
            if(orders[i] > maxSoFar) {
                maxSoFar = orders[i];
            }
            runningMaximum[i] = maxSoFar;
        }
        return runningMaximum;
    }

    //Max Sum Subarray of size k(fix-size sliding window)
    public int maxSumSubarrayOfSizeK(int[] orders,int k) {
        validateOrders(orders);
        if(k < 1 || k > orders.length) {
            throw new IllegalArgumentException("k must be between 1 and "+orders.length);
        }
        int windowSum = 0;

        //calculating  sum of first window of size k
        for (int i = 0; i < k; i++) {
            windowSum += orders[i];
        }

        //initialize maxSumSofar
        int maxSumSoFar = windowSum;

        //sliding window
        for (int i = k; i < orders.length; i++) {
            //Add  [i]index element(i index start from k) in sum and minus [i - k] index element to move forward(or slide)
            windowSum += orders[i] - orders[i - k];
            //update maxSumSoFar
            maxSumSoFar = Math.max(maxSumSoFar, windowSum);
        }
        return maxSumSoFar;

    }

    //Max Average Subarray Of Size K(fix-size sliding window)
    public double maxAverageSubarrayOfSizeK(int[] orders,int k) {
        validateOrders(orders);
        if(k < 1 || k > orders.length) {
            throw new IllegalArgumentException("k must be between 1 and "+orders.length);
        }
        int windowSum = 0;
        //calculating  average of first window of size k
        for (int i = 0; i < k; i++) {
            windowSum += orders[i];
        }
        //initialize maxAvgSoFar
        double maxAvgSoFar = (double) windowSum / k;

        //sliding window
        for(int i = k; i < orders.length; i++) {
            windowSum += orders[i] - orders[i - k];
            maxAvgSoFar = Math.max(maxAvgSoFar, (double) windowSum / k);
        }
        return maxAvgSoFar;
    }

    //Longest Subarray With Sum At Most S(assuming orders are positive)
    public int longestSubarrayWithSumAtMostS(int[] orders,int S) {
        validateOrders(orders);
        long windowSum = 0;
        int windowStart = 0;
        int maxLenSoFar = 0;
        for (int windowEnd = 0; windowEnd < orders.length; windowEnd++) {
            //Extend window
            windowSum += orders[windowEnd];

            //Shrink window to slide
            while(windowSum > S) {
                windowSum -= orders[windowStart];
                windowStart ++;
            }
            //update maxlenSoFar
            maxLenSoFar = Math.max(maxLenSoFar, windowEnd - windowStart + 1);
        }

        return maxLenSoFar;

    }

    //Longest Subarray With One Deletion(arr of integer(binary 0s and 1s))
    public int longestSubarrayWithOneDeletion(int[] arr) {
        validateOrders(arr);
        int windowStart = 0;
        int maxLenSoFar = 0;
        int zeroCount = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            //Extend window
            if(arr[windowEnd] == 0) {
                zeroCount++;
            }
            //Shrink window
            while(zeroCount > 1) {
                if(arr[windowStart] == 0){
                    zeroCount--;
                }
                windowStart++;
            }
            maxLenSoFar = Math.max(maxLenSoFar, windowEnd - windowStart + 1);
        }
        //One Deletion
        return maxLenSoFar - 1;
    }

    //Longest Subarray With At Most K Distinct
    public int longestSubarrayWithAtMostKDistinct(int[] arr, int k) {
        validateOrders(arr);
        if(k < 1 || k > arr.length) {
            throw new IllegalArgumentException("k must be between 1 and "+arr.length);
        }
        Map<Integer,Integer> freqMap = new HashMap<>();
        int windowStart = 0;
        int maxLenSoFar = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            //Extend window
            freqMap.put(arr[windowEnd],freqMap.getOrDefault(arr[windowEnd],0)+1);

            //Shrink window
            int key = arr[windowEnd];
            int newCount = freqMap.get(key) - 1;
            while(freqMap.size() > k) {
                if(freqMap.get(key) == 0) {
                    freqMap.remove(arr[windowStart]);
                }
                freqMap.put(key,newCount);
                windowStart++;
            }

            //update maxLenSoFar
            maxLenSoFar = Math.max(maxLenSoFar, windowEnd - windowStart + 1);
        }
        return maxLenSoFar;
    }

    //Count Subarrays With Sum K
    public int countSubarraysWithSumK(int[] nums, int k) {
        validateOrders(nums);
        Map<Integer,Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0,1);
        int prefixSum = 0;
        int countSoFar = 0;
        for (int num : nums) {
            prefixSum += num;
            int remainder = prefixSum - k;

            if (prefixSumMap.containsKey(remainder)) {
                countSoFar += prefixSumMap.get(remainder);
            }

            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);

        }
        return countSoFar;
    }

}
