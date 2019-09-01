import java.util.*;
public class ceilingFloor
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
        int ceiling = Integer.MAX_VALUE;
        int floor = -1;
    }

    static void cf(Node root, Pair pair, int data)
    {
        if(root.data > data && root.data < pair.ceiling)
        {
            pair.ceiling = root.data;
        }
        if(root.data < data && root.data > pair.floor)
        {
            pair.floor = root.data;
        }
        for(int i = 0; i < root.child.size(); i++)
        {
            cf(root.child.get(i), pair, data);
        }
    }
    public static void main(String[] args) 
    {
        int[] treeArray = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = constructor(treeArray);

        Pair pair = new Pair();
        cf(root, pair, 65);
        System.out.println("F = "+ pair.floor +" C = " + pair.ceiling);
    }
}