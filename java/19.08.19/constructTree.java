import java.util.*;

public class constructTree
{
    static class Node
    {
        int data;
        Node left;
        Node right;
    }

    static Node construct(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd)
    {
        Node root = new Node();
        int totalLeftNodes = 0;
        for(int i = inStart; i <= inEnd; i++)
        {
            if(pre[preStart] == in[i])
            {
                totalLeftNodes = i-inStart;
                break;
            }
        }

        root.data = pre[preStart];
        if(preStart+1 <= preStart+totalLeftNodes && inStart <= inStart+totalLeftNodes-1)
            root.left = construct(pre, preStart+1, preStart+totalLeftNodes, in, inStart, inStart+totalLeftNodes-1);

        if(preStart+totalLeftNodes+1 <= preEnd && inStart+totalLeftNodes+1 <= inEnd)
            root.right = construct(pre, preStart+totalLeftNodes+1, preEnd, in, inStart+totalLeftNodes+1, inEnd);

        return root;
    }

    static void display(Node root)
    {
        String str = new String();
        str+=root.left!=null?root.left.data + " -> ":". -> ";
        str+=root.data;
        str+=root.right!=null? " <- " +root.right.data:" <- .";
        System.out.println(str);

        if(root.left!=null)
            display(root.left);
        if(root.right!=null)
            display(root.right);

        return;
    }

    public static void main(String[] args) 
    {
        int[] pre = {50, 25, 12, 37, 30, 75, 62, 70, 87};
        int[] in = {12, 25, 30, 37, 50, 62, 70, 75, 87};
        Node root = construct(pre, 0, pre.length-1, in, 0, in.length-1);

        display(root);
    }
}