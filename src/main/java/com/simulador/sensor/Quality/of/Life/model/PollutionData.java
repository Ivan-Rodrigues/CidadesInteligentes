package com.simulador.sensor.Quality.of.Life.model;

import java.io.Serializable;
import java.util.Date;

public class PollutionData implements Serializable {

    private Long id;
    private Double ozone;
    private Double particullate_matter25;
    private Double particullate_matter10;
    private Double carbon_monoxide;
    private Double sulfure_dioxide;
    private Double nitrogen_dioxide;
    private Double longitude;
    private Double latitude;
    private String timestamp;

    public PollutionData(Long id, Double ozone, Double particullate_matter25, Double carbon_monoxide,
                         Double sulfure_dioxide, Double nitrogen_dioxide, Double longitude, Double latitude,
                         String timestamp) {
        this.id = id;
        this.ozone = ozone;
        this.particullate_matter25 = particullate_matter25;
        this.carbon_monoxide = carbon_monoxide;
        this.sulfure_dioxide = sulfure_dioxide;
        this.nitrogen_dioxide = nitrogen_dioxide;
        this.longitude = longitude;
        this.latitude = latitude;
        this.timestamp = timestamp;
    }

    public PollutionData(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getOzone() {
        return ozone;
    }

    public void setOzone(Double ozone) {
        this.ozone = ozone;
    }

    public Double getCarbon_monoxide() {
        return carbon_monoxide;
    }

    public void setCarbon_monoxide(Double carbon_monoxide) {
        this.carbon_monoxide = carbon_monoxide;
    }

    public Double getSulfure_dioxide() {
        return sulfure_dioxide;
    }

    public void setSulfure_dioxide(Double sulfure_dioxide) {
        this.sulfure_dioxide = sulfure_dioxide;
    }

    public Double getNitrogen_dioxide() {
        return nitrogen_dioxide;
    }

    public void setNitrogen_dioxide(Double nitrogen_dioxide) {
        this.nitrogen_dioxide = nitrogen_dioxide;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getParticullate_matter25() {
        return particullate_matter25;
    }

    public void setParticullate_matter25(Double particullate_matter25) {
        this.particullate_matter25 = particullate_matter25;
    }

    public Double getParticullate_matter10() {
        return particullate_matter10;
    }

    public void setParticullate_matter10(Double particullate_matter10) {
        this.particullate_matter10 = particullate_matter10;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

