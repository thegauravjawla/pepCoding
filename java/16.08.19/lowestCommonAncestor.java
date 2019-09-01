import java.util.*;
public class lowestCommonAncestor
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

    static boolean isPresent(Node root, int x)
    {
        boolean ans = false;
        if(root.data == x)  return true;

        for(int i = 0; i < root.child.size(); i++)
        {
            ans = isPresent(root.child.get(i), x);
            if(ans == true) return true;
        }
        return ans;
    }

    static int lca(Node root, int a, int b)
    {
        int count = 0;
        for(int i = 0; i < root.child.size(); i++)
        {
            int localCount = 0;
            if(isPresent(root.child.get(i), a))
            {
                localCount++;
            }
            if(isPresent(root.child.get(i), b))
            {
                localCount++;
            }
            if(localCount==2)
            {
                return lca(root.child.get(i), a, b);
            }
            else if(localCount==1)
            {
                count++;
            }
        }
        if(count == 2)
        {
            return root.data;
        }
        else if(count == 1)
        {
            if(root.data == a)
            {
                return a;
            }
            else if(root.data == b)
            {
                return b;
            }
            else 
            {
                return -1;
            }
        }
        else
        {
            return -1;
        }
    }
    public static void main(String[] args) 
    {
        int[] treeArray = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = constructor(treeArray);

        int ans = lca(root, 70, 120);
        System.out.println(ans);
    }
}