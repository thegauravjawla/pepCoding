import java.util.*;
public class zigzag
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
        LinkedList<Node> s1 = new LinkedList<>();
        LinkedList<Node> s2 = new LinkedList<>();

        boolean reverse = false;
        s1.addLast(root);
        while(s1.size() > 0)
        {
            /////////////////////
            int size = s1.size();
            while(size-->0)
            {
                Node toRemove = s1.removeLast();
                System.out.print(toRemove.data + " ");

                if(reverse)
                {
                    for(int i = 0; i < toRemove.child.size(); i++)
                    {
                        s2.addLast(toRemove.child.get(i));
                    }
                }
                else
                {
                    for(int i = toRemove.child.size()-1; i>=0; i--)
                    {
                        s2.addLast(toRemove.child.get(i));
                    }
                }
            }
            if(s1.size() == 0)
            {
                LinkedList<Node> temp = s1;
                s1 = s2;
                s2 = temp;

                System.out.println();

                reverse = !reverse;
            }
            ///////////////////////

            //////////////////////
            //without second while
            // if(reverse)
            // {
            //     for(int i = 0; i < toRemove.child.size(); i++)
            //     {
            //         s2.addLast(toRemove.child.get(i));
            //     }
            // }
            // else
            // {
            //     for(int i = toRemove.child.size()-1; i>=0; i--)
            //     {
            //         s2.addLast(toRemove.child.get(i));
            //     }
            // }

            // if(s1.size() == 0)
            // {
            //     LinkedList<Node> temp = s1;
            //     s1 = s2;
            //     s2 = temp;

            //     System.out.println();

            //     reverse = !reverse;
            // }
            ///////////////////////
        }
    }

    public static void main(String[] args) 
    {
        int[] treeArray = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = constructor(treeArray);
        printBfs(root);
    }
}