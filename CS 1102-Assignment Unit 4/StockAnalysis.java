import java.util.ArrayList;

public class StockAnalysis {

    // Method 1: Calculate average price (Array)
    public static float calculateAveragePrice(float[] prices) {
        float sum = 0;
        for (int i = 0; i < prices.length; i++) {
            sum += prices[i];
        }
        return sum / prices.length;
    }

    // Method 1 (Extra for full marks): Calculate average (ArrayList)
    public static float calculateAveragePriceList(ArrayList<Float> prices) {
        float sum = 0;
        for (float price : prices) {
            sum += price;
        }
        return sum / prices.size();
    }

    // Method 2: Find maximum price (Array)
    public static float findMaximumPrice(float[] prices) {
        float max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
            }
        }
        return max;
    }

    // Method 2 (Extra): Max for ArrayList
    public static float findMaximumPriceList(ArrayList<Float> prices) {
        float max = prices.get(0);
        for (float price : prices) {
            if (price > max) {
                max = price;
            }
        }
        return max;
    }

    // Method 3: Count occurrences
    public static int countOccurrences(float[] prices, float target) {
        int count = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] == target) {
                count++;
            }
        }
        return count;
    }

    // Method 4: Cumulative sum (ArrayList)
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
        ArrayList<Float> result = new ArrayList<>();
        float sum = 0;

        for (float price : prices) {
            sum += price;
            result.add(sum);
        }

        return result;
    }

    // Main Method
    public static void main(String[] args) {

        // Array of stock prices (10 days)
        float[] pricesArray = {100.5f, 101.0f, 102.3f, 100.5f, 99.8f, 101.5f, 102.3f, 103.0f, 100.5f, 104.2f};

        // ArrayList of stock prices
        ArrayList<Float> pricesList = new ArrayList<>();
        for (float price : pricesArray) {
            pricesList.add(price);
        }

        // Call methods
        float avgArray = calculateAveragePrice(pricesArray);
        float avgList = calculateAveragePriceList(pricesList);

        float maxArray = findMaximumPrice(pricesArray);
        float maxList = findMaximumPriceList(pricesList);

        int occurrences = countOccurrences(pricesArray, 100.5f);

        ArrayList<Float> cumulative = computeCumulativeSum(pricesList);

        // Output
        System.out.println("Average Price (Array): " + avgArray);
        System.out.println("Average Price (ArrayList): " + avgList);

        System.out.println("Maximum Price (Array): " + maxArray);
        System.out.println("Maximum Price (ArrayList): " + maxList);

        System.out.println("Occurrences of 100.5: " + occurrences);

        System.out.println("Cumulative Sum:");
        for (float value : cumulative) {
            System.out.print(value + " ");
        }
    }
}