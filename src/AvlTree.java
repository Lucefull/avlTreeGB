public class AvlTree {
    private AvlNode root;     
 
     public AvlTree()
     {
         root = null;
     }    
     
     public void insert(int data)
     {
         root = insert(data, root);
     }
     
     private int height(AvlNode t )
     {
         return t == null ? -1 : t.height;
     }
     
     private int max(int lhs, int rhs)
     {
         return lhs > rhs ? lhs : rhs;
     }
     
     private AvlNode insert(int x, AvlNode t)
     {
         if (t == null)
             t = new AvlNode(x);
         else if (x < t.data)
         {
             t.left = insert( x, t.left );
             if( height( t.left ) - height( t.right ) == 2 )
                 if( x < t.left.data )
                     t = rotateWithLeftChild( t );
                 else
                     t = doubleWithLeftChild( t );
         }
         else if( x > t.data )
         {
             t.right = insert( x, t.right );
             if( height( t.right ) - height( t.left ) == 2 )
                 if( x > t.right.data)
                     t = rotateWithRightChild( t );
                 else
                     t = doubleWithRightChild( t );
         }
         else
           ;  
         t.height = max( height( t.left ), height( t.right ) ) + 1;
         return t;
     }
         
     private AvlNode rotateWithLeftChild(AvlNode k2)
     {
         AvlNode k1 = k2.left;
         k2.left = k1.right;
         k1.right = k2;
         k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
         k1.height = max( height( k1.left ), k2.height ) + 1;
         return k1;
     }
 
     
     private AvlNode rotateWithRightChild(AvlNode k1)
     {
         AvlNode k2 = k1.right;
         k1.right = k2.left;
         k2.left = k1;
         k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
         k2.height = max( height( k2.right ), k1.height ) + 1;
         return k2;
     }
     
     private AvlNode doubleWithLeftChild(AvlNode k3)
     {
         k3.left = rotateWithRightChild( k3.left );
         return rotateWithLeftChild( k3 );
     }
       
     private AvlNode doubleWithRightChild(AvlNode k1)
     {
         k1.right = rotateWithLeftChild( k1.right );
         return rotateWithRightChild( k1 );
     }    
     
     
     public boolean search(int val)
     {
         return search(root, val);
     }
     private boolean search(AvlNode r, int val)
     {
         boolean found = false;
         while ((r != null) && !found)
         {
             int rval = r.data;
             if (val < rval)
                 r = r.left;
             else if (val > rval)
                 r = r.right;
             else
             {
                 found = true;
                 System.out.print(r.toString());
                 break;
             }
             found = search(r, val);
         }
         return found;
     }
     
     public void inorder()
     {
         inorder(root);
     }
     private void inorder(AvlNode r)
     {
         if (r != null)
         {
             inorder(r.left);
             System.out.print(r.data +" ");
             inorder(r.right);
         }
     }
     
     public void preorder()
     {
         preorder(root);
     }
     private void preorder(AvlNode r)
     {
         if (r != null)
         {
             System.out.print(r.data +" ");
             preorder(r.left);             
             preorder(r.right);
         }
     }
     
     public void postorder()
     {
         postorder(root);
     }
     private void postorder(AvlNode r)
     {
         if (r != null)
         {
             postorder(r.left);             
             postorder(r.right);
             System.out.print(r.data +" ");
         }
     }     

     Node deleteNode(Node root, int item) {

    // Find the node to be deleted and remove it
    if (root == null)
      return root;
    if (item < root.item)
      root.left = deleteNode(root.left, item);
    else if (item > root.item)
      root.right = deleteNode(root.right, item);
    else {
      if ((root.left == null) || (root.right == null)) {
        Node temp = null;
        if (temp == root.left)
          temp = root.right;
        else
          temp = root.left;
        if (temp == null) {
          temp = root;
          root = null;
        } else
          root = temp;
      } else {
        Node temp = nodeWithMimumValue(root.right);
        root.item = temp.item;
        root.right = deleteNode(root.right, temp.item);
      }
    }
    if (root == null)
      return root;

    // Update the balance factor of each node and balance the tree
    root.height = max(height(root.left), height(root.right)) + 1;
    int balanceFactor = getBalanceFactor(root);
    if (balanceFactor > 1) {
      if (getBalanceFactor(root.left) >= 0) {
        return rightRotate(root);
      } else {
        root.left = leftRotate(root.left);
        return rightRotate(root);
      }
    }
    if (balanceFactor < -1) {
      if (getBalanceFactor(root.right) <= 0) {
        return leftRotate(root);
      } else {
        root.right = rightRotate(root.right);
        return leftRotate(root);
      }
    }
    return root;
  }
}
