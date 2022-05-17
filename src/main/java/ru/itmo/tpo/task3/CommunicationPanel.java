package ru.itmo.tpo.task3;

public class CommunicationPanel {
    private final Integer serialNumber;
    private PanelState state = PanelState.UNPLUGGED;
    private PanelCondition condition = PanelCondition.SERVICEABLE;

    public CommunicationPanel(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void plug() {
        this.state = PanelState.STOPPED;
    }

    public void unplug() {
        this.state = PanelState.UNPLUGGED;
    }

    public void turnOn() {
        if (this.condition == PanelCondition.BROKEN) {
            throw new IllegalStateException("Can't turn on broken panel");
        } else if (this.state == PanelState.STARTED) {
            throw new IllegalStateException("Panel is working already");
        } else if (this.state == PanelState.UNPLUGGED) {
            throw new IllegalStateException("Panel is unplugged");
        } else this.state = PanelState.STARTED;
    }

    public void turnOff() {
        if (this.state == PanelState.STOPPED) throw new IllegalStateException("Panel is not working already");
        else if (this.state == PanelState.UNPLUGGED) {
            throw new IllegalStateException("Panel is unplugged");
        } else {
            this.state = PanelState.STOPPED;
        }
    }

    public void fix() {
        this.condition = PanelCondition.SERVICEABLE;
    }

    public void broke() {
        this.condition = PanelCondition.BROKEN;
    }
}
