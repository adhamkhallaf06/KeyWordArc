# KeyWordArc: Intelligent Information Retrieval System

KeyWordArc is an efficient information retrieval system designed to store, organize, and retrieve keywords and their associated articles. The system leverages a Binary Search Tree (BST) for seamless data management and ensures optimal performance when handling large datasets.

---

## Features
- **Efficient Data Management**: Organizes keywords dynamically using a Binary Search Tree for quick and reliable access.
- **User-Friendly Interface**: Provides traversal modes (in-order and pre-order) and intelligent search functionality to simplify access to stored information.
- **Scalable and High-Performance**: Built using Java with robust file-handling mechanisms to support large datasets and ensure reliability.

---

## System Design
### **Data Structure Overview**
The system utilizes a **Binary Search Tree** (BST) to organize keywords and associates each keyword with a linked list of articles. This structure ensures efficient insertion, traversal, and search operations.

Data Structure Diagram
(https://files.oaiusercontent.com/file-PC9Aswdgp261hzb6oPEeNC?se=2024-12-23T21%3A35%3A37Z&sp=r&sv=2024-08-04&sr=b&rscc=max-age%3D299%2C%20immutable%2C%20private&rscd=attachment%3B%20filename%3Dimage.png&sig=NxrjTDXDLfCwdQMPkjLWFkctQSN7dUliwJLo%2BAUyDA0%3D)![image](https://github.com/user-attachments/assets/58b1880f-b9c8-4709-9a6b-0f38882643ed)

### **Workflow**
The following steps outline the process of loading and managing the data:
1. Loop through the data file.
2. Read articles and keywords.
3. Create `Article` objects using the ID, title, and author.
4. Search for the keyword in the Binary Search Tree (BST).
5. If the keyword does not exist in the BST, create a `TreeNode` object and insert it into the tree.
6. Associate the article with the corresponding `TreeNode`.

Workflow Diagram
[image](https://github.com/user-attachments/assets/2242a61a-84e3-476a-8856-eb031af22ce5)](https://files.oaiusercontent.com/file-XUE2pWNA1CCc3upHTaLr34?se=2024-12-23T21%3A35%3A37Z&sp=r&sv=2024-08-04&sr=b&rscc=max-age%3D299%2C%20immutable%2C%20private&rscd=attachment%3B%20filename%3DScreenshot%25202024-12-23%2520at%25203.30.32%25E2%2580%25AFPM.png&sig=V3luXswiCbKRuLLpBDLytk7H199gu6vb8GkypLUJ2kc%3D)



---

## How It Works
1. **Data Loading**: Reads article metadata (ID, title, author, and keywords) from a file (`datafile.txt`) and indexes the keywords in a Binary Search Tree.
2. **Keyword Management**: Links each keyword to its associated articles for structured retrieval.
3. **User Interaction**: Offers menu-driven options for keyword traversal, article details retrieval, and targeted keyword search.

---

## Technologies Used
- **Programming Language**: Java (Version 17.0.10 LTS)
- **Data Structures**: Binary Search Tree (BST) and Linked Lists
- **File I/O**: Java FileReader and BufferedReader
- **User Interface**: Console-based interaction with menu-driven options

---

## Applications
KeyWordArc is ideal for:
- Managing academic repositories
- Indexing digital library content
- Handling large-scale keyword-based datasets

---

Feel free to explore, modify, and extend KeyWordArc for your own data management needs!
