package cs260.vaporware;

public class ArrayClass {

    private final int DEFAULT_NUM = 100;
    private int[] array; // I don't know if I need to declare this here, but it doesn't seem to hurt
    private int arraySize = 0;
    private int lastItem = 0;
    private int lineCount=0;

    public ArrayClass() {
        arraySize = DEFAULT_NUM;
        array = new int[arraySize];
    }
    public ArrayClass(int n) {
        array = new int[n];
        arraySize = n;
    }
    public boolean addElem(int n) {
        if (lastItem < arraySize) {
            array[lastItem] = n;
            lastItem++;
            return true;
        }
        else return false;

    }
    public boolean delElem() {
        if (lastItem>0) {//this assumes a valid range for lastItem.
            lastItem--;
            return true;
        }
        else return false;
    }
    public int howMany() {
        return lastItem;
    }
    public String curElems() {
        String accumInt="";
        for (int i=0; i<lastItem; i++) {
            lineCount++;
            accumInt += array[i]+" ";
            if (lineCount==10) {
                accumInt += "\n";
                lineCount=0;
            }
        }
        return accumInt;
    }
    public int getArraySize() {
        return arraySize;
    }

    public int getLargest() {

        int swapID=0;
        for (int i=0;i<lastItem;i++) {
            if (array[i]>array[swapID]) swapID=i;
        }
        int storeVal=array[swapID];//hold the largest number
        unsortDelete(swapID);
        return storeVal; //give the number found to be the largest
    }
    public void deleteDups() {//this should work.. maybe.

        for (int i=0;i<lastItem;i++) {
            for (int j=i+1;j<lastItem;j++) {
                if (array[i]==array[j]) {
                    unsortDelete(j--);


                }
            }
        }
    }
    private void unsortDelete(int position) {//"if you have to write it twice, it should be it's own function"
        array[position] = array[lastItem-1];
        delElem();
    }
}