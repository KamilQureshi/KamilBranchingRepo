import java.util.NoSuchElementException;

/**
   An implementation of a queue as a circular array.
*/
public class CircularArrayQueue
{
   private Object[] elements;
   //private data
   private int currentSize; 
   private int head;
   private int tail; 


   /**
      Constructs an empty queue.
   */
   public CircularArrayQueue()
   {
       final int INITIAL_SIZE = 10;
       elements = new Object[INITIAL_SIZE];
       currentSize = head = tail = 0;
       head = 0;
    }
   
   public void firstToLast()
   {
       Object o = elements[head];
       elements[head]= tail;
       head++;
       elements[tail] = o;
       tail++;
       
    }
 
   public void addFirst(Object o)
   {
       growIfNecessary();
       currentSize++;
       int x = head; 
       for(int i = 0; i<currentSize; i++)
       {
           elements[i]=(elements[i+1%elements.length]);
        }
       elements[head ]= o;
    } 
   public int size()
   {
       return currentSize;
    }
   public void lastToFirst()
   {
       Object o = elements[tail];
       tail = ((head-1)%(elements.length));
       head-=1;
       
    }
   public Object removeLast()
   {
       Object o = elements[(tail-1)%elements.length];
       
       elements[(tail-1)%elements.length]= null;
       tail=(tail%elements.length)-1;
       return o;
    }
   /**
      Checks whether this queue is empty.
      @return true if this queue is empty
   */
   public boolean empty()
   { return (currentSize == 0);}



   /**
      Adds an element to the tail of this queue.
      @param newElement the element to add
   */
   public void add(Object o)
   {//grow the array
       growIfNecessary();
       currentSize++; 
       int x= tail;
       elements[tail] = o;
       tail = (tail+1) % elements.length;
    }



   /**
      Removes an element from the head of this queue.
      @return the removed element
   */
   public Object remove(Object o)
   {
       if(empty())
       throw new NoSuchElementException();
       currentSize--; 
       int h = head;
       head = (head+1)% elements.length;
       return elements[h]; 
    }




   /**
      Grows the element array if the current size equals the capacity.
   */
   private void growIfNecessary()
   {
       if(currentSize == elements.length)
       {
           Object[] elements2 = new Object[elements.length*2];
           // newE = e :<
           for(int i=0;i<elements.length;i++){
               elements2[i] =elements[(head+i)%elements.length];
            }
           head = 0; 
           tail = currentSize;
           elements = elements2;
        }
    }




}//CircularArrayQueue
