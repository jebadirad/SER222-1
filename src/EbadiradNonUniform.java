/*
*
* This program will generate 12 sets of data based on the requirements for the first homework.
* Each of the three static methods will generate an integer array that meets the requirements,
* with the difference of length. Each of the integer arrays produced will be shuffled after creation
* All of the test data will be shuffled using the same method.
* The main method will generate all the test data using two different data set sizes.
* Then we will create a stopwatch, run a sort on each data set size and same the elapsed time after each sort completes
* Then we need to calculate the actual elapsed time by subtracting the latest recorded time from the
* time recorded right before it. So when sort1 and sort2 completes, we subtract the sort2 time from the sort1
* time and get the actual elapsed time of sort2.
* Then we calculate the power for the doubling formula by taking the time for the larger set and
* dividing it by the time for the smaller set, and taking the log of that ratio.
*
* Completion Time: 5 hours.
*
* @author JonDavid Ebadirad,Sedgewick and Wayne, Acuna
* @version 1.0
*/

/*
    Hypotheses
    Insertion Sort :
    Binary: I believe this one is O(n log n). We know it is more than O(n) because
        we iterate through the main array one full time, so it is dependant on the
        size of the input. But since the numbers are just 0s and 1s, we can guess that
        the second loop will not run as large as the first loop. This means it won't be
        O(n2).
    Remainders: This set will be much closer to O(n2). We know for a fact that we are
        going to have numbers that are much higher than the rest of the numbers. Since
        the numbers are randomly placed and half of the numbers are 0s, we can assume that
        a zero will be near the end of the array, causing it to iterate back through the
        entire array until it hits another 0.
    Random: This set will be similar to the remainders one, but I believe this one will greatly
        depend on the input. We know half the data are 0s, but we don't know what random
         values will be put in. So worst case we may have a negative number near the end
         of the array that is more negative than all the rest.  I would say this one is
         O(n2).
    Selection Sort :
    Binary: I believe this will be O(n2). It has to at least iterate through the array once,
        but then the inner loop iterates through the rest of the array each time looking for the
        lowest value before doing the exchange. In this dataset the selection sort will most likley
        already have found a lowest value.
    Remainders: I believe this will be O(n2). The outer loop of the selection sort will iterate
        through the array once, while the inner loop will iterate through the array n-1 times.
    Random: I believe this one will also be O(n2). The outer loop of the selection sort will
        iterate through the array once, while the inner loop will iterate through the array
        n-1 times. The only difference between this one and the other two test data sets, is that
        this test data set may actually do some work since we have a chance at negative numbers.
        Opposed to the other two test data sets where there is a high chance that we will find
        the lowest number early and waste time looking through the rest of the array.


 */
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class EbadiradNonUniform {

    public static void main(String[] args) {
        //declare time variables;
        double insertBinary1Time;
        double insertBinary2Time;
        double insertRemainder1Time;
        double insertRemainder2Time;
        double insertRandom1Time;
        double insertRandom2Time;
        double selectBinary1Time;
        double selectBinary2Time;
        double selectRemainder2Time;
        double selectRemainder1Time;
        double selectRandom1Time;
        double selectRandom2Time;
        double insertBinary2TimeTrue;
        double insertRemainder1TimeTrue;
        double insertRemainder2TimeTrue;
        double insertRandom1TimeTrue;
        double insertRandom2TimeTrue;
        double selectBinary1TimeTrue;
        double selectBinary2TimeTrue;
        double selectRemainder2TimeTrue;
        double selectRemainder1TimeTrue;
        double selectRandom1TimeTrue;
        double selectRandom2TimeTrue;
        int largeSet = 16384;
        int smallSet = 8192;
        Integer[] insertionBinary1 = TestDataBinary(smallSet);
        Integer[] insertionBinary2 = TestDataBinary(largeSet);

        Integer[] insertionRemainders1 = TestDataRemainders(smallSet);
        Integer[] insertionRemainder2 = TestDataRemainders(largeSet);

        Integer[] insertionRandom1 = TestDataRandoms(smallSet);
        Integer[] insertionRandom2 = TestDataRandoms(largeSet);

        Integer[] selectionBinary1 = TestDataBinary(smallSet);
        Integer[] selectionBinary2 = TestDataBinary(largeSet);

        Integer[] selectionRemainders1 = TestDataRemainders(smallSet);
        Integer[] selectionRemainder2 = TestDataRemainders(largeSet);

        Integer[] selectionRandom1 = TestDataRandoms(smallSet);
        Integer[] selectionRandom2 = TestDataRandoms(largeSet);

        Stopwatch timer = new Stopwatch();

        //insertion sort Binary sets
        InsertionSort.sort(insertionBinary1);
        insertBinary1Time = timer.elapsedTime();

        InsertionSort.sort(insertionBinary2);
        insertBinary2Time = timer.elapsedTime();

        //Insertion sort Remainder Sets
        InsertionSort.sort(insertionRemainders1);
        insertRemainder1Time = timer.elapsedTime();

        InsertionSort.sort(insertionRemainder2);
        insertRemainder2Time = timer.elapsedTime();

        //insertion sort Random sets
        InsertionSort.sort(insertionRandom1);
        insertRandom1Time = timer.elapsedTime();

        InsertionSort.sort(insertionRandom2);
        insertRandom2Time = timer.elapsedTime();

        //Selection sort binary sets
        SelectionSort.sort(selectionBinary1);
        selectBinary1Time = timer.elapsedTime();

        SelectionSort.sort(selectionBinary2);
        selectBinary2Time = timer.elapsedTime();

        //Selection Sort Remainder Sets
        SelectionSort.sort(selectionRemainders1);
        selectRemainder1Time = timer.elapsedTime();

        SelectionSort.sort(selectionRemainder2);
        selectRemainder2Time = timer.elapsedTime();

        //Selection Sort Random Sets
        SelectionSort.sort(selectionRandom1);
        selectRandom1Time = timer.elapsedTime();

        SelectionSort.sort(selectionRandom2);
        selectRandom2Time = timer.elapsedTime();


        insertBinary2TimeTrue = insertBinary2Time -  insertBinary1Time;
        insertRemainder1TimeTrue = insertRemainder1Time - insertBinary2Time;
        insertRemainder2TimeTrue = insertRemainder2Time - insertRemainder1Time;
        insertRandom1TimeTrue = insertRandom1Time - insertRemainder2Time;
        insertRandom2TimeTrue = insertRandom2Time - insertRandom1Time;
        selectBinary1TimeTrue = selectBinary1Time - insertRandom2Time;
        selectBinary2TimeTrue = selectBinary2Time - selectBinary1Time;
        selectRemainder1TimeTrue = selectRemainder1Time - selectBinary2Time;
        selectRemainder2TimeTrue = selectRemainder2Time - selectRemainder1Time;
        selectRandom1TimeTrue = selectRandom1Time - selectRemainder2Time;
        selectRandom2TimeTrue = selectRandom2Time - selectRandom1Time;
        
        System.out.println("Insertion Sort:");
        System.out.println("Binary Test Data(" + smallSet + "): " + insertBinary1Time);
        System.out.println("Binary Test Data(" + largeSet + "): " + insertBinary2TimeTrue);

        System.out.println("Remainders Test Data(" + smallSet + "): " + insertRemainder1TimeTrue);
        System.out.println("Remainders Test Data(" + largeSet + "): " + insertRemainder2TimeTrue);

        System.out.println("Random Test Data(" + smallSet + "): " + insertRandom1TimeTrue);
        System.out.println("Random Test Data(" + largeSet + "): " + insertRandom2TimeTrue);

        System.out.println("Selection Sort:");
        System.out.println("Binary Test Data(" + smallSet + "): " + selectBinary1TimeTrue);
        System.out.println("Binary Test Data(" + largeSet + "): " + selectBinary2TimeTrue);

        System.out.println("Remainders Test Data(" + smallSet + "): " + selectRemainder1TimeTrue);
        System.out.println("Remainders Test Data(" + largeSet + "): " + selectRemainder2TimeTrue);

        System.out.println("Random Test Data(" + smallSet + "): " + selectRandom1TimeTrue);
        System.out.println("Random Test Data(" + largeSet + "): " + selectRandom2TimeTrue);

        // log t(2n) / t(n);
        System.out.println("Power for Doubling:");
        System.out.println("Insertion Sort Binary :" + (Math.log(insertBinary2TimeTrue/insertBinary1Time))/Math.log(2));
        System.out.println("Insertion Sort Remainders :" + (Math.log(insertRemainder2TimeTrue/insertRemainder1TimeTrue))/Math.log(2));
        System.out.println("Insertion Sort Randoms :" + (Math.log(insertRandom2TimeTrue/insertRandom1TimeTrue))/Math.log(2));
        System.out.println("Selection Sort Binary :" + (Math.log(selectBinary2TimeTrue/selectBinary1TimeTrue))/Math.log(2));
        System.out.println("Selection Sort Remainders :" + (Math.log(selectRemainder2TimeTrue/selectRemainder1TimeTrue))/Math.log(2));
        System.out.println("Selection Sort Random :" + (Math.log((selectRandom2TimeTrue/selectRandom1TimeTrue)))/Math.log(2));
    }

    public static Integer[] TestDataBinary(int n){
        Integer[] testData = new Integer[n];
        for(int i = 0; i < n; i++){
            testData[i] = i % 2;
        }
        testData = Shuffle(testData);
        return testData;
    }
    public static Integer[] TestDataRemainders(Integer n){


        Integer[] testData = new Integer[n];
        int valueToAdd = 0;
        int halfCount = n /2;
        int currentCount = 0;
        for(int i = 0; i < n; i ++){
            testData[i] = valueToAdd;
            currentCount++;
            if(currentCount == halfCount){
                valueToAdd++;
                halfCount = halfCount / 2;
                currentCount = 0;
            }
        }
        testData = Shuffle(testData);
        return testData;
    }

    public static Integer[] TestDataRandoms(Integer n){
        Integer[] testData = new Integer[n];
        Random ran = new Random();
        for(int i = 0; i < n; i ++){
            if(i % 2 == 0){
                testData[i] = 0;
            }else{
                testData[i]= ran.nextInt();
            }
        }
        testData = Shuffle(testData);
        return testData;
    }
    public static Integer[] RealRandoms(Integer n){
        Integer[] testData = new Integer[n];
        Random ran = new Random();
        for(int i = 0; i < n; i ++){
                testData[i]= ran.nextInt();
        }
        testData = Shuffle(testData);
        return testData;
    }

    public static Integer[] Shuffle(Integer[] testData){
        Random ran = new Random();
        for(int i = 0; i < testData.length; i++){
            int temp;
            int randomNumber = ThreadLocalRandom.current().nextInt(i, testData.length);
            temp = testData[randomNumber];
            testData[randomNumber] = testData[i];
            testData[i] = temp;
        }
        return testData;
    }
}
