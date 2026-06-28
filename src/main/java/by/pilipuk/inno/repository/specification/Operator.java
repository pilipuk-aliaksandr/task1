package by.pilipuk.inno.repository.specification;

public enum Operator {
    GREATER {
        @Override
        public boolean compare(double left, double right) { return left > right; }
    },
    LESS {
        @Override
        public boolean compare(double left, double right) { return left < right; }
    },
    EQUAL {
        @Override
        public boolean compare(double left, double right) { return left == right; }
    },
    GREATER_OR_EQUAL {
        @Override
        public boolean compare(double left, double right) { return left >= right; }
    },
    LESS_OR_EQUAL {
        @Override
        public boolean compare(double left, double right) { return left <= right; }
    };

    public abstract boolean compare(double left, double right);
}
