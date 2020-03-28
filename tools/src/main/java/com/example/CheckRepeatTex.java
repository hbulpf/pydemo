package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by liwentian on 2017/9/22.
 */

public class CheckRepeatTex {

    private static HashMap<String, Detail> mMap = new HashMap<>();

    private static class Detail {
        String title;
        String path;
        int line;

        Detail(String title, String path, int line) {
            this.title = title;
            this.path = path;
            this.line = line;
        }

        @Override
        public String toString() {
            return "Detail{" +
                    "title='" + title + '\'' +
                    ", path='" + path + '\'' +
                    ", line=" + line +
                    '}';
        }
    }

    public static void check(String title) throws IOException {
        makeMap();

        if (title.isEmpty()) {
            return;
        }

        List<Detail> details = new LinkedList<>();
        for (Map.Entry<String, Detail> entry : mMap.entrySet()) {
            String key = entry.getKey();
            if (key.equals(title) || key.contains(title)) {
                details.add(entry.getValue());
            }
        }

        System.out.println(String.format("Check Result for (%s): ", title));
        for (Detail detail : details) {
            System.out.println(">>> " + detail);
        }
    }

    private static void makeMap() throws IOException {
        File dir = new File("ebook");
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                scanDir(file);
            }
        }
    }

    public static void scanDir(File dir) throws IOException {
        String name = dir.getName();
        name = String.format("%c%s.tex", Character.toUpperCase(name.charAt(0)), name.substring(1));
        File file = new File(dir, name);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String s;
        int line = 0;
        while ((s = reader.readLine()) != null) {
            line++;
            if (s.contains("%%%%%%%%%%%%%%%%%%%%%%")) {
                String title = s.substring(s.indexOf('{') + 1, s.indexOf('}'));
                if (mMap.containsKey(title)) {
                    System.out.println(String.format("Warning for %s: already exist in %s, current %s", title, mMap.get(title), file.getPath()));
                }
                mMap.put(title, new Detail(title, file.getPath(), line));
            }
        }
    }
}
