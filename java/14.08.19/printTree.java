import java.util.*;
public class printTree
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

    static void display(Node node)
    {
        System.out.print(node.data + " -> ");
        for(int i = 0; i < node.child.size(); i++)
        {
            System.out.print(node.child.get(i).data + " ");
        }
        System.out.println();
        for(int i = 0; i < node.child.size(); i++)
        {
            display(node.child.get(i));
        }
    }
    public static void main(String[] args) 
    {
        int[] treeArray = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = constructor(treeArray);

        display(root);
    }
}

// node -> children format