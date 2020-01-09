package core;

import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static helpers.FileUtils.parseCSV;

public class SpecialEventsReport {

    private static List<String> data;
    private static List<String> row;


    public static List<String> csvToList(String filePath) {
        data = new ArrayList<>();
        for (CSVRecord csvRecord : Objects.requireNonNull(parseCSV(filePath))) {
            data.add(csvRecord.get("DateTime"));
            data.add(csvRecord.get("Correlation Id"));
            data.add(csvRecord.get("Origin station code"));
            data.add(csvRecord.get("Origin station name"));
            data.add(csvRecord.get("Departure"));
            data.add(csvRecord.get("Departure station code"));
            data.add(csvRecord.get("Departure station name"));
            data.add(csvRecord.get("Arrival"));
            data.add(csvRecord.get("Article"));
        }
        return data;
    }

    public static List<String> getRowWithCorrID(String corrId, String filePath) {
        row = new ArrayList<>();
        for (CSVRecord csvRecord : Objects.requireNonNull(parseCSV(filePath))) {
            if (csvRecord.get("Correlation Id").contains(corrId)) {
                row.add(csvRecord.get("DateTime"));
                row.add(csvRecord.get("Correlation Id"));
                row.add(csvRecord.get("Origin station code"));
                row.add(csvRecord.get("Origin station name"));
                row.add(csvRecord.get("Departure"));
                row.add(csvRecord.get("Departure station code"));
                row.add(csvRecord.get("Departure station name"));
                row.add(csvRecord.get("Arrival"));
                row.add(csvRecord.get("Article"));
                }
            }
        return row;
    }

}
