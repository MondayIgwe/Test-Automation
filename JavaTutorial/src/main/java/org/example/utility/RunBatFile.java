package org.example.utility;

import java.io.IOException;

import static org.example.utility.CommonUtils.BAT_FILE_PATH;

public class RunBatFile {
    public static void execute() {
        try {
            // Specify the path to your batch file
            String batFilePath = BAT_FILE_PATH;
            // Run the batch file
            Process process = Runtime.getRuntime().exec(batFilePath);
            process.waitFor();
            process.getOutputStream().flush();
            System.out.println("Batch file executed successfully." + process.toString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}