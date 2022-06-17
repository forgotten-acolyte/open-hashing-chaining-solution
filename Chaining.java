


import java.util.ArrayList;
import java.util.List;

public class Chaining {
    /**
     * Open hashing ->  store an array of linked lists
     * Insertion : create and possibly swap nodes
     * Searching :
     *
     * Time complexity:
     *  - Successful searches:
     *     + O(1) for computing hash function
     *     + lambda/ 2
     *     total : 1 + lambda/2
     *  - Unsuccessful searches:
     *     + t = 1 + lambda => searched the entire linked list
     *  Suppose 100 keys with only 10 locations , take n / size => lambda => loading factor
     * func loadingFactor(keys, locations) -> return keys / places => how many keys can a single location store? ( just an expectation )
     */
    private int SIZE = 8;
    private List<SinglyLinkedList> chainedHashTable = new ArrayList<>(SIZE + 1);

    public int hashFunction(int x) {
        return x % 10;
    }

    public void displayHashTable() {
        for (int i = 0, n = chainedHashTable.size(); i < n; i++) {
            System.out.println("index is " + i + ", linked list : ");
            chainedHashTable.get(i).display();
            System.out.println();
        }
    }

    private ListNode constructNewNode(int val) {
        return new ListNode(val);
    }

    private SinglyLinkedList retrieveAndInsertNode(int hashedIndex, int key) {
        ListNode node = constructNewNode(key);
        SinglyLinkedList retrieved = chainedHashTable.get(hashedIndex);
        retrieved.sortedInsert(node);
        return retrieved;
    }

    private void insertIntoHashTable(int key) {
        int hashedIndex = hashFunction(key);
        SinglyLinkedList inserted = retrieveAndInsertNode(hashedIndex, key);
        chainedHashTable.set(hashedIndex, inserted);
    }

    public int getSIZE() {
        return SIZE;
    }

    public List<SinglyLinkedList> getChainedHashTable() {
        return chainedHashTable;
    }

    public void initChainedHashTable() {
        for (int i = 0; i < SIZE; i++) {
            chainedHashTable.add(new SinglyLinkedList());
        }
    }

    public void setSize(int size) {
        SIZE = size;
    }

    private SinglyLinkedList retrieveListForSearching(int hashedIndex) {
        return chainedHashTable.get(hashedIndex);
    }

    public void constructHashTableWithArrayOfKeys(int[] keys) {
        for (int i = 0, n = keys.length; i < n; i++) {
            insertIntoHashTable(keys[i]);
        }
    }

    public void search(int key) {
        int hashedIndex = hashFunction(key);
        retrieveListForSearching(hashedIndex).searchForNode(constructNewNode(key));
    }
}
