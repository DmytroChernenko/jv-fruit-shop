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
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FruitStorage fruitStorage = new FruitStorageImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();

        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(fruitStorage));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(fruitStorage));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(fruitStorage));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(fruitStorage));

        FruitTransactionDao dao = new FruitTransactionDaoCsvImpl();

        OperationProcessor processor = new OperationProcessorImpl(operationHandlerMap);
        processor.processAll(dao.getAll());

        BalanceReporter reporter = new CsvBalanceReporterImpl(fruitStorage);
        reporter.createReport();
    }
}
