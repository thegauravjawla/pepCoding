import java.util.*;
public class niceKindaBFS
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

        while(q.size() > 0)
        {
            int size = q.size();    //total nodes at a perticular level
            while(size-- > 0)       //it adds the children of all the current elements in the queue, which are of the same level
            {
                Node toRemove = q.removeFirst();
                System.out.print(toRemove.data + " ");

                for(Node child: toRemove.child)
                {
                    q.addLast(child);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) 
    {
        int[] treeArray = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = constructor(treeArray);
        printBfs(root);
    }
}