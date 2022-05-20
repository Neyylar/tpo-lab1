package ru.itmo.tpo.task3;

public class Computer {
    //TODO: Это похоже на дата-класс, значит надо добавить на panelGroup и communicationPanel final
    private BeamPanelGroup panelGroup;
    private CommunicationPanel communicationPanel;

    public Computer(BeamPanelGroup panelGroup, CommunicationPanel communicationPanel) {
        this.panelGroup = panelGroup;
        this.communicationPanel = communicationPanel;
    }

    public void turnOff() {
        this.panelGroup.turnOffPanelGroup();
        this.communicationPanel.turnOff();
    }

    public void turnOn() {
        this.panelGroup.turnOnPanelGroup();
        this.communicationPanel.turnOn();
    }
}
