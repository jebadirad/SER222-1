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
        Integer[] insertionBinary1 = TestDataBinary(8192);
        Integer[] insertionBinary2 = TestDataBinary(16384);

        Integer[] insertionRemainders1 = TestDataRemainders(8192);
        Integer[] insertionRemainder2 = TestDataRemainders(16384);

        Integer[] insertionRandom1 = TestDataRandoms(8192);
        Integer[] insertionRandom2 = TestDataRandoms(16384);

        Integer[] selectionBinary1 = TestDataBinary(8192);
        Integer[] selectionBinary2 = TestDataBinary(16384);

        Integer[] selectionRemainders1 = TestDataRemainders(8192);
        Integer[] selectionRemainder2 = TestDataRemainders(16384);

        Integer[] selectionRandom1 = TestDataRandoms(8192);
        Integer[] selectionRandom2 = TestDataRandoms(16384);

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


        insertBinary2Time = insertBinary2Time -  insertBinary1Time;
        insertRemainder1Time = insertRemainder1Time - insertBinary2Time;
        insertRemainder2Time = insertRemainder2Time - insertRemainder1Time;
        insertRandom1Time = insertRandom1Time - insertRemainder2Time;
        insertRandom2Time = insertRandom2Time - insertRandom1Time;
        selectBinary1Time = selectBinary1Time - insertRandom2Time;
        selectBinary2Time = selectBinary2Time - selectBinary1Time;
        selectRemainder1Time = selectRemainder1Time - selectBinary2Time;
        selectRemainder2Time = selectRemainder2Time - selectRemainder1Time;
        selectRandom1Time = selectRandom1Time - selectRemainder2Time;
        selectRandom2Time = selectRandom2Time - selectRandom1Time;
        
        System.out.println("Insertion Sort:");
        System.out.println("Binary Test Data(8192): " + insertBinary1Time);
        System.out.println("Binary Test Data(16384): " + insertBinary2Time);

        System.out.println("Remainders Test Data(8192): " + insertRemainder1Time);
        System.out.println("Remainders Test Data(16384): " + insertRemainder2Time);

        System.out.println("Random Test Data(8192): " + insertRandom1Time);
        System.out.println("Random Test Data(16384): " + insertRandom2Time);

        System.out.println("Selection Sort:");
        System.out.println("Binary Test Data(8192): " + selectBinary1Time);
        System.out.println("Binary Test Data(16384): " + selectBinary2Time);

        System.out.println("Remainders Test Data(8192): " + selectRemainder1Time);
        System.out.println("Remainders Test Data(16384): " + selectRemainder2Time);

        System.out.println("Random Test Data(8192): " + selectRandom1Time);
        System.out.println("Random Test Data(16384): " + selectRandom2Time);

        // log t(2n) / t(n);
        System.out.println("Power for Doubling:");
        System.out.println("Insertion Sort Binary :" + Math.log(insertBinary2Time/insertBinary1Time));
        System.out.println("Insertion Sort Remainders :" + Math.log(insertRemainder2Time/insertRemainder1Time));
        System.out.println("Insertion Sort Randoms :" + Math.log(insertRandom2Time/insertRandom1Time));
        System.out.println("Selection Sort Binary :" + Math.log(selectBinary2Time/selectBinary1Time));
        System.out.println("Selection Sort Remainders :" + Math.log(selectRemainder2Time/selectRemainder1Time));
        System.out.println("Selection Sort Random :" + Math.log((selectRandom2Time/selectRandom1Time)));

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
