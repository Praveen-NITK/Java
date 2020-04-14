//Groupon: Node is either text node or none data node
//all text nodes are leaf node
// all other nodes must have two childs
//print the character for given position 3:c, 7:g etc
package Tree;
public class TextNodes{
    static class Node{
        String value;
        boolean isTextNode;
        Node left,right;

        Node(String v, boolean istxt){
            value=v;
            isTextNode=istxt;
            left=right=null;
        }

    }
    public static void main(String[] args) {
        Node root= new Node(null, false);
        root.left=new Node(null, false);
        root.left.left= new Node("abcd",true);
        root.left.right= new Node("efg", true);
        root.right=new Node("hij", true);


        int position= 7;

        String c=getCharAtPosition(root, position);
        System.out.println("String at pos 7 is: "+c);

        //inorder(root);
    }

    private static String getCharAtPosition(Node root, int position) {
        if(root==null)
            return "";        
        if(root.isTextNode){
            if(root.value.length()>=position){
                return root.value.substring(position, position+1);
            }
            
        }
        root.value=getCharAtPosition(root.left, position);
        root.value=getCharAtPosition(root.right, position);
        return root.value;
    }

    private static void inorder(Node root) {
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.value);
        inorder(root.right);
    }
}
