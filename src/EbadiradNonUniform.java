import java.util.Random;

public class EbadiradNonUniform {

    public static void main(String[] args) {

    }


    public static int[] TestDataBinary(int n){
        int[] testData = new int[n];
        for(int i = 0; i < n; i++){
            testData[i] = i % 2;
        }
        return testData;
    }
    public static int[] TestDataRemainders(int n){


        int[] testData = new int[n];
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

        return testData;
    }

    public static int[] TestDataRandoms(int n){
        int[] testData = new int[n];
        Random ran = new Random();
        for(int i = 0; i < n; i ++){
            if(i % 2 == 0){
                testData[i] = 0;
            }else{
                testData[i]= ran.nextInt();
            }
        }
        return testData;
    }
    public static int[] Shuffle(int[] testData){

        return new int[1];
    }
}
