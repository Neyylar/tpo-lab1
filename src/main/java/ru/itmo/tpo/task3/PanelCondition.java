package ru.itmo.tpo.task3;

public enum PanelCondition {
    SERVICEABLE("исправна"),
    BROKEN("сломана");

    private final String message;

    PanelCondition(String message) {
        this.message = message;
    }
}
