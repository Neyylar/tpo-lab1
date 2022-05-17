package ru.itmo.tpo.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BeamPanelGroupTest {
    private BeamPanelGroup panelGroup;

    @BeforeEach
    void setUp() {
        this.panelGroup = new BeamPanelGroup();
    }

    @Test
    void testAddAndRemovePanelsWithThrowingIllegalArgumentException() {
        Class<IllegalArgumentException> exception = IllegalArgumentException.class;
        LED led = new LED(0);
        BeamPanel panel = new BeamPanel(0, led);
        assertAll(
                () -> assertThrows(exception, () -> panelGroup.turnOnPanel(panel)),
                () -> assertThrows(exception, () -> panelGroup.turnOffPanel(panel)),
                () -> assertDoesNotThrow(() -> panelGroup.insertPanel(panel)),
                () -> assertThrows(exception, () -> panelGroup.insertPanel(panel)),
                () -> assertDoesNotThrow(() -> panelGroup.turnOnPanelGroup()),
                () -> assertDoesNotThrow(() -> panelGroup.turnOffPanelGroup()),
                () -> assertDoesNotThrow(() -> panelGroup.removePanel(panel)),
                () -> assertThrows(exception, () -> panelGroup.removePanel(panel))
        );
    }

    @Test
    void turnOnAndTurnOffPanelWithThrowingIllegalStateException() {
        Class<IllegalStateException> exception = IllegalStateException.class;
        LED led = new LED(0);
        BeamPanel panel = new BeamPanel(0, led);
        assertAll(
                () -> assertThrows(exception, panel::turnOn),
                () -> assertThrows(exception, panel::turnOff),
                () -> assertDoesNotThrow(() -> panelGroup.insertPanel(panel)),
                () -> assertDoesNotThrow(panel::broke),
                () -> assertThrows(exception, () -> panelGroup.turnOnPanel(panel)),
                () -> assertDoesNotThrow(panel::fix),
                () -> assertDoesNotThrow(() -> panelGroup.turnOnPanel(panel)),
                () -> assertThrows(exception, () -> panelGroup.turnOnPanel(panel)),
                () -> assertDoesNotThrow(() -> panelGroup.turnOffPanel(panel)),
                () -> assertThrows(exception, () -> panelGroup.turnOffPanel(panel)),
                () -> assertDoesNotThrow(() -> panelGroup.removePanel(panel))
        );
    }
}
