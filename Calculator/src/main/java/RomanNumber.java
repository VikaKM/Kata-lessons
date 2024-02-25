public enum RomanNumber {
    I(1), II (2), III (3), IV (4), V (5), VI (6), VII (7), VIII (8), IX (9), X (10);

    private int value;

    RomanNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RomanNumber numberFromValue (int value) {
        for (RomanNumber e : values()) {
            if (value == e.getValue()) {
                return e;
            }
        }
        return null;
    }
}
