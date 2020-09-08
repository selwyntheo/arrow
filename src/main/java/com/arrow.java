package com;

import com.model.Custody;
import com.model.Holding;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class arrow {

    public static void main(String[] args) throws IOException {
        String holdingFileName = "src/main/resources/holdings.csv";
        String custodyFileName = "src/main/resources/custody.csv";

        Path holdingFilePath = Paths.get(holdingFileName);
        Path custodyFilePath = Paths.get(custodyFileName);

        // Read file using the Stream API
        try (Stream<String> lines = Files.lines(custodyFilePath);) {
            lines.filter(line -> !line.startsWith("#"))
                    .flatMap(arrow::lineToPosition)
                    .forEach(System.out::println);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // Read the file using the BufferedReader and map it to Holding Object using OpenCSV
        try (BufferedReader br = Files.newBufferedReader(holdingFilePath,
                StandardCharsets.UTF_8)) {

            HeaderColumnNameMappingStrategy<Holding> strategy
                    = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(Holding.class);

            CsvToBean<Holding> csvToBean = new CsvToBeanBuilder<Holding>(br)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Holding> holdings = csvToBean.parse();

            // Streams based processing to match a specific security - 30231G102

            holdings.stream()
                    .filter(left -> left.getSecurityId().equals("30231G102"))
                    .forEach(System.out::println);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }


    private static Stream<Custody> lineToPosition (String line){
        try {
            String[] elements = line.split(",");
            String securityId = elements[0];
            String securityIdType = elements[1];
            int quantity = Integer.parseInt(elements[2]);
            float price = Float.parseFloat(elements[3]);
            float marketValueBase = Float.parseFloat(elements[4]);
            float marketValueLocal = Float.parseFloat(elements[5]);

            String broker = elements[6];
            String currency = elements[7];
            String effectiveDate = elements[8];
            String fundId = elements[9];

            Custody p = new Custody(securityId, securityIdType, quantity, price, marketValueBase, marketValueLocal, broker, currency, effectiveDate, fundId);
            return Stream.of(p);
        } catch (Exception e) {

        }
        return Stream.empty();
    }
}





