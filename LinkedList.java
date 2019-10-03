import java.util.NoSuchElementException;
import java.util.NoSuchElementException;
import java.util.NoSuchElementException;
import java.util.NoSuchElementException;
import java.util.NoSuchElementException;

/**
   A linked list is a sequence of nodes with efficient
   element insertion and removal. This class
   contains a subset of the methods of the standard
   java.util.LinkedList class.
*/
public class LinkedList
{
    private Node first;

   /**
      Constructs an empty linked list.
   */
   public LinkedList()
   {    
       first = null;
       
    }
      /*public int size()
      {
       Node temp1 = first;
       int temp2 = 0; 
       while(temp1.next!=null)
       {
           temp1 = temp1.next;
           temp2++;
        }
       return temp2+1;
    }*/
    public int size()
    {
        if(first==null)
            return 0;
        else
            return (size(first.next))+1; 
    }
    public int size(Node no)
    {
        if(no!=null){
        return size(no.next)+1;
        }
        return 0;
    }
    public boolean contains(Object element){
        Node position = first;
        boolean flag = false;
        while(position!=null){
            if (position.data.equals(element))
                flag = true;
          position = position.next;  
        }
        return flag;
    }
   /**
      Returns the first element in the linked list.
      @return the first element in the linked list
   */
   public Object getFirst()
   {
       if(first == null){
       throw new NoSuchElementException();}
        
        
       
       return first.data;
    }
    public void set(int n,Object o )
    {
        if(n == 0)
        first.data = o;
        else
        getNode(n).data = o;
    }
    public Object get(int n)
    {
        if(n == 0)
        return this.getFirst();
        else
        return getNode(n).data;
    }
    private Node getNode(int n)
    {
        Node no = first;
        while(n>0){
            no = no.next;
            n--;
        }
        return no;
    }
    public void reverse(){   
	Node o = new Node();   
	Node one = first;
	int size = size();
	for(int i=0;i<size;i++)   
	{      
		Node two = one.next;      
		two.next = one; 
		two.data = one.next.data;      
		two.next.data = one.data;
		one = two;  
		
        }   
	first.next = null;   
	Node replace = getNode(size()-1);   
	set(size()-1,first);   
	first = replace;
}

   /**
      Removes the first element in the linked list.
      @return the removed element
   */
   public Object removeFirst(){
    if (first == null)
    throw new NoSuchElementException();
    Object element = first.data;
    first = first.next;
    return element ;
    }




   /**
      Adds an element to the front of the linked list.
      @param element the element to add
   */
    public void addFirst(Object element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        first = newNode; 
        
    }

   



   /**
      Returns an iterator for iterating through this list.
      @return an iterator for iterating through this list
   */
    public ListIterator listIterator(){
    return new LinkedListIterator();
    
    
    }
    
    
    




   //Class Node
   class Node{
       public Object data;//this object
       public Node next;
       
    }

   class LinkedListIterator implements ListIterator
   {
      //private data
      private Node position;
      private Node previous; 
      private boolean isAfterNext;
      


      /**
         Constructs an iterator that points to the front
         of the linked list.
      */
      public LinkedListIterator(){
        position = null;
        previous = null; 
        isAfterNext = false;
        }

      /**
         Moves the iterator past the next element.
         @return the traversed element
      */
        public Object next()
        {
            if(!hasNext())
            {
                throw new NoSuchElementException();
                //return null;
            }
            previous= position; //Remember for remove;
            isAfterNext = true; 
            if(position == null) 
            {
                position = first;// true == I have not called next 
            }
            else
            {
                position = position.next;
            }
            return position.data;
        }




      /**
         Tests if there is an element after the iterator position.
         @return true if there is an element after the iterator position
      */
        public boolean hasNext(){
            if (position == null){
            return (first!=null);
            
            }
            else 
            return position.next != null; 
        }

      /**
         Adds an element before the iterator position
         and moves the iterator past the inserted element.
         @param element the element to add
      */
        public void add (Object element)
        {
            if (position == null)
            {
                addFirst(element);//LL is empty
                position = first;
            }
            else{
                Node newNode = new Node();
                newNode.data = element; // Alias 
                newNode.next = position.next; //I know who is next 
                position.next =newNode; //Iterator thinks next is me
                position= newNode;// current posiion is me, little conflict if you call remove
                
                
            }
            isAfterNext = false;
            
        }

      



      /**
         Removes the last traversed element. This method may
         only be called after a call to the next() method.
      */
      public void remove(){
          if(!isAfterNext)//flag false so next has not been called
          {
            throw new IllegalStateException();
            
            }
          if(position == first){
            removeFirst();//calls LL method because we re an inner class
            
            }
          else{
            previous.next = position.next;// move ref of previou to node after me 
            }
          position = previous; 
          isAfterNext= false;
          //first call to remove the current position reverts to the predecessor 
          //of remove element thus predecessor is no longer known 
        }

      /**
         Sets the last traversed element to a different value.
         @param element the element to set
      */
      public void set (Object element)
      {
          if(!isAfterNext){
            throw new IllegalStateException(); 
            }
          position.data = element;
            
        
        }



   }//LinkedListIterator
}//LinkedList
