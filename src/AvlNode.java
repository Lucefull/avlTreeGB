public class AvlNode {
    AvlNode left, right;
     int data;
     int height;
 
     
     public AvlNode()
     {
         left = null;
         right = null;
         data = 0;
         height = 0;
     }
     
     public AvlNode(int n)
     {
         left = null;
         right = null;
         data = n;
         height = 0;
     }

    @Override
    public String toString() {
        return "Nó: "+this.data+" ; Esquerda: "+left.data+" ; Direita: "+right.data+"\n";
    }     

     
}
