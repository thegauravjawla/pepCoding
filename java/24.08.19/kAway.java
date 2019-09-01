import java.util.*;

public class kAway
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

    static ArrayList<Node> path(Node root, int node)
    {
        if(node == root.data)
        {
            ArrayList<Node> p = new ArrayList<>();
            p.add(root);
            return p;
        }
        ArrayList<Node> left = new ArrayList<>();
        ArrayList<Node> right = new ArrayList<>();
        if(root.left != null)
        {
            left = path(root.left, node);
            if(left.size()>0)
                left.add(root);
            return left;
        }
        else if(root.right != null)
        {
            right = path(root.right, node);
            if(right.size()>0)
                right.add(root);
            return right;
        }
        else
        {
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) 
    {
        int[] post = {4, 5, 2, 6, 7, 3, 1};
        int[] in = {4, 2, 5, 1, 6, 3, 7};
        Node root = construct(post, 0, post.length-1, in, 0, in.length-1);

        int k = 4;
        Node node = root.left.left;
        ArrayList<Node> path = path(root, node.data);

        for(int i = path.size()-1; i>0; i--)
        {   
            if(k-i == 0)    //stay there
            {
                System.out.println(path.get(i).data);
            }
            else if(path.get(i).left.data == path.get(i-1).data)    //go right
            {
                kDown(path.get(i).right, k-i-1);
            }
            else    //go left
            {
                kDown(path.get(i).left, k-i-1);
            }
        }
        kDown(path.get(0), k);
    }
}