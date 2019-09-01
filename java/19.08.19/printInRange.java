import java.util.*;

public class printInRange
{
    static class Node
    {
        int data;
        Node left;
        Node right;
    }

    static Node construct(int[] a)
    {
        Node root = null;
        Stack<Node> stack = new Stack<>();
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] == -1)
            {
                stack.pop();
            }
            else
            {
                Node node = new Node();
                node.data = a[i];
                if(stack.size() == 0)
                {
                    root = node;
                }
                else
                {
                    if(stack.peek().left == null)
                    {
                        stack.peek().left = node;
                    }
                    else
                    {
                        stack.peek().right = node;
                    }
                }
                stack.push(node);
            }
        }

        return root;
    }

    static void print(Node root, int low, int high, int sum, String ans)
    {
        if(root.left != null)
        {
            print(root.left, low, high, sum + root.data, ans + " " + root.data);
        }
        if(root.right != null)
        {
            print(root.right, low, high, sum + root.data, ans + " " + root.data);
        }
        if(root.left == null && root.right == null)
        {
            if(sum+root.data >= low && sum+root.data <= high)
                System.out.println(ans+ " " + root.data);
        }
    }

    public static void main(String[] args) 
    {
        int[] a = {50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1};
        Node root = construct(a);

        print(root, 150, 250, 0, "");
    }
}