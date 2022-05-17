package ru.itmo.tpo.task3;

public enum PanelState {
    UNPLUGGED("отключены"),
    STARTED("начали работать"),
    STOPPED("остановились");

    private final String message;

    PanelState(String message) {
        this.message = message;
    }
}
