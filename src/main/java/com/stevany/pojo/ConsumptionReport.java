package com.stevany.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConsumptionReport {
    @JsonProperty("village_name")
    private String villageName;
    @JsonProperty("consumption_time")
    private double consumptionTime;

    public ConsumptionReport() {
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public double getConsumptionTime() {
        return consumptionTime;
    }

    public void setConsumptionTime(double consumptionTime) {
        this.consumptionTime = consumptionTime;
    }
}
