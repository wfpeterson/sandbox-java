package com.kinetix.sandbox.java.strings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
public class Main{

    // traverse the Huffman Tree and store Huffman Codes in a map.
    public static void encode(com.kinetix.sandbox.java.strings.Node root, String str, Map<Character, String> huffmanCode)
    {
        if (root == null)
            return;

        // found a leaf node
        if (root.left == null && root.right == null) {
            huffmanCode.put(root.ch, str);
        }

        encode(root.left, str + '0', huffmanCode);
        encode(root.right, str + '1', huffmanCode);
    }

    // traverse the Huffman Tree and decode the encoded string
    public static int decode(com.kinetix.sandbox.java.strings.Node root, int index, StringBuilder sb)
    {
        if (root == null)
            return index;

        // found a leaf node
        if (root.left == null && root.right == null)
        {
            System.out.print(root.ch);
            return index;
        }

        index++;

        if (sb.charAt(index) == '0')
            index = decode(root.left, index, sb);
        else
            index = decode(root.right, index, sb);

        return index;
    }

    // Builds Huffman Tree and huffmanCode and decode given input text
    public static void buildHuffmanTree(String text)
    {
        // count frequency of appearance of each character
        // and store it in a map
        Map<Character, Integer> freq = new HashMap<>();
        for (char c: text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Create a priority queue to store live nodes of Huffman tree
        // Notice that highest priority item has lowest frequency
        PriorityQueue<com.kinetix.sandbox.java.strings.Node> pq;
        pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.freq));

        // Create a leaf node for each character and add it
        // to the priority queue.
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.add(new com.kinetix.sandbox.java.strings.Node(entry.getKey(), entry.getValue()));
        }

        // do till there is more than one node in the queue
        while (pq.size() != 1)
        {
            // Remove the two nodes of highest priority
            // (lowest frequency) from the queue
            com.kinetix.sandbox.java.strings.Node left = pq.poll();
            com.kinetix.sandbox.java.strings.Node right = pq.poll();

            // Create a new internal node with these two nodes as children
            // and with frequency equal to the sum of the two nodes
            // frequencies. Add the new node to the priority queue.
            int sum = left.freq + right.freq;
            pq.add(new com.kinetix.sandbox.java.strings.Node('\0', sum, left, right));
        }

        // root stores pointer to root of Huffman Tree
        com.kinetix.sandbox.java.strings.Node root = pq.peek();

        // traverse the Huffman tree and store the Huffman codes in a map
        Map<Character, String> huffmanCode = new HashMap<>();
        encode(root, "", huffmanCode);

        // print the Huffman codes
        System.out.println("Huffman Codes are : " + huffmanCode);
        System.out.println("Original string was : " + text);

        // print encoded string
        StringBuilder sb = new StringBuilder();
        for (char c: text.toCharArray()) {
            sb.append(huffmanCode.get(c));
        }
        System.out.println("Encoded string is : " + sb);

        // traverse the Huffman Tree again and this time
        // decode the encoded string
        int index = -1;
        System.out.print("Decoded string is: ");
        while (index < sb.length() - 2) {
            index = decode(root, index, sb);
        }
    }

    public static void main(String[] args)
    {
        String text = "CM|2|1.26.564456725807975.314859.98972835.1.5.4.7.9.2.2.33.54673.128";

        buildHuffmanTree(text);
    }
}
