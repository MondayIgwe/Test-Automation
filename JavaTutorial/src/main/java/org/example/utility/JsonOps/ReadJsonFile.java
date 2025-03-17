package org.example.utility.JsonOps;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

/*
 * This class is responsible for reading the JSON file.
 * Problem statement:
 * 1. Create and Read the JSON file.
 * 2. Parse the JSON file.
 * 3. Return the JSON object.
 * 4. Handle the exception if the file is not found.
 */
public class ReadJsonFile {

    public static Object readJsonFileByFilePath(String filePath, Object o) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read the JSON file
            o = objectMapper.readValue(new File(filePath), o.getClass());
            return o;
        } catch (Exception e) {
            System.out.println("File not found");
        }
        return null;
    }
}
