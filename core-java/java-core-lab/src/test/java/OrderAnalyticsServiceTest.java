import java.util.*;

import dev.pawan.miniprojects.orders.OrderAnalyticsService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderAnalyticsServiceTest {

    OrderAnalyticsService service = new OrderAnalyticsService();

    @Test
    void testCalculateTotal() {
        int[] orders = {40,20,30,10};
        long expected = 100;
        long actual = service.calculateTotal(orders);
        assertEquals(expected, actual, "Total orders test failed");
    }

    @Test
    void testCalculateAverage() {
        int[] orders = {40,20,30,10};
        double expected = 25;
        double actual = service.calculateAverage(orders);
        assertEquals(expected, actual, "Average orders test failed");
    }

    @Test
    void testCumulativeOrders() {
        int[] orders = {40,20,30,10,30};
        int[] expected = {40,60,90,100,130};
        int[] actual = service.cumulativeOrders(orders);
        assertArrayEquals(expected,actual, "Cumulative orders test failed");
    }

    @Test
    void testMaxSumSubarrayOfSizeK() {
        int[] orders = {10,20,15,30,10,40};
        int k = 3;
        int expected = 80;
        int actual = service.maxSumSubarrayOfSizeK(orders,k);
        assertEquals(expected, actual, "Max sum subarray of size k test failed");
    }

    @Test
    void testLongestSubarrayWithAtMostKDistinct(){
        int[] orders = {10,20,10,10,5,5,10,10,40};
        int k = 2;
        int expected = 6;
        int actual = service.longestSubarrayWithAtMostKDistinct(orders,k);
        assertEquals(expected, actual, "Longest subarray with at most k distinct test failed");
    }

    @Test
    void testCountSubarraysWithSumK(){
        int[] orders = {10,20,15,30,5,40};
        int k = 45;
        int expected = 3;
        int actual = service.countSubarraysWithSumK(orders,k);
        assertEquals(expected, actual, "Count subarrays with sum k test failed");
    }


}
