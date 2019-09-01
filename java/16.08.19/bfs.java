import java.util.*;
public class bfs
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

    //in one line
    static void printBfs(Node root)
    {
        LinkedList <Node> queue = new LinkedList<>();
        queue.addLast(root);
        while(queue.size() > 0)
        {
            Node toRemove = queue.removeFirst();

            System.out.print(toRemove.data + " ");

            for(Node child: toRemove.child)
            {
                queue.addLast(child);
            }
        }
        System.out.println();
        System.out.println("//////////////////");
    }

    //with enters
    static void printBfs2(Node root)
    {
        LinkedList <Node> q1 = new LinkedList<>();
        LinkedList <Node> q2 = new LinkedList<>();

        q1.addLast(root);
        while(q1.size() > 0)
        {
            Node toRemove = q1.removeFirst();
            System.out.print(toRemove.data + " ");

            for(Node child: toRemove.child)
            {
                q2.addLast(child);
            }
            if(q1.size() == 0)
            {
                LinkedList <Node> temp = q1;
                q1 = q2;
                q2 = temp;
                System.out.println();
            }
        }
        System.out.println("//////////////////");
    }

    //zigzag
    static void printBfs3(Node root)
    {
        
    }

    public static void main(String[] args) 
    {
        int[] treeArray = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = constructor(treeArray);
        printBfs(root);
        printBfs2(root);
        printBfs3(root);
    }
}