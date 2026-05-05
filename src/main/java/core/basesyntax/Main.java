package core.basesyntax;

import core.basesyntax.db.FruitTransactionDao;
import core.basesyntax.db.FruitTransactionDaoCsvImpl;
import core.basesyntax.service.BalanceReporter;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.CsvBalanceReporterImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.storage.FruitStorage;
import core.basesyntax.storage.FruitStorageImpl;

public class Main {
    public static void main(String[] args) {
        FruitTransactionDao dao = new FruitTransactionDaoCsvImpl();
        dao.getAll().forEach(System.out::println);

        FruitStorage fruitStorage = new FruitStorageImpl();

        TransactionProcessor processor = new TransactionProcessorImpl(fruitStorage);
        processor.processAll(dao.getAll());

        BalanceReporter reporter = new CsvBalanceReporterImpl(fruitStorage);
        reporter.createReport();
    }
}
