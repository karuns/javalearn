class Solution {
    class Node {
        HashMap<Character, Node> children;
        Boolean isWord;
        Node() {
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }

    class WordDictionary {
        Node root;
        WordDictionary() {
            this.root = new Node();
        }

        public void insertWord(String word) {
            char[] cArray = word.toCharArray();
            Node currNode = this.root;
            for(int i = 0; i < cArray.length; i++) {
                char c = cArray[i];
                if(!currNode.children.containsKey(c))
                    currNode.children.put(c, new Node());
                if( i < cArray.length - 1)
                    currNode = currNode.children.get(c);
            }
            currNode.isWord = true;
        }

    }

    public static void main( String args[] ) {
        System.out.println( "Hello World!" );
        String[] keys = {"the", "a", "there", "answer", "any",
                "by", "bye", "their", "abc"};
        System.out.println("Keys to insert: ");
        System.out.println(Arrays.toString(keys));

        WordDictionary d = new WordDictionary();

        for(int i=0; i < keys.length; i++)
            d.insertWord(keys[i]);

        System.out.println("Searching 'there' in the dictionary results: " + d.searchWord("there"));
    }
}