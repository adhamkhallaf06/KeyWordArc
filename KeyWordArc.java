// IDE: VsCode
// Java version: java 17.0.10 2024-01-16 LTS

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class KeyWordArc {
    public static void main(String[] args) {    
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        readFileRecords(bst, "datafile.txt");

        System.out.println("\t\tWelcome to Information Retrieval System");

        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. InOrder Traversal with Details <Output keywords along with their associated referenced articles.>");
            System.out.println("2. InOrder Traversal (Keywords Only) <Output only the keywords, excluding the referenced articles.>");
            System.out.println("3. PreOrder Traversal (Keywords Only) <Output only the keywords in pre-order traversal, without the referenced articles.>");
            System.out.println("4. Search for a specific Keyword <If found, display the keyword with referenced articles; otherwise, output the keyword not found message.>");
            System.out.println("5. Exit <Terminates the program.>");
            System.out.print("\nEnter a choice: ");
            choice = input.nextInt();
            input.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    bst.inOrderWithDetails();
                    break;
                case 2:
                    bst.inOrderKeywordsOnly();
                    break;
                case 3:
                    bst.preOrderKeywordsOnly();
                    break;
                case 4:
                    System.out.print("Enter the keyword to search: ");
                    String keyword = input.nextLine();
                    bst.searchKeyword(keyword);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    public static void readFileRecords(BinarySearchTree<String> bst, String filename) {
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = fileReader.readLine()) != null) {
                int id = Integer.parseInt(line);
                String title = fileReader.readLine();
                String author = fileReader.readLine();
                int numKeys = Integer.parseInt(fileReader.readLine());

                for (int i = 0; i < numKeys; i++) {
                    String keyword = fileReader.readLine();
                    Article art = new Article(id, title, author);
                    bst.insert(keyword, art);
                }
                fileReader.readLine(); // consume blank line
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class BinarySearchTree<E extends Comparable<E>> {
    protected TreeNode<E> root;
    protected int size;

    public void insert(E element, Article art) {
        if (root == null) {
            root = new TreeNode<>(element);
            root.articles.add(art);
        } else {
            TreeNode<E> parent = searchNode(element);
            if (parent != null) {
                if (element.compareTo(parent.element) < 0) {
                    parent.left = new TreeNode<>(element);
                    parent.left.articles.add(art);
                } else if (element.compareTo(parent.element) > 0) {
                    parent.right = new TreeNode<>(element);
                    parent.right.articles.add(art);
                } else {
                    parent.articles.add(art);
                }
            }
        }
        size++;
    }

    public TreeNode<E> searchNode(E element) {
        TreeNode<E> current = root;
        while (current != null) {
            if (element.compareTo(current.element) < 0) {
                if (current.left == null) return current;
                current = current.left;
            } else if (element.compareTo(current.element) > 0) {
                if (current.right == null) return current;
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    public void inOrderWithDetails() {
        System.out.println("\nIn-Order Traversal with Details:");
        inOrderWithDetails(root);
    }

    private void inOrderWithDetails(TreeNode<E> node) {
        if (node == null) return;
        inOrderWithDetails(node.left);
        System.out.println(node.element + ":");
        for (Article art : node.articles) {
            System.out.println("   " + art);
        }
        inOrderWithDetails(node.right);
    }

    public void inOrderKeywordsOnly() {
        System.out.println("\nIn-Order Traversal (Keywords Only):");
        inOrderKeywordsOnly(root);
    }

    private void inOrderKeywordsOnly(TreeNode<E> node) {
        if (node == null) return;
        inOrderKeywordsOnly(node.left);
        System.out.println(node.element);
        inOrderKeywordsOnly(node.right);
    }

    public void preOrderKeywordsOnly() {
        System.out.println("\nPre-Order Traversal (Keywords Only):");
        preOrderKeywordsOnly(root);
    }

    private void preOrderKeywordsOnly(TreeNode<E> node) {
        if (node == null) return;
        System.out.println(node.element);
        preOrderKeywordsOnly(node.left);
        preOrderKeywordsOnly(node.right);
    }

    public void searchKeyword(E element) {
        TreeNode<E> node = searchNode(element);
        if (node != null && node.element.equals(element)) {
            System.out.println("Keyword found: " + element);
            for (Article art : node.articles) {
                System.out.println("   " + art);
            }
        } else {
            System.out.println("Keyword '" + element + "' not found.");
        }
    }
}

class TreeNode<E> {
    E element;
    TreeNode<E> left;
    TreeNode<E> right;
    LinkedList<Article> articles = new LinkedList<>();

    public TreeNode(E element) {
        this.element = element;
    }
}

class Article {
    private int id;
    private String title;
    private String author;

    public Article(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return id + " | " + title + " | " + author;
    }
}