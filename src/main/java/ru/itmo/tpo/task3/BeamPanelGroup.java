package ru.itmo.tpo.task3;

import java.util.ArrayList;
import java.util.List;

public class BeamPanelGroup {
    private final List<BeamPanel> panels = new ArrayList<>();

    public BeamPanelGroup() {
    }

    public void removePanel(BeamPanel panel) {
        if (!panels.contains(panel))
            throw new IllegalArgumentException("Panel is not inserted in panel group to be removed");
        else {
            panels.remove(panel);
            panel.unplug();
        }
    }

    public void insertPanel(BeamPanel panel) {
        if (panels.contains(panel)) throw new IllegalArgumentException("Panel is already inserted in panel group");
        else {
            panels.add(panel);
            panel.plug();
        }
    }

    void turnOffPanel(BeamPanel panel) {
        if (!panels.contains(panel)) throw new IllegalArgumentException("Panel is not in the panel group");
        else {
            panel.turnOff();
        }
    }

    void turnOnPanel(BeamPanel panel) {
        if (!panels.contains(panel)) throw new IllegalArgumentException("Panel is not in the panel group");
        else {
            panel.turnOn();
        }
    }

    public void turnOnPanelGroup() {
        panels.forEach(panel -> turnOnPanel(panel));
    }

    public void turnOffPanelGroup() {
        panels.forEach(panel -> turnOffPanel(panel));
    }


}
