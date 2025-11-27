package dev.pawan.basics;

public class Main {
    public static void main(String[] args) {
        int[] dailyOrders = {10, 12, 8, 15,  20,  18, 9};
        OrderAnalytics analytics = new OrderAnalytics();
        long totalOrders = analytics.calculateTotal(dailyOrders);
        double averageOrders = analytics.calculateAverage(dailyOrders);
        int maximumOrders = analytics.findMaximum(dailyOrders);
        int indexOfMaximum = analytics.indexOfMaximum(dailyOrders);
        int minimumOrders = analytics.findMinimum(dailyOrders);
        int indexOfMinimumOrder = analytics.indexOfMinimum(dailyOrders);
        int[] cumulativeOrders = analytics.cumulativeOrders(dailyOrders);
        int[] runningMaxOrders = analytics.runningMaximum(dailyOrders);

        System.out.println("\nOrder Analytics started!!\n");
        System.out.println("Total numbers of orders: "+totalOrders);
        System.out.println("Average number of orders per day: "+averageOrders);
        System.out.printf("Maximum number of order in a single day: %d and Index of maximum order: %d ",maximumOrders,indexOfMaximum);
        System.out.printf("\nMinimum number of order in a single day: %d and Index of minimum order: %d",minimumOrders,indexOfMinimumOrder);
        System.out.println("\ncumulative orders: ");
        for(int x : cumulativeOrders){
            System.out.print(x+" ");
        }
        System.out.println("\nrunning maximum: ");
        for(int x : runningMaxOrders){
            System.out.print(x+" ");
        }
        System.out.println("\nOrder Analytics finished!!\n");
    }
}
