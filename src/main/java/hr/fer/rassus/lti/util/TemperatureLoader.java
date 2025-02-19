package hr.fer.rassus.lti.util;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class TemperatureLoader {
    private static final String PATH = "/measurements.csv";
    private List<Integer> temperatures;

    public TemperatureLoader() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(PATH)))) {
            temperatures = csvToBean(reader)
                                .parse()
                                .stream()
                                .map(TemperatureHolder::getTemperature)
                                .collect(Collectors.toList());
        } catch (IOException e) {
            log.warn("Something went wrong while parsing measurements.csv", e);
        }
    }

    public List<Integer> getTemperatures() {
        return temperatures;
    }

    private CsvToBean<TemperatureHolder> csvToBean(BufferedReader reader) {
        return new CsvToBeanBuilder<TemperatureHolder>(reader)
                .withType(TemperatureHolder.class)
                .withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .withMappingStrategy(makeMappingStrategy())
                .build();
    }

    private HeaderColumnNameTranslateMappingStrategy<TemperatureHolder> makeMappingStrategy() {
        Map<String, String> columnMappings = new HashMap<>();
        columnMappings.put("Temperature", "temperature");

        HeaderColumnNameTranslateMappingStrategy<TemperatureHolder> mappingStrategy =
                new HeaderColumnNameTranslateMappingStrategy<>();
        mappingStrategy.setColumnMapping(columnMappings);
        mappingStrategy.setType(TemperatureHolder.class);
        return mappingStrategy;
    }
}
