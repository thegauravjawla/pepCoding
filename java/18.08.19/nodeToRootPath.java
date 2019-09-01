import java.util.*;

public class nodeToRootPath
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

    static ArrayList<Integer> getPath(Node root, int data)
    {
        if(root.data == data)
        {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(root.data);
            return path;
        }

        if(root.left!=null)
        {
            ArrayList<Integer> pathTillNow = getPath(root.left, data);
            if(pathTillNow.size() > 0)
            {
                pathTillNow.add(root.data);
                return pathTillNow;
            }
        }
        if(root.right!=null)
        {
            ArrayList<Integer> pathTillNow = getPath(root.right, data);
            if(pathTillNow.size() > 0)
            {
                pathTillNow.add(root.data);
                return pathTillNow;
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) 
    {
        int[] a = {50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1};
        Node root = construct(a);
        
        int data = 40;
        ArrayList<Integer> ans = getPath(root, data);
        System.out.println(ans);
    }
}