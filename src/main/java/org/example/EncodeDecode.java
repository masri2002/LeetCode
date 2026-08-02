package org.example;

import java.util.*;

public class EncodeDecode {

    private final Map<Character, String> encodeMap = new HashMap<>();
    private final Map<String, Character> decodeMap = new HashMap<>();

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            for (char c : str.toCharArray()) {
                String hex = encodeMap.computeIfAbsent(c, Integer::toHexString);
                decodeMap.putIfAbsent(hex, c);
                sb.append(hex).append(",");
            }
            sb.append("//");
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        String[] words = str.split("//", -1);

        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].isEmpty()) {
                result.add("");
                continue;
            }

            StringBuilder sb = new StringBuilder();
            String[] codes = words[i].split(",", -1);

            for (int j = 0; j < codes.length - 1; j++) {
                sb.append(decodeMap.get(codes[j]));
            }

            result.add(sb.toString());
        }

        return result;
    }

    public static void main(String[] args) {
        EncodeDecode ed = new EncodeDecode();

        String encoded = ed.encode(List.of("ahmad", "ali", ""));
        System.out.println(encoded);
        System.out.println(ed.decode(encoded));
    }
}