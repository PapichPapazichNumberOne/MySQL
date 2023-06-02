package com.digdes.school;

import java.util.*;

public class Starter {
    public List<Map<String, Object>> list = new ArrayList<>();

    public Starter() {

    }

    public List<Map<String, Object>> execute(String request) {

        switch (readRequest(request)) {

            case "Вставить" -> insertListElement(request);
            case "Обновить" -> updateListElement(request);
            case "Удалить" -> deleteListElement(request);
            case "Выбрать" -> selectListElement(request);
            default -> throw new RuntimeException("Запрос получен.");
        }
        return list;
    }

    private String readRequest(String request) {
        if (request.startsWith("вставить") || request.startsWith("обновить") || request.startsWith("удалить") || request.startsWith("выбрать"))
            ;
        return request.substring(0, 6);
    }

    private void selectListElement(String request) {
    }

    private void deleteListElement(String user_request) {
        user_request = user_request.replaceAll("удаление значения", "");
        user_request = user_request.replaceAll("‘", "");
        user_request = user_request.replaceAll("’", "");

        ArrayList<String> data = new ArrayList<>();

        String[] words = user_request.split("[=, ]");

        for (String word : words) {
            if (!word.isBlank()) {
                data.add(word.trim());
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).containsKey(data.get(0)) && list.get(i).containsValue(data.get(1))) {
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
    }

    private void updateListElement(String user_request) {
        user_request = user_request.replaceAll("Обновление значения", "");
        user_request = user_request.replaceAll("где", "");
        user_request = user_request.replaceAll("‘", "");
        user_request = user_request.replaceAll("’", "");

        ArrayList<String> data = new ArrayList<>();
        String[] words = user_request.split("[=, ]");
        for (String word : words) {
            if (!word.isBlank()) {
                data.add(word.trim());
            }
        }
        String key = data.get(data.size()-1);
        String value = data.get(data.size()-2);
        data.remove(key);
        data.remove(value);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).containsKey(key) && list.get(i).containsValue(value)){
            }
        }
    }
    private void insertListElement(String request) {
        request = request.replaceAll("Вcтавить Значение", "");
        request = request.replaceAll("‘", "");
        request = request.replaceAll("’", "");

        ArrayList<String> data = new ArrayList<>();
        String[] words = request.split("[=, ]");
        for (String word : words) {
            if (!word.isBlank()) {
                data.add(word.trim());
            }
        }
        Map<String, Object> row = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {
            if (i > 7) {
                break;
            }
            if (i == 0) {
                row.put(data.get(0), data.get(1));
            }
            if (i >= 2) {
                row.put(data.get(i), data.get(i + 1));
                i = i + 1;
            }
        }
        list.add(row);
        System.out.println(row);
        System.out.println("Вы добавили в таблицу: " + row);
        System.out.println(list + "лист до удаления");
    }
}