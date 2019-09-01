import java.util.*;

public class diameter
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

    static int height(Node root)
    {
        int leftHeight = root.left!=null? height(root.left):0;
        int rightHeight = root.right!=null? height(root.right):0;

        return Math.max(leftHeight, rightHeight)+1;
    }

    static int diameter(Node root)
    {
        int left = 0;
        int right = 0;
        int throughNode = 1;
        if(root.left != null)
        {
            left = diameter(root.left);
            throughNode+=height(root.left);
        }
        if(root.right != null)
        {
            right = diameter(root.right);
            throughNode+=height(root.right);
        }

        return Math.max(throughNode, Math.max(left, right));
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