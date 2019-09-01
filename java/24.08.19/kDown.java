import java.util.*;

public class kDown
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

    static void kDown(Node node, int k)
    {
        if(k == 0)
        {
            System.out.println(node.data);
            return;
        }
        if(node.left != null)
        {
            kDown(node.left, k-1);
        }
        if(node.right != null)
        {
            kDown(node.right, k-1);
        }
        return;
    }

    public static void main(String[] args) 
    {
        int[] post = {1, 3, 2, 4, 7};
        int[] in = {1, 2, 3, 7, 4};
        Node root = construct(post, 0, post.length-1, in, 0, in.length-1);

        kDown(root, 2);
    }
}