package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {

    private TransactionHandler transactionHandler;


    @Override
    public void process(FruitTransaction transaction) {
        
    }

    @Override
    public void processAll(List<FruitTransaction> transactions) {

    }
}
