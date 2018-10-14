package com.algorithms.ch2;

// highArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
class HighArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public HighArray(int max)         // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
   //-----------------------------------------------------------
   public boolean find(long searchKey)
      {                              // find specified value
      int j;
      for(j=0; j<nElems; j++)            // for each element,
         if(a[j] == searchKey)           // found item?
            break;                       // exit loop before end
      if(j == nElems)                    // gone to end?
         return false;                   // yes, can't find it
      else
         return true;                    // no, found it
      }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j;
      for(j=0; j<nElems; j++)        // look for it
         if( value == a[j] )
            break;
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move higher ones down
            a[k] = a[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }

      /**
       * Task 2.1
       */
   public int getMax() {
      int maxIndex = -1;
      long max = Long.MIN_VALUE;
      for (int i = 0; i < nElems; i++) {
         if (max < a[i]) {
            max = a[i];
            maxIndex = i;
         }
      }

      return maxIndex;
   }


   /**
    * Task 2.2
    */
   public boolean removeMax() {
      return delete(a[getMax()]);
   }

   private boolean deleteAll(long value) {
      boolean flag;
      while (flag=delete(value)) {}
      return !flag;
   }

   /**
    * Task 2.6
    */

   public void noDubs() {
      final long[] arr = new long[a.length];
      int newIndex = 0;
      for (; nElems > 0; newIndex++) {
         arr[newIndex] = a[0];
         deleteAll(a[0]);
      }
      a = arr;
      nElems = newIndex;
   }
   //-----------------------------------------------------------
   }  // end class HighArray
////////////////////////////////////////////////////////////////
class HighArrayApp
   {
   public static void main(String[] args)
      {

      int maxSize = 100;            // array size
      HighArray arr;                // reference to array
      arr = new HighArray(maxSize); // create the array

      arr.insert(77);               // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(66);
      arr.insert(33);

      arr.display();                // display items

      int searchKey = 35;           // search for item
      if( arr.find(searchKey) )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.delete(00);               // delete 3 items
      arr.delete(55);
      arr.delete(99);

      arr.display();// display items again

         System.out.printf("Max value index '%d'\n", arr.getMax());
         arr.removeMax();
         arr.display();
         System.out.printf("Max value index '%d'\n", arr.getMax());

         arr.noDubs();

         arr.display();
      }  // end main()
   }  // end class HighArrayApp
