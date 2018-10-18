package com.algorithms.ch3;

// insertSort.java
// demonstrates insertion sort
// to run this program: C>java InsertSortApp
//--------------------------------------------------------------
class ArrayIns
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
//--------------------------------------------------------------
   public ArrayIns(int max)          // constructor
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
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
//--------------------------------------------------------------

   /**
    * Task 3.3
    */
   void noDubs() {
       insertionSort();
       for (int i = 0; i < nElems-1; i++) {
           int dest = i+1;
           int src = i+1;
           while (a[i] == a[i+1] && i < nElems-1) {
               src++;
               i++;
           }
           if (src != dest) {
               System.arraycopy(a,src, a, dest, nElems-dest);
               nElems = nElems - (src - dest);
               i = dest-1;
           }
       }
   }
    /**
     * Task 3.6
     */
   void insertionSort()
      {
      int in, out;

      for(out=1; out<nElems; out++)     // out is dividing line
         {
         long temp = a[out];            // remove marked item
         in = out;                      // start shifts at out
         while(in>0 && a[in-1] >= temp) // until one is smaller,
         {
            a[in] = a[in-1];            // shift item to right
            --in;                       // go left one position
         }
         a[in] = temp;                  // insert marked item
         }  // end for
      }  // end insertionSort()


       /**
        * Task 3.1
        */
       public void bubbleSort() {
           int out, in, outLeft = 0;

           for (out = nElems - 1; out > outLeft; out--) {   // outer loop (backward)
               outLeft = nElems - out - 1;
               for (in = outLeft; in < out; in++)        // inner loop (forward)
                   if (a[in] > a[in + 1])       // out of order?
                       swap(in, in + 1);
               // swap them
               for (in = out; in > outLeft; in--) {
                   if (a[in] < a[in - 1]) {
                       swap(in, in - 1);
                   }
               }
           }
       }  // end bubbleSort()

       private void swap(int first, int second) {
           long tmp = a[first];
           a[first] = a[second];
           a[second] = tmp;
       }

       void insertionSortNoDubs() {
           int in, out;
           int numOfDubs=0;

           for(out=1; out<nElems; out++) {
               long temp = a[out];
               in = out;                      // start shifts at out
               while(in>0 && a[in-1] >= temp) {
                   if (a[in-1] == temp && temp != Long.MIN_VALUE) {
                       temp = Long.MIN_VALUE;
                       numOfDubs++;
                   }
                   a[in] = a[in - 1];
                   --in;                       // go left one position
               }
               a[in] = temp;                  // insert marked item
           }  // end for
           System.arraycopy(a, numOfDubs, a, 0, (nElems=nElems-numOfDubs));
       }  // end insertionSort()

       /**
        * Task 3.2
        */
       public double median() {
           insertionSort();
           if (nElems % 2 == 0) {
               int index = nElems / 2;
               return (a[index] + a[index-1]) / 2.0;
           }
           return a[nElems / 2] * 1.0;
       }
       //--------------------------------------------------------------

       /**
        * Task 3.5
        */
       public void insertionSortWithOutput()
       {
           int in, out, copy=0, compare=0;

           for(out=1; out<nElems; out++)     // out is dividing line
           {
               long temp = a[out];            // remove marked item
               in = out;                      // start shifts at out
               while(in>0 && a[in-1] >= temp) // until one is smaller,
               {
                   a[in] = a[in-1];// shift item to right
                   --in;                       // go left one position
                   copy++;
                   compare++;
               }
               compare++;
               a[in] = temp;                  // insert marked item
           }  // end for
           System.out.println("Compare: " + compare + " Copy: " + copy);
       }  // end insertionSort()

       public int size() {
           return nElems;
       }

       /**
        * Task 3.4
        */
       public void oddEvenSort() {
           int counter = 0;
           while (true) {
               boolean isSorted = true;

               for (int i = 0; i < nElems-1; i=i+2) {
                   if (a[i] > a[i+1]) {
                       swap(i, i+1);
                       isSorted=false;
                   }
               }
               for (int i = 1; i < nElems-1; i=i+2) {
                   if (a[i] > a[i+1]) {
                       swap(i, i+1);
                       isSorted=false;
                   }
               }

               if (isSorted) {
                   break;
               }
               counter++;
           }
           System.out.println("Number of cycles: " + counter);
       }
//--------------------------------------------------------------
   }  // end class ArrayIns
////////////////////////////////////////////////////////////////
class InsertSortApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      ArrayIns arr;                 // reference to array
      arr = new ArrayIns(maxSize);  // create the array

      arr.insert(77);               // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(22);
      arr.insert(22);
      arr.insert(-22);
      arr.insert(88);
      arr.insert(Long.MIN_VALUE);
      arr.insert(88);
      arr.insert(88);
      arr.insert(Long.MAX_VALUE);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);
      arr.insert(33);
      arr.insert(33);

      arr.display();                // display items

          arr.oddEvenSort();
      arr.display();                // display them again
      }  // end main()
   }  // end class InsertSortApp
