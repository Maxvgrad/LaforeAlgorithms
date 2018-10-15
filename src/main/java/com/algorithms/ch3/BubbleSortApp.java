package main.java.com.algorithms.ch3;

// bubbleSort.java
// demonstrates bubble sort
// to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
class ArrayBub {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items

    //--------------------------------------------------------------
    public ArrayBub(int max)          // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }

    //--------------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }

    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        for (int j = 0; j < nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }
//--------------------------------------------------------------



    //--------------------------------------------------------------
    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
//--------------------------------------------------------------
    // end class ArrayBub

    /**
     * Task 3.4
     */
    public int oddEvenSort() {
        int iterNum = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 1; i < nElems-1; ) {
                if (a[i] > a[i + 1]) {
                    swap(i, i + 1);
                    flag = true;
                }
                i++;
                i++;
            }

            for (int i = 0; i < nElems-1; ) {
                if (a[i] > a[i + 1]) {
                    swap(i, i + 1);
                    flag = true;
                }
                i++;
                i++;
            }
            iterNum++;
            iterNum++;
        }
        return iterNum;
    }
}
////////////////////////////////////////////////////////////////
class BubbleSortApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      ArrayBub arr;                 // reference to array
      arr = new ArrayBub(maxSize);  // create the array

          arr.insert(11);
          arr.insert(99);
          arr.insert(33);
          arr.insert(44);
          arr.insert(22);
          arr.insert(55);
          arr.insert(66);
          arr.insert(77);               // insert 10 items
          arr.insert(00);
          arr.insert(88);

      arr.display();                // display items

//      arr.bubbleSort();             // bubble sort them

          System.out.println(arr.oddEvenSort());
      arr.display();                // display them again
      }  // end main()
   }  // end class BubbleSortApp
////////////////////////////////////////////////////////////////
