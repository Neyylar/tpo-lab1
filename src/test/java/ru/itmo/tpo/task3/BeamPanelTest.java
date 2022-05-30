package ru.itmo.tpo.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BeamPanelTest {
    private BeamPanel panel;
    private LED led;


    @BeforeEach
    void setUp() {
        led = new LED(0);
        this.panel = new BeamPanel(0, led);
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
