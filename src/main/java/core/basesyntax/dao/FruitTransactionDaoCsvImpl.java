package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionDaoCsvImpl implements FruitTransactionDao {

    private static final String FILE_NAME = "data.csv";

    private List<FruitTransaction> transactions;

    {
        transactions = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Path.of(FILE_NAME));
            lines.stream().forEach(s -> transactions.add(getFruitTransactionFromRowCsv(s)));
        } catch (IOException e) {
            throw new RuntimeException("something bad with reading file: " + e.getMessage());
        }
    }

    @Override
    public List<FruitTransaction> getAll() {
        return transactions;
    }

    private FruitTransaction getFruitTransactionFromRowCsv(String row) {
        String[] parts = row.split(",");
        return new FruitTransaction(parts[0], parts[1], Integer.parseInt(parts[2]));
    }
}
