import java.util.*;

public class prePostConstruct
{
    static class Node
    {
        int data;
        Node left;
        Node right;
    }

    static Node construct(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd)
    {
        Node root = new Node();
        root.data = pre[preStart];

        int totalLeftNodes = 0;
        for(int i = postStart; i <= postEnd; i++)
        {
            if(postStart==postEnd)
            {
                return root;
            }
            if(pre[preStart+1] == post[i])
            {
                totalLeftNodes = i-postStart+1;
                break;
            }
        }

        if(preStart+1 <= preStart+totalLeftNodes && postStart <= postStart+totalLeftNodes-1)
            root.left = construct(pre, preStart+1, preStart+totalLeftNodes, post, postStart, postStart+totalLeftNodes-1);

        if(preStart+totalLeftNodes+1<=preEnd&&postStart+totalLeftNodes<=postEnd-1)
            root.right = construct(pre, preStart+totalLeftNodes+1, preEnd, post, postStart+totalLeftNodes, postEnd-1);

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
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] post = {4, 5, 2, 6, 7, 3, 1};
        Node root = construct(pre, 0, pre.length-1, post, 0, post.length-1);

        display(root);
    }
}