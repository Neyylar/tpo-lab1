package ru.itmo.tpo.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommunicationPanelTest {
    private CommunicationPanel panel;

    @BeforeEach
    void setUp() {
        this.panel = new CommunicationPanel(0);
    }

    @Test
    void testTurnOnAndOffComputerThrowingIllegalStateException() {
        var exception = IllegalStateException.class;
        assertAll(
                () -> assertThrows(exception, () -> panel.turnOn()),
                () -> assertThrows(exception, () -> panel.turnOff()),
                () -> assertDoesNotThrow(() -> panel.plug()),
                () -> assertDoesNotThrow(() -> panel.turnOn()),
                () -> assertThrows(exception, () -> panel.turnOn()),
                () -> assertDoesNotThrow(() -> panel.turnOff()),
                () -> assertDoesNotThrow(() -> panel.broke()),
                () -> assertThrows(exception, () -> panel.turnOn()),
                () -> assertDoesNotThrow(() -> panel.fix()),
                () -> assertDoesNotThrow(() -> panel.turnOn()),
                () -> assertDoesNotThrow(() -> panel.unplug())
        );
    }
}
