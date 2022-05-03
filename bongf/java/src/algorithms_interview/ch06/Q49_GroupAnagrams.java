package algorithms_interview.ch06;

import java.util.*;

public class Q49_GroupAnagrams {
    public static void main(String[] args) {
        List<List<String>> lists = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dic = new HashMap<>();
        for (String str : strs) {
            List<Character> characters = new ArrayList<>();
            for (Character s : str.toCharArray()) {
                characters.add(s);
            }
            /* https://codedestine.com/group-anagrams-string-problem/
            이 방법이 훨씬 간단/
              for(String str: strs){
                array = str.toCharArray();
                Arrays.sort(array);
                temp = String.valueOf(array);

                if(map.containsKey(temp)){
                    map.get(temp).add(str);
                }else {
                    list = new ArrayList<>();
                    list.add(str);
                    map.put(temp, list);
                }
        }

             */
            Collections.sort(characters);
            StringBuilder nstr = new StringBuilder();
            for (Character character : characters) {
                nstr.append(character);
            }
            String word = nstr.toString();
            if( dic.containsKey(word)) {
                dic.get(word).add(str);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(str);
                dic.put(word, strings);
            }
        }
        return new ArrayList<>(dic.values());
    }
}
