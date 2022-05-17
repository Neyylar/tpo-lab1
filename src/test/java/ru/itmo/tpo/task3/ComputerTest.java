package ru.itmo.tpo.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerTest {
    private Computer computer;
    private CommunicationPanel panel;

    @BeforeEach
    void setUp() {
        this.panel = new CommunicationPanel(0);
        BeamPanelGroup panelGroup = new BeamPanelGroup();
        this.computer = new Computer(panelGroup, panel);
    }


    @Test
    void testTurnOnAndOffComputerThrowingIllegalStateException() {
        var exception = IllegalStateException.class;
        panel.plug();
        assertAll(
                () -> assertDoesNotThrow(() -> computer.turnOn()),
                () -> assertThrows(exception, () -> computer.turnOn()),
                () -> assertDoesNotThrow(() -> computer.turnOff()),
                () -> assertThrows(exception, () -> computer.turnOff())
        );
    }
}
