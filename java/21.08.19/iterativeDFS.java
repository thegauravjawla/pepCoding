import java.util.*;

public class iterativeDFS
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

    public static class Pair
    {
        Node node;
        int state;

        Pair(Node node, int state)
        {
            this.node = node;
            this.state = state;
        }
    }

    static void dfs(Node root)
    {
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();

        Stack<Pair> s = new Stack<>();
        Pair p = new Pair(root, 1);
        s.push(p);

        while(s.size() > 0)
        {
            p = s.peek();
            if(p.state == 1)
            {
                pre.add(p.node.data);
                if(p.node.left != null)
                {
                    Pair left = new Pair(p.node.left, 1);
                    s.push(left);
                }
            }
            else if(p.state == 2)
            {
                in.add(p.node.data);
                if(p.node.right != null)
                {
                    Pair right = new Pair(p.node.right, 1);
                    s.push(right);
                }
            }
            else if(p.state == 3)
            {
                post.add(p.node.data);
                s.pop();
            }

            p.state++;
        }

        System.out.println("Pre = " + pre);
        System.out.println("In = " + in);
        System.out.println("Post = " + post);
    }

    public static void main(String[] args) 
    {
        int[] post = {12, 30, 37, 25, 70, 62, 87, 75, 50};
        int[] in = {12, 25, 30, 37, 50, 62, 70, 75, 87};
        Node root = construct(post, 0, post.length-1, in, 0, in.length-1);

        dfs(root);
    }
}