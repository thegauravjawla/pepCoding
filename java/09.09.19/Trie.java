import java.util.*;
public class Trie{

    public static class Node{
        char data;
        HashMap<Character, Node> children;
        boolean end;

        Node(char data){
            this.data = data;
            this.children = new HashMap<>();
            this.end = false;
        }
    }

    public static void add(Node node, String word){
        if(word.length() == 0){
            node.end = true;
            return;
        }
        char ch = word.charAt(0);
        String rest = word.substring(1);
        Node child = node.children.get(ch);

        if(child == null){
            child = new Node(ch);
            node.children.put(ch, child);
        }
        add(child, rest);
    }

    public static boolean search(Node node, String word){
        if(word.length() == 0){
            return node.end;
        }
        char ch = word.charAt(0);
        String rest = word.substring(1);
        Node child = node.children.get(ch);

        if(child == null){
            return false;
        }
        else{
            return search(child, rest);
        }
    }

    public static void remove(Node node, String word){
        if(word.length() == 0){
            node.end = false;
            return;
        }
        char ch = word.charAt(0);
        String rest = word.substring(1);
        Node child = node.children.get(ch);

        //if word does not even exist
        if(child == null){
            return;
        }

        remove(child, rest);
        if(child.end == false && child.children.size() == 0){
            node.children.remove(ch);
        }
    }

    public static void displayAllWords(Node node, String ans){
        if(node.end == true){
            System.out.println(ans);
        }
        if(node.children.size() == 0){
            return;
        }
        for(char key: node.children.keySet()){
            ans+=key;
            displayAllWords(node.children.get(key), ans);
            ans = ans.substring(0, ans.length()-1);
        }
    }

    public static void displayTree(Node node){
        System.out.print(node.data + "-> ");
        for(char key: node.children.keySet()){
            Node child = node.children.get(key);
            if(child.end)
                System.out.print("*");
            System.out.print(key+" ");
        }
        System.out.println(".");

        for(char key: node.children.keySet()){
            Node child = node.children.get(key);
            displayTree(child);
        }
    }

    public static void main(String[] args) {
        Node root = new Node('$');
        add(root, "ask");
        add(root, "as");
        add(root, "art");
        add(root, "seen");
        add(root, "see");
        add(root, "sea");
        add(root, "ant");
        add(root, "an");
        add(root, "and");
        add(root, "are");

        remove(root, "are");
        remove(root, "art");
        System.out.println(search(root, "ask"));
        displayAllWords(root, "");
        displayTree(root);
    }
}