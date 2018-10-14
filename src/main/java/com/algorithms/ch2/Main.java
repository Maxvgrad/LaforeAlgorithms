package com.algorithms.ch2;

// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public OrdArray(int max)          // constructor
      {
      a = new long[max];             // create array
      nElems = 0;
      }
   //-----------------------------------------------------------
   public int size()
      { return nElems; }
   //-----------------------------------------------------------
   public int find(long searchKey)
      {
      int lowerBound = 0;
      int upperBound = nElems-1;
      int curIn;

      while(true)
         {
         curIn = (lowerBound + upperBound ) / 2;
         if(a[curIn]==searchKey)
            return curIn;              // found it
         else if(lowerBound > upperBound)
            return a[curIn] > searchKey ? -1*curIn -1 : -1*curIn -2;             // can't find it
         else                          // divide range
            {
            if(a[curIn] < searchKey)
               lowerBound = curIn + 1; // it's in upper half
            else
               upperBound = curIn - 1; // it's in lower half
            }  // end else divide range
         }  // end while
      }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      int j = find(value);
      j = j < 0 ? -1*j-1 : j;

      for(int k=nElems; k>j; k--)    // move bigger ones up
         a[k] = a[k-1];
      a[j] = value;                  // insert it
      nElems++;                      // increment size
      }  // end insert()
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j = find(value);
      if(j<0)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move bigger ones down
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
       * Task 2.5
       */
    public OrdArray merge(OrdArray arr) {
       ensureCapasity(nElems + arr.nElems);
       for (int i = 0; i < arr.size(); i++)
           insert(arr.a[i]);
       return this;
   }

   private void ensureCapasity(int minCapasity) {
       if (a.length <= minCapasity) {
           grow(minCapasity<<2+1);
       }
   }

   private void grow(int size) {
       grow(size, 0, 0, nElems);
   }

   private void grow(int size, int srcPos, int destPos, int len) {
       long[] dest = new long[size];
       System.arraycopy(a, srcPos, dest, destPos, len);
       a = dest;
   }
   //-----------------------------------------------------------
   }  // end class OrdArray
////////////////////////////////////////////////////////////////
class OrderedApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;             // array size
      OrdArray arr;                  // reference to array
      arr = new OrdArray(maxSize);   // create the array
        arr.display();
      arr.insert(77);                // insert 10 items
          arr.display();

      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(0);
      arr.insert(66);
      arr.insert(33);

          int searchKey = 55;            // search for item

          System.out.println(String.format("Looking for %d -> %d", searchKey=55, arr.find(searchKey)));
          System.out.println(String.format("Looking for %d -> %d", searchKey=11, arr.find(searchKey)));
          System.out.println(String.format("Looking for %d -> %d", searchKey=42, arr.find(searchKey)));
          System.out.println(String.format("Looking for %d -> %d", searchKey=12, arr.find(searchKey)));
          System.out.println(String.format("Looking for %d -> %d", searchKey=-1, arr.find(searchKey)));

          arr.display();
          arr.insert(42);
          arr.insert(-111);
          arr.insert(103);
          arr.insert(0);
          arr.display();
          arr.insert(11);


      arr.display();                 // display items

      arr.delete(0);                // delete 3 items
      arr.delete(55);
      arr.delete(99);

      arr.display();                 // display items again


          OrdArray arrNext;                  // reference to array
          arrNext = new OrdArray(maxSize);   // create the array
          arrNext.insert(77);                // insert 10 items

          arrNext.insert(34);
          arrNext.insert(54);
          arrNext.insert(87);
          arrNext.insert(43);
          arrNext.insert(-2);
          arrNext.insert(32);
          arrNext.insert(0);
          arrNext.insert(43);
          arrNext.insert(33);

          arr.merge(arrNext).display();
      }  // end main()
   }  // end class OrderedApp
