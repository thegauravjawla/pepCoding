import java.util.*;
public class targetSumNightmare
{
    static class Node
    {
        int data;
        Node left;
        Node right;
    }

    static Node construct(int[] a, int i, int j)
    {
        if(i == j)
        {
            Node root = new Node();
            root.data = a[i];
            return root;
        }
        Node root = new Node();
        root.data = a[(j+i)/2];
        root.left = construct(a, i, ((j+i)/2)-1);
        root.right = construct(a, ((j+i)/2)+1, j);
        return root;
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

    static void dfs(Node root, int target)
    {
        Stack<Pair> i = new Stack<>();
        Stack<Pair> j = new Stack<>();

        Pair p = new Pair(root, 1);
        i.push(p);

        p = new Pair(root, 1);
        j.push(p);

        int iValue = 0;
        int jValue = 0;
        boolean increaseI = true;
        boolean decreaseJ = true;

        while(true)
        {
            while(increaseI && i.size() > 0)
            {
                p.state++;
                p = i.peek();
                if(p.state == 1)
                {
                    if(p.node.left != null)
                    {
                        Pair left = new Pair(p.node.left, 1);
                        i.push(left);
                    }
                }
                else if(p.state == 2)
                {
                    if(p.node.right != null)
                    {
                        Pair right = new Pair(p.node.right, 1);
                        i.push(right);
                    }
                    iValue = p.node.data;
                    break;
                }
                else if(p.state == 3)
                {
                    i.pop();
                }
            }
    
            while(decreaseJ && j.size() > 0)
            {
                p.state++;
                p = j.peek();
                if(p.state == 1)
                {
                    if(p.node.left != null)
                    {
                        Pair right = new Pair(p.node.right, 1);
                        j.push(right);
                    }
                }
                else if(p.state == 2)
                {
                    if(p.node.left != null)
                    {
                        Pair left = new Pair(p.node.left, 1);
                        j.push(left);
                    }
                    jValue = p.node.data;
                    break;
                }
                else if(p.state == 3)
                {
                    j.pop();
                }
            }
    
            if(iValue >= jValue)
            {
                break;
            }
            if(iValue + jValue == target)
            {
                System.out.println(iValue + " + " + jValue);
                increaseI = true;
                decreaseJ = true;
            }
            else if(iValue + jValue > target)
            {
                increaseI = false;
                decreaseJ = true;
            }
            else
            {
                increaseI = true;
                decreaseJ = false;
            }
        }
    }


    public static void main(String[] args) 
    {
        int[] a = {12, 25, 37, 50, 62, 75, 87};
        Node root = construct(a, 0, a.length-1);
        int target = 99;
    
        dfs(root, target);
    }
}