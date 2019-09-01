import java.util.*;
public class nullBFS
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

    static void printBfs(Node root)
    {
        LinkedList<Node> q = new LinkedList<>();
        q.addLast(root);
        q.add(null);

        while(q.size() > 1)
        {
            Node toRemove = q.removeFirst();
            if(toRemove == null)
            {
                System.out.println();
                q.addLast(null);
                continue;
            }

            System.out.print(toRemove.data + " ");
            for(Node child: toRemove.child)
            {
                q.addLast(child);
            }
        }

        // while(q.size() > 1) //1, because at the end null will be there
        // {
        //     if(q.getFirst() == null)
        //     {
        //         System.out.println();
        //         q.removeFirst();
        //         q.addLast(null);
        //     }
        //     else
        //     {
        //         Node toRemove = q.removeFirst();
        //         System.out.print(toRemove.data + " ");
        //         for(Node child: toRemove.child)
        //         {
        //             q.addLast(child);
        //         }
        //     }
        // }
    }

    public static void main(String[] args) 
    {
        int[] treeArray = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = constructor(treeArray);
        printBfs(root);
    }
}