public class QueueDemo
{
   public static void main(String[] args)
   {
      CircularArrayQueue q = new CircularArrayQueue();
	if(true){}
      //add to q
      q.add("Jennifer");
      q.add("yee");
      q.add("ohyeah");
      q.add("MrKrabs");
      q.add("Heck");
      //System.out.println(q);
      System.out.println(q.size());
      
      while (!q.empty())
      {
        System.out.println(q.removeLast());
      }
   }
}
