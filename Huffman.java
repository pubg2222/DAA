import java.util.*;
class HuffmanNode{
    int item;
    char ch;
    HuffmanNode left;
    HuffmanNode right;
}
class CompareNode implements Comparator<HuffmanNode>{
    public int compare(HuffmanNode a, HuffmanNode b){
        return a.item - b.item;
    }
}
public class Huffman {
    static int lengthOfEncodedMsg = 0;
    static int lengthOfMappedBits = 0;
    public static void printNode(HuffmanNode root, String s, Map<Character, Integer>map){
        if(root.left == null && root.right == null && Character.isLetter(root.ch)){
            System.out.println(root.ch + " | " + s);
            lengthOfEncodedMsg +=(s.length()*map.get(root.ch));
            lengthOfMappedBits += s.length();
            return;
        }
        printNode(root.left, s+"0", map);
        printNode(root.right, s+"1", map);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer>map = new HashMap<Character, Integer>();
        System.out.println("Enter the string");
        String inputstr="";
        inputstr = sc.next();
        sc.close();
        // Map<Character, Integer>map = new HashMap<>();
        for(int i=0;i<inputstr.length(); i++){
            if(!map.containsKey(inputstr.charAt(i))) map.put(inputstr.charAt(i), 1);
            else map.put(inputstr.charAt(i), map.get(inputstr.charAt(i))+1);
        }
        
        int totalFreq = 0;
        for(int a : map.values()) totalFreq += a;
        PriorityQueue<HuffmanNode>q = new PriorityQueue<>(new CompareNode());
        for(char c : map.keySet()){
            HuffmanNode h = new HuffmanNode();
            h.item = map.get(c);
            h.ch = c;
            h.left = null;
            h.right = null;
            q.add(h);
        }
        HuffmanNode root = new HuffmanNode();
        while(q.size()>1){
            HuffmanNode first = q.peek();
            q.poll();
            HuffmanNode second = q.peek();
            q.poll();
            HuffmanNode up = new HuffmanNode();
            up.item = first.item + second.item;
            up.ch = '-';
            up.left = first;
            up.right = second;
            root = up;
            q.add(up);
        }
        printNode(root, "", map);
        System.out.println("Length before encoding " + totalFreq*8);
        System.out.println("Length after encoding " + (lengthOfEncodedMsg + lengthOfMappedBits + map.size()*8));  
    }
}
