import java.io.*;


class Main{
    
    static class Node{
        int c;
        Node l;
        Node r;
        
        public Node(int c){
            this.c = c;
            l = null;
            r = null;
        }
    }
    
    static class Tree{
        protected String psString = "";
        protected static int prIndx = 0;
        
        private Node buildTree(String in[], String pre[], int inC, int inF){
            if(inC > inF)
                return null;
            
            int value = Integer.parseInt(pre[prIndx++]);
            Node treeNode = new Node(value);
            
            if(inC == inF)
                return treeNode;
            int inIndx = search(in, inC, inF, treeNode.c);
            
            treeNode.l = buildTree(in, pre, inC, inIndx - 1);
	    treeNode.r = buildTree(in, pre, inIndx + 1, inF);
            
            return treeNode;
        }
        
        private int search(String arr[], int C, int F, int value){
            int i;
            for(i = C; i <= F; i++){
                int arrV = Integer.parseInt(arr[i]);
                if(arrV == value)
                    return i;
            }
            return i;
        }
        
        private void pOrdrTree(Node n){
            if (n == null) return;


            pOrdrTree(n.l);


            pOrdrTree(n.r);


            psString += n.c + " ";
        }
        
        private String eqlsStr(){
            return psString;
        }
              
    }

    
    public static void main(String[] args) throws IOException{
		try {
			Tree tree = new Tree();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int size = Integer.parseInt(in.readLine());

			String pre = in.readLine();
			String preOrder[] = pre.split(" ");
			
			String pos = in.readLine();
			
			String inOr = in.readLine();
			String inOrder[] = inOr.split(" ");
			
			Node root = tree.buildTree(inOrder, preOrder, 0, size-1);
			
			tree.pOrdrTree(root);
			
			String posTree = tree.eqlsStr();
			
			String posStr = posTree.substring(0, posTree.length() - 1);
			if(pos.equals(posStr)) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
                }
    }
    
}
