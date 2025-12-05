package dev.pawan.basics;

public class Main {
    public static void main(String[] args) {
        int[] dailyOrders = {10, 12, 8, 15, 8,  20,  18, 9};
        OrderAnalytics analytics = new OrderAnalytics();
        int[] orders = {10,20,10,10,5,5,10,10,40};

        long totalOrders = analytics.calculateTotal(dailyOrders);
        double averageOrders = analytics.calculateAverage(dailyOrders);
        int maximumOrders = analytics.findMaximum(dailyOrders);
        int indexOfMaximum = analytics.indexOfMaximum(dailyOrders);
        int minimumOrders = analytics.findMinimum(dailyOrders);
        int indexOfMinimumOrder = analytics.indexOfMinimum(dailyOrders);
        int[] cumulativeOrders = analytics.cumulativeOrders(dailyOrders);
        int[] runningMaxOrders = analytics.runningMaximum(dailyOrders);
        int maxSumSubarrayOfSizeK = analytics.maxSumSubarrayOfSizeK(dailyOrders,3);
        double maxAverageSubarrayOfSizeK = analytics.maxAverageSubarrayOfSizeK(dailyOrders,3);

        System.out.println("\nOrder Analytics started!!\n");

        System.out.println("Total numbers of orders: "+totalOrders);
        System.out.println("Average number of orders per day: "+averageOrders);
        System.out.printf("Maximum number of order in a single day: %d and Index of maximum order: %d ",maximumOrders,indexOfMaximum);
        System.out.printf("\nMinimum number of order in a single day: %d and Index of minimum order: %d",minimumOrders,indexOfMinimumOrder);
        System.out.println();

        System.out.println("\ncumulative orders: ");
        for(int x : cumulativeOrders){
            System.out.print(x+" ");
        }
        System.out.println();

        System.out.println("\nrunning maximum: ");
        for(int x : runningMaxOrders){
            System.out.print(x+" ");
        }
        System.out.println();

        System.out.println("\nMax sum Subarray of size K: "+maxSumSubarrayOfSizeK);
        System.out.println("Max average Subarray of Size K: "+maxAverageSubarrayOfSizeK);
        System.out.println();

        int[] arr1 = {2,1,3,2,4,1,1};
        System.out.println("longest Subarray With Sum At Most S: "+analytics.longestSubarrayWithSumAtMostS(arr1,6));
        System.out.println();

        int[] arr2 = {4, 4, 5, 5, 1, 2, 1};
        System.out.println("longest Subarray With At Most K Distinct: "+analytics.longestSubarrayWithAtMostKDistinct(arr2,3));
        System.out.println();

        int[] arr3 = {1,1,1,1};
        System.out.println("longest Streak With One Deletion: "+analytics.longestStreakWithOneDeletion(arr3));
        System.out.println();
        System.out.println("first Non Repeating Item: "+analytics.firstNonRepeating(arr2));
        System.out.println();
        System.out.println("first Unique In Stream: "+analytics.firstUniqueInStream(arr2));
        System.out.println();
        System.out.println("count Subarrays With Sum = K: "+analytics.countSubarraysWithSumK(orders,60));
        System.out.println();
        System.out.println("\nOrder Analytics finished!!\n");
    }
}

