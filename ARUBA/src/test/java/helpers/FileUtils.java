package helpers;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {



    public static void cleanFolder(String path) {
        try {
            org.apache.commons.io.FileUtils.cleanDirectory(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFolder(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            System.out.println("creating directory: " + dir.getName());
            boolean result = false;

            try {
                dir.mkdir();
                result = true;
            } catch (SecurityException se) {
                //handle it
            }
            if (result) {
                System.out.println("DIR created");
            }
        }
    }

    public static String getFileNameContains(String path, String filePartName) {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        AllureAssert.assertTrue((listOfFiles != null ? listOfFiles.length : 0) > 0, "List of files in " + path + " = 0");
        for (File file : listOfFiles) {
            if (file.getName().contains(filePartName)) {
                    return file.getName();
            }
        }
        return null;
    }

    public static CSVParser parseCSV(String filePath) {
        Reader reader;
        try {
            reader = Files.newBufferedReader(Paths.get(filePath), Charset.forName("windows-1251"));
            return new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    return null;
    }

}
