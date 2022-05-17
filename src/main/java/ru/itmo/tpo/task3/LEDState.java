package ru.itmo.tpo.task3;

public enum LEDState {
    OFF("не светят"),
    FLASH("мигают - тестируют систему"),
    FREEZE("застыли - рабочий режим");

    private final String message;

    LEDState(String message) {
        this.message = message;
    }
}
