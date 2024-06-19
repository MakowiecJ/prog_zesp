package com.wawel.common;

import java.util.Map;

public enum TicketType {
    NORMALNY(37f),
    ULGOWY(21f),
    SENIOR(26f),
    STUDENT(25f);

    private final float value;

    TicketType(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public static int getTypeId(TicketType type) {
        switch (type) {
            case NORMALNY -> {
                return 1;
            }
            case ULGOWY -> {
                return 2;
            }
            case SENIOR -> {
                return 3;
            }
            case STUDENT -> {
                return 4;
            }
        }
        return 0;
    }
}
