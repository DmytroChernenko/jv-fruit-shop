package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionDao {
    List<FruitTransaction> getAll();
}
