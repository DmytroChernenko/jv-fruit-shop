package core.basesyntax.model;

public final class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(String operation, String fruit, int quantity) {
        this.fruit = new String(fruit);
        this.quantity = quantity;
        this.operation = Operation.fromCode(operation);
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return new String(fruit);
    }

    public int getQuantity() {
        return quantity;
    }
    // getters, setters, ...

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation fromCode(String code) {
            for (Operation op : values()) {
                if (op.code.equals(code)) {
                    return op;
                }
            }
            throw new IllegalArgumentException("Unknown code: " + code);
        }
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "operation=" + operation
                + ", fruit='" + fruit + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
