package com.algorithms.ch4;

import java.util.Arrays;
import java.util.Objects;

// priorityQ.java
// demonstrates priority queue
// to run this program: C>java PriorityQApp
////////////////////////////////////////////////////////////////
class PriorityQ
   {
   // array in sorted order, from max at 0 to min at size-1
   private int maxSize;
   private long[] queArray;
   private int nItems;
//-------------------------------------------------------------
   public PriorityQ(int s)          // constructor
      {
      maxSize = s;
      queArray = new long[maxSize];
      nItems = 0;
      }
//-------------------------------------------------------------
   public void insert(long item)    // insert item
      {
      int j;

      if(nItems==0)                         // if no items,
         queArray[nItems++] = item;         // insert at 0
      else                                // if items,
         {
         for(j=nItems-1; j>=0; j--)         // start at end,
            {
            if( item > queArray[j] )      // if new item larger,
               queArray[j+1] = queArray[j]; // shift upward
            else                          // if smaller,
               break;                     // done shifting
            }  // end for
         queArray[j+1] = item;            // insert it
         nItems++;
         }  // end else (nItems > 0)
      }  // end insert()
//-------------------------------------------------------------
   public long remove()             // remove minimum item
      { return queArray[--nItems]; }
//-------------------------------------------------------------
   public long peekMin()            // peek at minimum item
      { return queArray[nItems-1]; }
//-------------------------------------------------------------
   public boolean isEmpty()         // true if queue is empty
      { return (nItems==0); }
//-------------------------------------------------------------
   public boolean isFull()          // true if queue is full
      { return (nItems == maxSize); }
//-------------------------------------------------------------
   }  // end class PriorityQ

/**
 * Task 4.4
 */

class PriorityQueue<E extends Comparable> {
    // array in sorted order, from max at 0 to min at size-1
    private int capacity;
    private Object[] data;
    private int nItems;
    //-------------------------------------------------------------
    public PriorityQueue(int s) {
        if (s < 0)
            throw new IllegalArgumentException();
        capacity = s;
        data = new Object[capacity];
    }

    public void insert(E item) {
        if(nItems < data.length && !Objects.isNull(item))
            data[nItems++] = item;
    }
    public E remove() {
        E e = findMin();
        if (e != null) {
            int i = indexOf(e);
            System.arraycopy(data, i + 1, data, i, nItems - (i + 1));
            cleanElement(nItems-1);
            nItems--;
        }
        return e;
    }

    @SuppressWarnings("unchecked")
    private E getElement(int index) {
        return (E) data[index];
    }

    private void cleanElement(int index) {
        data[index] = null;
    }

    public E peekMin() {
        return findMin();
    }

    private E findMin() {
        E min = null;
        if (nItems != 0) {
            min = getElement(0);
            for (int i = 1; i < nItems; i++) {
                if (min.compareTo(getElement(i)) > 0) {
                    min = getElement(i);
                }
            }
        }
        return min;
    }

    private int indexOf(E e)  {
        int i = -1;
        for(i = 0; i < nItems; i++) {
            if (getElement(i).equals(e))
                break;
        }
        return i;
    }



    //-------------------------------------------------------------
    public boolean isEmpty()         // true if queue is empty
    { return (nItems==0); }
    //-------------------------------------------------------------
    public boolean isFull()          // true if queue is full
    { return (nItems == capacity); }
//-------------------------------------------------------------
}  // end class PriorityQ


class PriorityQApp
   {
   public static void main(String[] args)
      {
      PriorityQueue<Integer> thePQ = new PriorityQueue<>(5);
      thePQ.insert(30);
      thePQ.insert(50);
      thePQ.insert(10);
      thePQ.insert(40);
      thePQ.insert(20);

      while( !thePQ.isEmpty() )
         {
         long item = thePQ.remove();
         System.out.print(item + " ");  // 10, 20, 30, 40, 50
         }  // end while
      System.out.println("");
      }  // end main()
//-------------------------------------------------------------
   }  // end class PriorityQApp
////////////////////////////////////////////////////////////////
