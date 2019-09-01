import java.util.*;

public class isBST
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
        boolean localBST;
        int max;
        int min;
    }

    static Pair isBST(Node root)
    {
        if(root == null)
        {
            Pair base = new Pair();
            base.localBST = true;
            base.max = 0;
            base.min = Integer.MAX_VALUE;
            return base;
        }
        Pair left = isBST(root.left);
        Pair right = isBST(root.right);

        Pair ans = new Pair();
        ans.max = Math.max(root.data, Math.max(left.max, right.max));
        ans.min = Math.min(root.data, Math.min(left.min, right.min));
        ans.localBST = true;

        if(left.max >= root.data || right.min <= root.data || left.localBST == false || right.localBST == false)
        {
            ans.localBST = false;
        }

        return ans;
    }

    public static void main(String[] args) 
    {
        int[] post = {1, 3, 2};
        int[] in = {1, 2, 3};
        Node root = construct(post, 0, post.length-1, in, 0, in.length-1);

        Pair ans = isBST(root);
        System.out.println(ans.localBST);
    }
}