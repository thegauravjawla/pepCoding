import java.util.*;
public class kthLargest
{
    static class Node
    {
        int data;
        ArrayList<Node> child = new ArrayList<>();

        Node(int data)
        {
            this.data = data;
        }
    }
    static Node constructor(int[] treeArray)
    {
        Node root = null;
        LinkedList<Node> stack = new LinkedList<>();

        for(int i = 0; i < treeArray.length; i++)
        {
            if(treeArray[i] == -1)
            {
                stack.removeFirst();
            }
            else
            {
                Node currentNode = new Node(treeArray[i]);
                if(stack.size() == 0)
                {
                    root = currentNode;
                }
                else
                {
                    stack.getFirst().child.add(currentNode);
                }
                stack.addFirst(currentNode);
            }
        }
        return root;
    }

    public static class Pair
    {
        int max = Integer.MAX_VALUE;    //for kth value thingy
        int min = -1;
        int localMax = -1;
        int localMin = Integer.MAX_VALUE;
    }

    static void get(Node root, Pair pair)
    {
        if(pair.max > root.data && root.data > pair.localMax)
        {
            pair.localMax = root.data;
        }

        if(pair.min < root.data && root.data < pair.localMin)
        {
            pair.localMin = root.data;
        }
        for(int i = 0; i < root.child.size(); i++)
        {
            get(root.child.get(i), pair);
        }
    }
    public static void main(String[] args) 
    {
        int[] treeArray = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = constructor(treeArray);

        Pair pair = new Pair();
        int k = 5;
        for(int i = 1; i <= k; i++)
        {
            get(root, pair);
            pair.max = pair.localMax;
            pair.localMax = -1;

            pair.min = pair.localMin;
            pair.localMin = Integer.MAX_VALUE;
        }
        System.out.println(k + "th min = " + pair.min + " " + k + "th max = " + pair.max);
    }
}