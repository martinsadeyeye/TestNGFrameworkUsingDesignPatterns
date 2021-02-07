package org.martinscademy.Dataloads;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {

    //https://www.techiedelight.com/read-file-contents-with-apache-commons-io-library-java/
    // Read every array of json in the file, Load the index into the Hasp Map
    // instead of adding directly into the test class
    // using jackson library ( core and databind) using object Mapper class
    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {

/*
        // Here we create an instance of File for sample.txt file.
        File file = new File("sample.txt");

        try {
            // Read the entire contents of sample.txt
            String content = FileUtils.readFileToString(file, "UTF-8");
            System.out.println("File content: " + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        // Convert the Json File to Json String
        String jsonContent = FileUtils.readFileToString(new File("reservationDetails.json"), StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        List<HashMap<String, String>> data = objectMapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });

        return data;
    }
}
