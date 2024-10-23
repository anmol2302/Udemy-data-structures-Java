package tree;

public class BST {

    Node root;

    class Node {

        Node right;
        Node left;
        int value;

        public Node(int value) {
            this.value = value;
        }

    }


    public boolean insertNode(int value) {

        if (root == null) {
            root = new Node(value);
            return true;
        }

        Node temp = root;
        Node newNode = new Node(value);
        while (true) {

            if (value == root.value) return false;
            else if (value > root.value) {

                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            } else {

                if (temp.left == null) {
                    temp.left = newNode;
                    return true;

                }
                temp = temp.left;
            }


        }


    }

    public Node rInsert(Node currentNode, int value) {

        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (currentNode == null) {
            return new Node(value);
        } else if (currentNode.value > value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else {
            currentNode.right = rInsert(currentNode.right, value);
        }

        return currentNode;

    }

    public boolean contains(int value) {

        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            if (temp.value == value) return true;
            else if (temp.value < value) temp = temp.right;
            else temp = temp.left;
        }

        return false;

    }

    public boolean rContains(Node currentNode, int value) {
        if (currentNode == null) return false;

        Node temp = currentNode;
        if (currentNode.value == value) return true;
        else if (value > temp.value) return rContains(temp.right, value);
        else return rContains(temp.left, value);
    }

    public int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }


    public Node rDeleteNode(Node currentNode, int value) {
        if (currentNode == null) return null;

        if (value > currentNode.value) {
            currentNode.right = rDeleteNode(currentNode.right, value);
        } else if (value < currentNode.value) {
            currentNode.left = rDeleteNode(currentNode.left, value);
        } else {

            if (currentNode.left == null && currentNode.right == null) {
                return null;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;

            } else if (currentNode.left == null) {
                currentNode = currentNode.right;

            } else {
                int minSubTree = minValue(currentNode.right);
                currentNode.value = minSubTree;
                currentNode.right = rDeleteNode(currentNode.right, minSubTree);
            }
        }
        return currentNode;
    }

    void printTreeRec(Node root, int space) {
        if (root == null) {
            return;
        }

        // Increase distance between levels
        space += 5;

        // Process right child first
        printTreeRec(root.right, space);

        // Print the current node after space
        System.out.print("\n");
        for (int i = 5; i < space; i++) {
            System.out.print(" ");
        }
        System.out.print(root.value);

        // Process left child
        printTreeRec(root.left, space);
    }


    public static void main(String[] args) {

        BST myBST = new BST();

        myBST.rInsert(myBST.root, 33);
        myBST.rInsert(myBST.root, 34);
        myBST.rInsert(myBST.root, 35);
        myBST.rInsert(myBST.root, 36);
        myBST.rInsert(myBST.root, 37);
        myBST.rInsert(myBST.root, 20);
        System.out.println(myBST.rContains(myBST.root, 33));
        System.out.println(myBST.rContains(myBST.root, 37));
        System.out.println(myBST.minValue(myBST.root));
        myBST.printTreeRec(myBST.root, 0);




    }


}
