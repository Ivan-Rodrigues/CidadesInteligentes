package com.simulador.sensor.Quality.of.Life.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Resources implements Serializable {

    private List<Resource> resources = new ArrayList<>();

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public Resources() {
    }
}
