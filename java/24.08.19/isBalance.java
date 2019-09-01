import java.util.*;

public class isBalance
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

    static Pair isBalance(Node root)
    {
        if(root == null)
        {
            Pair base = new Pair(true, 0);
            return base;
        }
        Pair left = isBalance(root.left);
        Pair right = isBalance(root.right);

        Pair ans = new Pair();
        ans.height = Math.max(left.height, right.height) + 1;
        ans.balance = true;

        if(Math.abs(left.height-right.height) > 1)
        {
            ans.balance = false;
        }

        return ans;
    }

    public static void main(String[] args) 
    {
        int[] post = {3, 4, 2, 1};
        int[] in = {3, 2, 4, 1};
        Node root = construct(post, 0, post.length-1, in, 0, in.length-1);

        Pair p = isBalance(root);
        System.out.println(p.balance);
    }
}