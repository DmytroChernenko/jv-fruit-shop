package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.BalanceReporter;
import core.basesyntax.storage.FruitStorage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvBalanceReporterImpl implements BalanceReporter {

    private FruitStorage fruitStorage;
    private final String fileName = "report.csv";

    public CsvBalanceReporterImpl(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void createReport() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write("fruit,quantity");
            bw.newLine();
            for (Map.Entry<Fruit, Integer> entry : fruitStorage.getAll().entrySet()) {
                bw.write(entry.getKey().getName() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
