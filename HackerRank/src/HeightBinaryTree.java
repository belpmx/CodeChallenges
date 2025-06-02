public class HeightBinaryTree {
    //https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees
    class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }


    public static int height(Node root) {
        if(root== null) return -1;
        int leftHeight =0;
        int rightHeight =0;
        //first traverse the left
        //recurse call of this method on both sides
        if(root.left != null){
            leftHeight = height(root.left)+1;
        }
        if (root.right != null){
            rightHeight = height(root.right)+1;
        }
        return Math.max(leftHeight, rightHeight);

    }




}
