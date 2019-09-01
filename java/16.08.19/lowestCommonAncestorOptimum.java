import java.util.*;
public class lowestCommonAncestorOptimum
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

    static ArrayList<Node> isPresent(Node root, int x)  //returns the path
    {
        if(root.data == x)
        {
            ArrayList<Node> ans = new ArrayList<>();
            ans.add(root);
            return ans;
        }

        ArrayList<Node> ans = new ArrayList<>();
        for(int i = 0; i < root.child.size(); i++)
        {
            ans = isPresent(root.child.get(i), x);
            if(ans.size() > 0)
            {
                ans.add(root);
                return ans;
            }
        }
        return ans; //returns empty arrayList if not found in any of the branches of the current root
    }

    static int lca(Node root, int a, int b)
    {
        ArrayList<Node> pathA = isPresent(root, a);
        ArrayList<Node> pathB = isPresent(root, b);

        int i = pathA.size()-1, j = pathB.size()-1;
        while(pathA.get(i).data == pathB.get(j).data)
        {
            i--; j--;
            if(i < 0 || j < 0)
            {
                return pathA.get(i+1).data;
            }
        }
        return pathA.get(i+1).data;
    }
    public static void main(String[] args) 
    {
        int[] treeArray = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = constructor(treeArray);

        int ans = lca(root, 20, 10);
        System.out.println(ans);
    }
}