package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.db.FruitStorageImpl;
import core.basesyntax.db.FruitTransactionDao;
import core.basesyntax.db.FruitTransactionDaoCsvImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.BalanceReporter;
import core.basesyntax.service.OperationProcessor;
import core.basesyntax.service.impl.CsvBalanceReporterImpl;
import core.basesyntax.service.impl.OperationProcessorImpl;
import core.basesyntax.strategy.*;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FruitTransactionDao dao = new FruitTransactionDaoCsvImpl();

        FruitStorage fruitStorage = new FruitStorageImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationOperationHandlerMap = new HashMap<>();

        operationOperationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(fruitStorage));
        operationOperationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(fruitStorage));
        operationOperationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(fruitStorage));
        operationOperationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(fruitStorage));

        OperationProcessor processor = new OperationProcessorImpl(operationOperationHandlerMap);
        processor.processAll(dao.getAll());

        BalanceReporter reporter = new CsvBalanceReporterImpl(fruitStorage);
        reporter.createReport();
    }
}
