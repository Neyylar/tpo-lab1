package ru.itmo.tpo.task3;

public class BeamPanel extends CommunicationPanel {
    private final Integer serialNumber;
    private final LED led;
    private PanelState state = PanelState.UNPLUGGED;
    private PanelCondition condition = PanelCondition.SERVICEABLE;


    public BeamPanel(Integer serialNumber, LED led) {
        super(serialNumber);
        this.serialNumber = serialNumber;
        this.led = led;
    }

    public void plug() {
        this.state = PanelState.STOPPED;
    }

    public void unplug() {
        this.state = PanelState.UNPLUGGED;
        this.led.turnOff();
    }

    public void turnOn() {
        if (this.condition == PanelCondition.BROKEN) {
            throw new IllegalStateException("Cant turn on broken panel");
        } else if (this.state == PanelState.UNPLUGGED) {
            throw new IllegalStateException("Panel is unplugged");
        } else if (this.state == PanelState.STARTED) {
            throw new IllegalStateException("Panel is working already");
        } else this.state = PanelState.STARTED;
        workingMode();
    }

    public void turnOff() {
        if (this.state == PanelState.STOPPED) throw new IllegalStateException("Panel is not working already");
        else if (this.state == PanelState.UNPLUGGED) {
            throw new IllegalStateException("Panel is unplugged");
        } else {
            this.state = PanelState.STOPPED;
            this.led.turnOff();
        }
    }

    public void fix() {
        this.condition = PanelCondition.SERVICEABLE;
        testingMode();
    }

    public void broke() {
        this.condition = PanelCondition.BROKEN;
        this.led.turnOff();
    }

    private void testingMode() {
        this.led.flash();
    }

    private void workingMode() {
        this.led.freeze();
    }
}
