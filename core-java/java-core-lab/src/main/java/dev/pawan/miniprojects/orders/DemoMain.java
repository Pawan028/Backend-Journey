package dev.pawan.miniprojects.orders;

import java.util.Arrays;

public class DemoMain {
    public static void main(String[] args) {
        OrderAnalyticsService services = new OrderAnalyticsService();
        int[] orders = {10, 12, 8, 15, 8,  20,  18, 9};
        int[] arr1 = {2,1,3,2,4,1,1};
        int[] arr2 = {10,20,10,10,5,5,10,10,40};
        int[] arr3 = {1,1,0,1,1,0,1};

        long totalOrders = services.calculateTotal(orders);
        double averageOrders = services.calculateAverage(orders);
        int maximumOrders = services.findMaximum(orders);
        int indexOfMaximum = services.indexOfMaximum(orders);
        int[] cumulativeOrders = services.cumulativeOrders(orders);
        int[] runningMaxOrders = services.runningMaximum(orders);
        int maxSumSubarrayOfSizeK = services.maxSumSubarrayOfSizeK(orders,3);
        double maxAverageSubarrayOfSizeK = services.maxAverageSubarrayOfSizeK(orders,3);
        int longestSubarrayWithSumAtMostS  = services.longestSubarrayWithSumAtMostS(arr1,6);
        int longestSubarrayWithAtMostKDistinct  = services.longestSubarrayWithAtMostKDistinct(arr2,2);
        int longestSubarrayWithOneDeletion = services.longestSubarrayWithOneDeletion(arr3);
        int countSubarraysWithSumK = services.countSubarraysWithSumK(orders,60);

        System.out.println("\nOrder Analytics started!!\n");

        System.out.println("Total numbers of orders: "+totalOrders);
        System.out.println();

        System.out.println("Average number of orders per day: "+averageOrders);
        System.out.println();

        System.out.printf("Maximum number of order in a single day: %d and Index of maximum order: %d ",maximumOrders,indexOfMaximum);
        System.out.println();

        System.out.println("Cumulative orders: "+Arrays.toString(cumulativeOrders));
        System.out.println();

        System.out.println("Running maximum: "+Arrays.toString(runningMaxOrders));
        System.out.println();

        System.out.println("Max sum Subarray of size K: "+maxSumSubarrayOfSizeK);
        System.out.println();

        System.out.println("Max average Subarray of Size K: "+maxAverageSubarrayOfSizeK);
        System.out.println();

        System.out.println("Longest Subarray With Sum At Most S: "+longestSubarrayWithSumAtMostS);
        System.out.println();

        System.out.println("Longest Subarray With At Most K Distinct: "+longestSubarrayWithAtMostKDistinct);
        System.out.println();

        System.out.println("Longest Streak With One Deletion: "+longestSubarrayWithOneDeletion);
        System.out.println();

        System.out.println("Count Subarrays With Sum = K: "+countSubarraysWithSumK);
        System.out.println();

        System.out.println("Order Analytics finished!!");
    }

}
