import java.security.SecureRandom;
import java.util.Arrays;

public class BinarySearchTest {
    public static void main(String[] args) {

        SecureRandom rand = new SecureRandom();
        int totalNums = 100000000;
        int[] numberArray = new int[totalNums];
        int targetIndex;
        int targetNum;
        int returnedIndex;
        long startTime;
        long elapsedTime;

        for(int x = 0;x < numberArray.length; x++) {
            numberArray[x] = rand.nextInt(1000000000);

        }

        Arrays.sort(numberArray);

        // pick random index ot test with
        targetIndex = rand.nextInt(totalNums);
        //get target num with above index
        targetNum = numberArray[targetIndex];

        System.out.println("target num: " + targetNum);
        System.out.println("target index: " + targetIndex);

        BinarySearchTest test = new BinarySearchTest();

        // call Binary Search
        startTime = System.nanoTime();
        returnedIndex = test.findNumberBinarySearch(numberArray, targetNum, totalNums - 1, 0);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Binary Search time: " + elapsedTime);

        //System.out.println("BinarySearch answer: " + returnedIndex);

        startTime = System.nanoTime();
        returnedIndex = test.findNumberLinearSearch(numberArray, targetNum);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Linear Search time: " + elapsedTime);

    }

    /**
     * Search for index of given target number using recursion and binary search
     * @param numberArray
     * @param targetNum
     * @param high
     * @param low
     * @return
     */
    public int findNumberBinarySearch(int[] numberArray, int targetNum,int high,int low) {
        //check middle for target
        int middleIndex = (high + low ) / 2;
        if (numberArray[middleIndex] == targetNum) {
            return middleIndex;
        }

        //check if target is higher than number at middle index
        else if (targetNum > numberArray[middleIndex]) {
            return findNumberBinarySearch(numberArray, targetNum, high, middleIndex++);
        }
        // target is lower than number at middle index
        else {
            return findNumberBinarySearch(numberArray, targetNum, middleIndex--, low);
        }

    }

    public int findNumberLinearSearch(int[] numberArray, int targetNum) {
        for (int x = 0; x < numberArray.length; x++) {
            if (targetNum == numberArray[x]) {
                return x;
            }
        }
        return -1;
    }



}
