import static org.junit.jupiter.api.Assertions.*;
class EbadiradNonUniformTest {
    int i1 = 2048; //4096;
    @org.junit.jupiter.api.Test
    void testDataBinary() {
        int[] testdata = EbadiradNonUniform.TestDataBinary(i1);
        assertTrue(testdata.length == i1);
        int zeroCount = 0;
        int oneCount = 0;
        for(int i = 0; i < testdata.length; i ++){
            if(testdata[i] == 1) {
                oneCount++;
            } else if (testdata[i] == 0) {
                zeroCount++;
            }else{
                assertFalse(true);
            }
        }
        if(zeroCount + oneCount == i1){
            
            if(i1 % 2 == 0) {
                assertTrue(zeroCount == oneCount);
            }else{
                assertTrue(zeroCount - 1 == oneCount || oneCount - 1 == zeroCount);
            }
        }else{
            assertFalse(true);
        }
    }

    @org.junit.jupiter.api.Test
    void testDataRemainders() {
        int[] testData = EbadiradNonUniform.TestDataRemainders(i1);
        int nTemp = i1;
        int arraySize = 0;
        while(nTemp > 0){
            if(nTemp / 2 == 0){
                arraySize ++;
                break;
            }else{
                arraySize++;
                nTemp = nTemp/ 2;
            }
        }
        int[] counts = new int[arraySize];
        for(int i = 0; i < counts.length; i++){
            counts[i] = 0;
        }
        for(int i = 0; i < testData.length; i ++){
            counts[testData[i]] = counts[testData[i]] + 1;
        }
        int finalCounts = 0;
        for(int i = 0; i < counts.length; i ++){
            finalCounts += counts[i];
        }
        assertTrue(finalCounts == testData.length);
        assertTrue(testData.length / 2 == counts[0]);

        for(int i = 1; i < counts.length; i ++){
            assertTrue(counts[0] > counts[i]);
            if(i == counts.length - 1){
                assertTrue(counts[i] == 1);
            }else{
                assertTrue(counts[i] == counts[i-1] /2);
            }
        }

    }

    @org.junit.jupiter.api.Test
    void testDataRandoms() {
        int[] testData = EbadiradNonUniform.TestDataRandoms(i1);
        int countZero = 0;
        int countInt = 0;
        for(int i = 0; i < testData.length; i ++){
            if(testData[i] == 0){
                countZero++;
            }else{
                countInt ++;
            }
        }
        assertTrue(countZero == countInt);
        assertTrue(countZero + countInt == i1);
    }
}