package core.basesyntax;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoCsvImpl;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.TransactionProcessorImpl;

public class Main {
    public static void main(String[] args) {
        FruitTransactionDao dao = new FruitTransactionDaoCsvImpl();
        dao.getAll().forEach(System.out::println);

        TransactionProcessor processor = new TransactionProcessorImpl();
        processor.processAll(dao.getAll());
    }
}
