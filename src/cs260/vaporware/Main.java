package cs260.vaporware;

public class Main {

    public static void main(String[] args) {
        ArrayClass testOne = new ArrayClass(20);//create a test array with 5 elements
        fillArray(testOne);//fill it up
        System.out.print("\nShowing filled array:\n"+testOne.curElems());
        System.out.print("\nShow the largest number found in the array: "+testOne.getLargest());
        System.out.print("\nShow that the largest has been removed:\n"+testOne.curElems());
        ArrayClass testDupes = new ArrayClass(20);
        for (int i = 0;i<20;i++) {
            if (i<7) testDupes.addElem(10);//add some guaranteed duplicates to be removed
            else testDupes.addElem(i);//and some other numbers as well
        }
        System.out.print("\n\nShow an array with duplicates:\n"+testDupes.curElems());
        testDupes.deleteDups();
        System.out.print("\n\nShow that the duplicates have been deleted:\n"+testDupes.curElems());
        ArrayClass unsorted = new ArrayClass();
        fillArray(unsorted);
        System.out.print("\n\nShow unsorted array:\n" + unsorted.curElems());
        sortMe(unsorted);
        System.out.print("\n\nShow the now sorted array:\n" + unsorted.curElems());
        ArrayClass smallSort = new ArrayClass(10);
        fillArray(smallSort);
        System.out.print("\n\nDemonstrate again with a smaller array(for readability):\n" + smallSort.curElems());
        sortMe(smallSort);
        System.out.print("\n\nAnd Sorted:\n"+smallSort.curElems());
        ArrayClass fullMonty = new ArrayClass(500);
        fillArray(fullMonty);//now this is just showing off.
        System.out.print("\n\n"+fullMonty.curElems()+"\n\n");
        fullMonty.deleteDups();
        sortMe(fullMonty);
        System.out.print(fullMonty.curElems());


          }


    //here there be dragons (or just helper functions)

    public static void fillArray(ArrayClass array) {//fill an arbitrarily large array with random integers
        for (int i=0;i<array.getArraySize();i++) {
           //generate random int from 0-100
            array.addElem((int)(Math.random()*100));
       }
    }
    public static void sortMe(ArrayClass array) {//I don't know if this was supposed to be in the ArrayClass
        int arraySize = array.howMany();         //or just be an example of a sort using getLargest
        int[] temp = new int[arraySize];         //but there you have it.
      for (int i = arraySize-1; i>=0; i--) {
          temp[i] = array.getLargest();
      }
        for (int j=0;j<arraySize;j++) {
            array.addElem(temp[j]);
        }
    }



}
class ArrayClass {

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
                    unsortDelete(j);
                    j--;//so as not to skip a potential duplicate

                }
            }
        }
    }
    private void unsortDelete(int position) {//"if you have to write it twice, it should be it's own function"
        array[position] = array[lastItem-1];
        delElem();
    }
}