import java.util.*;

public class diameterOptimize
{
    static class Node
    {
        int data;
        Node left;
        Node right;
    }

    static Node construct(int[] post, int postStart, int postEnd, int[] in, int inStart, int inEnd)
    {
        Node root = new Node();
        int totalLeftNodes = 0;
        for(int i = inStart; i <= inEnd; i++)
        {
            if(post[postEnd] == in[i])
            {
                totalLeftNodes = i-inStart;
                break;
            }
        }

        root.data = post[postEnd];
        if(postStart <= postStart+totalLeftNodes-1 && inStart <= inStart+totalLeftNodes-1)
            root.left = construct(post, postStart, postStart+totalLeftNodes-1, in, inStart, inStart+totalLeftNodes-1);

        if(postStart+totalLeftNodes <= postEnd-1 && inStart+totalLeftNodes+1 <= inEnd)
            root.right = construct(post, postStart+totalLeftNodes, postEnd-1, in, inStart+totalLeftNodes+1, inEnd);

        return root;
    }

    static int diameter(Node root)
    {
        int left = root.left!=null? diameter(root.left):0;
        int right = root.right!=null? diameter(root.right):0;

        return Math.max(Math.max(left, right)+1, Math.max(left, right));
        //wrong code
        //in right code, store height component and diameter component of recursive solution in a class and keep returning that object
    }

    public static void main(String[] args) 
    {
        int[] post = {12, 30, 37, 25, 70, 62, 87, 75, 50};
        int[] in = {12, 25, 30, 37, 50, 62, 70, 75, 87};
        Node root = construct(post, 0, post.length-1, in, 0, in.length-1);

        int diameter = diameter(root);
        System.out.println(diameter);
    }
}