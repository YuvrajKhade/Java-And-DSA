// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class BinaryTree {
    static class Node{
        int data;
        Node left,right;
        
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class buildTree{
        static int idx=-1;
        public static Node build(int node[]){
            idx++;
            if(node[idx]==-1){
                return null;
            }
            Node newNode=new Node(node[idx]);
            newNode.left=build(node);
            newNode.right=build(node);
            
            return newNode;
        }
        public static void preorder(Node root){
            
            if(root==null){
                return;
            }
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
        }
        public static void inorder(Node root){
            
            if(root==null){
                return;
            }
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
        public static void postorder(Node root){
            if(root==null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data);
        }
        
    }
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int node[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        
        buildTree tree=new buildTree();
        Node root=tree.build(node);
        
        System.out.println("Preorder");
        tree.preorder(root);
        System.out.println("Inorder");
        tree.inorder(root);
        System.out.println("Postorder");
        tree.postorder(root);
        
        
    }
}