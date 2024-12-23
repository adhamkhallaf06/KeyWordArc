# KeyWordArc: Intelligent Information Retrieval System

### Project Overview

KeyWordArc is an information retrieval system designed to efficiently store, organize, and retrieve keywords and their associated articles. The system uses a Binary Search Tree (BST) to store keywords, linking them to articles through a linked list structure. This project supports features such as in-order and pre-order traversal, detailed article viewing, and keyword search.

---

### Components Used:

* **Java Programming Language**: Used to implement the system.
* **Binary Search Tree (BST)**: Manages and organizes keywords efficiently.
* **Linked Lists**: Stores and links articles to their respective keywords.
* **File Handling**: Reads data from a text file containing article information.

---

### Data Structure Design:

The system utilizes a **Binary Search Tree (BST)**, where each node represents a keyword, and a linked list stores articles associated with the keyword.

TreeNode Diagram
<img width="502" alt="image" src="https://github.com/user-attachments/assets/74c4fdf1-d3f3-4681-b929-06b5bedf8b88" />

---

### Workflow:

1. Loop through the data file.
2. Read articles and keywords.
3. Create `Article` objects using the ID, title, and author.
4. Search for the keyword in the Binary Search Tree (BST).
5. If the keyword does not exist, create a new `TreeNode` and link the article to it.
6. If the keyword exists, associate the article with the existing node.

Workflow Diagram
<img width="871" alt="Screenshot%202024-12-23%20at%203 30 32%E2%80%AFPM" src="https://github.com/user-attachments/assets/682897ee-4860-4530-ac3d-7f90733d45b6" />

---

### Features:

* **In-Order Traversal with Details**: Displays keywords along with their associated articles.
* **Keyword-Only Traversals**: Allows users to view only keywords in in-order or pre-order sequence.
* **Keyword Search**: Retrieves articles associated with a specific keyword or outputs an error if the keyword is not found.
* **Scalability**: Efficiently handles large datasets using Binary Search Tree operations.

---

### How It Works:

* Reads data from a file (`datafile.txt`) containing articles and their associated keywords.
* Stores keywords in a Binary Search Tree (BST), linking each to a list of articles.
* Provides a user interface to perform traversals, searches, and view article details.
* Handles input errors gracefully and ensures seamless program execution.

---

### Applications:

KeyWordArc is ideal for:
* Managing academic repositories.
* Indexing content for digital libraries.
* Organizing large-scale keyword-based datasets.

---
