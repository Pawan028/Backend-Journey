package dev.pawan.basics;

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
}
