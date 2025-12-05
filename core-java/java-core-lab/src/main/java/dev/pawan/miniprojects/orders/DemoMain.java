package dev.pawan.miniprojects.orders;

import java.util.Arrays;

public class DemoMain {
    public static void main(String[] args) {
        OrderAnalyticsService stats = new OrderAnalyticsService();
        int[] orders = {10,20,10,10,5,5,10,10,40};
        int[] arr = {1,1,0,1,1,0,1};
        System.out.println("{10,20,30,15,25,70,50,80}");
        System.out.println(stats.calculateTotal(orders));
        System.out.println(stats.calculateAverage(orders));
        System.out.println(stats.findMaximum(orders));
        System.out.println(stats.indexOfMaximum(orders));
        System.out.println(Arrays.toString(stats.cumulativeOrders(orders)));
        System.out.println(Arrays.toString(stats.runningMaximum(orders)));
        System.out.println(stats.maxSumSubarrayOfSizeK(orders,3));
        System.out.println(stats.maxAverageSubarrayOfSizeK(orders,3));
        System.out.println("T-1: "+stats.longestSubarrayWithSumAtMostS(orders, 60));
        System.out.println("T-2: "+stats.longestSubarrayWithAtMostKDistinct(arr, 3));
        System.out.println(stats.longestSubarrayWithOneDeletion(arr));
        System.out.println("T-3: "+stats.countSubarraysWithSumK(orders, 60) );
    }

}
