import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        for (int len : course) {
            map.put(len, new HashMap<>());
        }

        for (String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            for (int len : course) {
                if (arr.length < len) continue;
                dfs(arr, len, 0, new StringBuilder(), map.get(len));
            }
        }

        for (Integer len : map.keySet()) {
            int max = 2;
            for (String s : map.get(len).keySet()) {
                max = Math.max(max, map.get(len).get(s));
            }

            for (String s : map.get(len).keySet()) {
                if (map.get(len).get(s) == max) {
                    result.add(s);
                }
            }
        }

        Collections.sort(result);

        return result.toArray(new String[0]);
    }
    
    public static void dfs(char[] arr, int len, int idx, StringBuilder sb, Map<String, Integer> map) {
        if (sb.length() == len) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            sb.append(arr[i]);
            dfs(arr, len, i + 1, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}