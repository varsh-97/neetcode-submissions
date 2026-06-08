class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> adj = new HashMap<>();
      Map<Character, Integer> inDeg = new HashMap<>();

      for(String str : words) // populate the adj and inDeg
      {
        char[] word = str.toCharArray(); // will split the str to a char array ['h','r','n']
        for(char c : word)
        {
            adj.putIfAbsent(c, new HashSet<>()); // will add the char and an empty set to the map {'h':{}}
            inDeg.putIfAbsent(c, 0); // will add the char and int 0 {'h':0}
        }
      }

      for(int i=0; i<words.length-1; i++) // add edges. We only compare the first 2 words as they are already sorted
      {
        String w1 = words[i];
        String w2 = words[i+1];

        if(w1.length() > w2.length() && w1.startsWith(w2)) return ""; // dict will not have "abc", "ab"

        for(int j=0; j<Math.min(w1.length(), w2.length()); j++) // iterate from 0->min(w1,w2)
        {
            char c1 = w1.charAt(j);
            char c2 = w2.charAt(j);
            if(c1 != c2) // build an edge
            { 
                if(!adj.get(c1).contains(c2)) // if the edge doesn't already exist in the map
                {
                    adj.get(c1).add(c2); // {'n':'f'}
                    inDeg.put(c2, inDeg.get(c2)+1); // {'f': 1}
                }
                break; // very crucial. We break because we only care about the first mis-match. 
            }
        }

      }

      Queue<Character> queue = new LinkedList<>(); // populate the queue
      for(char c : inDeg.keySet())
      {
        if(inDeg.get(c)==0)
        {
            queue.offer(c);
        }
      }
      
      StringBuilder result = new StringBuilder(); // add char to the result
      while(!queue.isEmpty()) // topological sort
      {
        char curr = queue.poll();
        result.append(curr); // "h"

        for(char c : adj.get(curr))
        {
            inDeg.put(c, inDeg.get(c)-1); // reduce inDeg for c
            if(inDeg.get(c)==0) // add it to queue if inDeg == 0
            {
                queue.offer(c);
            }
        }
      }

      if(result.length() != inDeg.size()) return ""; // number of unique char must be same, else there is a cycle
      return result.toString();

    }
}