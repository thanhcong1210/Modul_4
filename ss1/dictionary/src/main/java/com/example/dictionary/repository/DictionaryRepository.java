package com.example.dictionary.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository{

    static private Map<String, String> dictionary = new HashMap<String, String>();
    static {
        dictionary.put("Hello", "Xin Chào");
        dictionary.put("Bye", "Tạm Biệt");
        dictionary.put("Name", "Tên");
        dictionary.put("Apple", "Quả Táo");
    }

    @Override
    public String translate(String word) {
        if (dictionary.containsKey(word)) {
            return dictionary.get(word);
        }
        return "Không tìm thấy từ này!!!";
    }
}
