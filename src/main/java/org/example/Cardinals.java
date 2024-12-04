package org.example;

public enum Cardinals {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    int CardOrdinal = 0;

    Cardinals(int ord) {
        this.CardOrdinal = ord;
    }

    public static Cardinals byOrdinal(int ord) {
        if(ord <0) ord = 3;
        for (Cardinals c : Cardinals.values()) {
            if (c.CardOrdinal == ord) {
                return c;
            }
        }
        return null;
    }
}
