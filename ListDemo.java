/**
   A program that demonstrates the LinkedList class
*/
public class ListDemo
{
   public static void main(String[] args)
   {
      //create LinkedList and add to it
      LinkedList staff = new LinkedList();
      staff.addFirst("Tom");
      staff.addFirst("ron");
      staff.addFirst("Harry");
      staff.addFirst("Dominic");

      //System.out.println(staff.getFirst());
      
      // | in the comments indicates the iterator position
      ListIterator iterator = staff.listIterator(); // |DRHT
      //iterator.next();//D|RHT
      //iterator.next();//DR|HT
      

      // Add more elements after second element
      //iterator.add("Jane");//DRJ|HT
      //iterator.add("Neha");//DRJN|HT


      // Remove last traversed element
      //iterator.next();//DRJNH|T
      //iterator.remove();//DRJN|T
      


      // Print all elements
      
      //iterator = staff.listIterator();
      System.out.println(staff.size());
      staff.reverse();
      while (iterator.hasNext())
      {
         System.out.print(iterator.next() + " ");
      }
      System.out.println();
      staff.reverse();
      while (iterator.hasNext())
      {
         System.out.print(iterator.next() + " ");
      }
      System.out.println();
   }
}
