import java.util.*;
public class preorderPredecessor
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

    public static class Status
    {
        boolean found = false;
        int predecessor = -1;
        int successor = -1;

        int previous = -1;
    }

    static void getInfo(Node root, int data, Status statusOfData)
    {
        if(root.data == data)
        {
            statusOfData.found = true;
            statusOfData.predecessor = statusOfData.previous;
        }
        else if(data == statusOfData.previous)
        {
            statusOfData.successor = root.data;
        }

        statusOfData.previous = root.data;
        for(int i = 0; i < root.child.size(); i++)
        {
            getInfo(root.child.get(i), data, statusOfData);
        }
    }

    public static void main(String[] args) 
    {
        int[] treeArray = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = constructor(treeArray);

        //finding info of preOrder successor and predecessor
        int data = 80;
        Status statusOfData = new Status(); //contains all info about data

        getInfo(root, data, statusOfData);

        System.out.println(statusOfData.predecessor + " - " + data + " - " + statusOfData.successor);
    }
}