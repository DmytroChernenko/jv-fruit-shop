package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationProcessor;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class OperationProcessorImpl implements OperationProcessor {

    private Map<FruitTransaction.Operation, OperationHandler> operationMap;

    public OperationProcessorImpl(Map<FruitTransaction.Operation, OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public void process(FruitTransaction transaction) {
        operationMap.get(transaction.getOperation()).handleTransaction(transaction);
    }

    @Override
    public void processAll(List<FruitTransaction> transactions) {
        transactions.forEach(this::process);
    }
}
