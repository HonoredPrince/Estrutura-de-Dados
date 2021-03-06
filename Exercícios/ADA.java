import java.io.*;

class Main
{
  static class Node
  {
    private String content;
    private Node next;
    
    public Node()
    {
      next = null;  
    }
    
    public void setNext(Node next)
    {
      this.next = next;
    }
    
    public void setContent(String content)
    {
      this.content = content;
    }
    
    public Node getNext()
    {
      return next;
    }
    
    public String getContent()
    {
      return content;
    }
  }
  
  static class ListaSE
  {
    protected int size;
    protected boolean empty;
    protected Node head;
    
    public ListaSE(int s)
    {
      head = null;
      size = s;
      empty = true;
    } 
    
    public void add(String str)
    {
      Node newNode = new Node();
      newNode.setContent(str);
      newNode.setNext(null);
      
      if(empty)
      {
        head = newNode;
        empty = false;
      }
      
      else
      {
        Node aux = head;
        
        while(aux.getNext() != null)
        {
          aux = aux.getNext();  
        }
        
        aux.setNext(newNode);
      }
    }
    
    public int search(String str)
    {
      int counter = 0;
      Node aux = head;
            
        for(int i = 0; i < size; i++)
        {
          if(aux.getContent().startsWith(str))
          {
            counter++;
          }
          aux = aux.getNext();
        }

        return counter;
    }
    
  }
  
  public static void main(String[] args) throws Exception
  {
    int n, q;
    String aux, a, prefix;
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    a = in.readLine();
    String[] parts = a.split(" ");
    n = Integer.parseInt(parts[0]);
    q = Integer.parseInt(parts[1]);
    
    ListaSE TD = new ListaSE(n);
    
    for(int i = 0; i < n; i++)
    {
      aux = in.readLine();
      TD.add(aux);
    }
    
    for(int i = 0; i < q; i++)
    {
      prefix = in.readLine();
      int x = TD.search(prefix);
      System.out.println(x);
    }
  }
}