package com.simulador.sensor.Quality.of.Life.util;

import com.google.gson.Gson;
import com.simulador.sensor.Quality.of.Life.model.PollutionData;
import com.simulador.sensor.Quality.of.Life.service.ResourceCatalogService;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TesteClass {

    private static List<PollutionData> instancias = new ArrayList<>();
    private static Gson gson = new Gson();
    public static void main(String[] args) throws IOException, ParseException {

        instancias = Util.lerInstanciasPollution();

        //System.out.println(instancias.get(0).getTimestamp());
        System.out.println(ResourceCatalogService.getResourcesAll().size());
    }







}
