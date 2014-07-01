package cs260.vaporware;

public class Main {

    public static void main(String[] args) {
        ArrayClass testOne = new ArrayClass(20);//create a test array with 5 elements
        fillArray(testOne);//fill it up
        System.out.print("\nShowing filled array:\n" + testOne.curElems());
        System.out.print("\nShow the largest number found in the array: " + testOne.getLargest());
        System.out.print("\nand the next: " + testOne.getLargest());
        System.out.print("\nShow that the largest two have been removed:\n" + testOne.curElems());
        ArrayClass testDupes = new ArrayClass(20);
        for (int i = 0; i < 20; i++) {
            if (i < 7) testDupes.addElem(10);//add some guaranteed duplicates to be removed
            else testDupes.addElem(i);//and some other numbers as well
        }
        System.out.print("\n\nShow an array with duplicates:\n" + testDupes.curElems());
        testDupes.deleteDups();
        System.out.print("\n\nShow that the duplicates have been deleted:\n" + testDupes.curElems());
        ArrayClass unsorted = new ArrayClass();
        fillArray(unsorted);
        System.out.print("\n\nShow unsorted array:\n" + unsorted.curElems());

        ArrayClass smallSort = new ArrayClass(10);
        fillArray(smallSort);
        System.out.print("\n\nDemonstrate again with a smaller array(for readability):\n" + smallSort.curElems());
        sortMe(smallSort);
        System.out.print("\n\nAnd Sorted:\n" + smallSort.curElems());
        ArrayClass emptyArray = new ArrayClass(10);
        System.out.print("\nTesting an empty array" + emptyArray.curElems());
        fillArray(emptyArray);
        System.out.print(emptyArray.curElems()+"\n");
        System.out.print(emptyArray.getLargest());
        System.out.print("\n"+emptyArray.curElems());
        sortMe(emptyArray);
        System.out.print("\nAnd showing proper handing of sorting arrays after removing an item\n"+ emptyArray.curElems());
    }
    //here there be dragons (or just helper functions)

    private static void fillArray(ArrayClass array) {//fill an arbitrarily large array with random integers
        for (int i=0;i<array.getArraySize();i++) {
           //generate random int from 0-100
            array.addElem((int)(Math.random()*100));
       }
    }
    private static void sortMe(ArrayClass array) {//I don't know if this was supposed to be in the ArrayClass
        int arraySize = array.getArraySize();         //or just be an example of a sort using getLargest
        int[] temp = new int[arraySize];         //but there you have it.
      for (int i = array.howMany()-1; i>=0; i--) {
          temp[i] = array.getLargest();//this was broken with arrays that had removed an item, then sorted
      }                                //is fixed now
        for (int j=0;j<array.howMany();j++) {
            array.addElem(temp[j]);
        }
    }



}

