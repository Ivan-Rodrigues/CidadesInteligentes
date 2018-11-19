package com.simulador.sensor.Quality.of.Life.util;

import com.simulador.sensor.Quality.of.Life.model.Index;
import com.simulador.sensor.Quality.of.Life.model.PollutionData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.*;

public class Util {




    private static Calendar calendar = Calendar.getInstance();
    public static String URL_BASE = "http://cidadesinteligentes.lsdi.ufma.br/";
    public static double getDistance(double lat1, double lon1, double lat2, double lon2, String unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit == "K") {
            dist = dist * 1.609344;
        } else if (unit == "N") {
            dist = dist * 0.8684;
        }

        return (dist);
    }


    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::    This function converts decimal degrees to radians                         :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::    This function converts radians to decimal degrees                         :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

    public static int getDay(Date date) {
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    public static int getMonth(Date date) {
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }

    public static List<PollutionData> lerInstanciasPollution() throws ParseException, FileNotFoundException {
        List<PollutionData> pollutionInstances = new ArrayList<>();
        InputStream inputStream = new FileInputStream("pollutionData158324.csv");
        CVSReader cvsReader = new CVSReader(inputStream);
        List<String[]> linhas = cvsReader.read();
        Long i = Long.valueOf(1);

        for (String[] linha : linhas){
            PollutionData data = new PollutionData(i, parseDouble(linha[0]),parseDouble(linha[1]),parseDouble(linha[2]),parseDouble(linha[3]),
                    parseDouble(linha[4]),parseDouble(linha[5]),
                    parseDouble(linha[6]), linha[7]);
            pollutionInstances.add(data);

            i++;
        }


        return pollutionInstances;
    }

    private static Double parseDouble(String valor){
        return Double.parseDouble(valor);
    }

}