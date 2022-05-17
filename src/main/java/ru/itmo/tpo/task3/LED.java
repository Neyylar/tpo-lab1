package ru.itmo.tpo.task3;

public class LED {
    private final Integer serialNumber;
    private LEDState state = LEDState.OFF;
    public LED (Integer serialNumber){
        this.serialNumber = serialNumber;
    }
    public void turnOff(){
        this.state = LEDState.OFF;
    }
    public void flash(){
        this.state = LEDState.FLASH;
    }
    public void freeze(){
        this.state = LEDState.FREEZE;
    }
}
