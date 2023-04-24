package leetcode.sliding-window;

public class SlidingWindow {

  // Medium
  // 3. Longest Substring Without Repeating Characters
  public int lengthOfLongestSubstring(String s) {
    int output = 0;

    int n = s.length();
    int[] chars = new int[128];

    
    int lp = 0;
    for(int rp = 0; rp < n; rp++) {
      lp = Math.max(chars[s.charAt(rp)], lp); 
      output = Math.max(output, rp - lp + 1);
      chars[s.charAt(rp)] = rp + 1;  
    }
    

    // O(n)
    return output;
  }

  // Hard
  // 30. Substring with Concatenation of All Words
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> output = new ArrayList<>();
    Map<String, Integer> keyValue = new HashMap<>();

    if (s == "" || words.length == 0) return output;
    
    for (String word: words) 
        keyValue.put(word, keyValue.getOrDefault(word, 0) + 1);


    int arrSize = words.length;
    int wordLength = words[0].length();
    
    for (int lp=0; lp<=s.length() - arrSize * wordLength; lp++) {
        Map<String, Integer> wordsSeen = new HashMap<>();
        
        for (int rp=0; rp<arrSize; rp++) {
            int nextWordIndex = lp + rp * wordLength;
            String window = s.substring(nextWordIndex, nextWordIndex + wordLength);
            
            if (!keyValue.containsKey(window)) 
              break;

            wordsSeen.put(window, wordsSeen.getOrDefault(window, 0) + 1);
            
            if (wordsSeen.get(window) > keyValue.getOrDefault(window, 0)) 
              break;

            if (rp + 1 == arrSize) 
              output.add(lp);
        }
    }
    
    return output;
    
  }


}
