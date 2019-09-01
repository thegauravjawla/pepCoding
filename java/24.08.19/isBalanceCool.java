import java.util.*;

public class isBalanceCool
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

    public static class Pair
    {
        boolean balance;
        int height;

        Pair(boolean balance, int height)
        {
            this.balance = balance;
            this.height = height;
        }

        Pair(){};
    }

    static boolean isBalance = true;
    static int height(Node root)
    {
        if(isBalance == true)
        {
            int leftHeight = root.left!=null? height(root.left):0;
            int rightHeight = root.right!=null? height(root.right):0;

            if(Math.abs(leftHeight-rightHeight) > 1)
            {
                isBalance = false;
            }

            return Math.max(leftHeight, rightHeight)+1;
        }
        else 
        {
            return 0;
        }
    }

    public static void main(String[] args) 
    {
        int[] post = {4, 2, 3, 1};
        int[] in = {2, 4, 1, 3};
        Node root = construct(post, 0, post.length-1, in, 0, in.length-1);

        height(root);
        System.out.println(isBalance);
    }
}