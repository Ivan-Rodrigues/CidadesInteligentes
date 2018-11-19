package com.simulador.sensor.Quality.of.Life.util;

import com.simulador.sensor.Quality.of.Life.model.Index;

public class IndexUtil {

    public static String PM25 ="PM25";
    public static String PM10 ="PM10";
    public static String OZONE_1H="OZONE_1H";
    public static String OZONE_8H ="OZONE_8H";
    public static String SULFURE_DIOXIDE_1H ="SULFURE_DIOXIDE_1H";
    public static String SULFURE_DIOXIDE_24H ="SULFURE_DIOXIDE_24H";
    public static String NITROGEN_DIOXIDE_1H ="PM25";
    public static String CARBON_MONOXIDE_8H ="PM25";

    public static Double MAX_PM25_24H = 500.4;
    public static Double MAX_PM10_24H = 604.0;
    public static Double MAX_ozone_1H = 604.0;
    public static Double MAX_ozone_8H = 200.0;
    public static Double MAX_sulfure_dioxide_1H = 304.0;
    public static Double MAX_sulfure_dioxide_24H = 1004.0;
    public static Double MAX_nitrogen_dioxide_1H = 2049.0;
    public static Double MAX_carbon_monoxide_8H = 50.4;


    public static int calculateIndexPM25_24H(Double concetrationMean, String particula){
         Index index = new Index();

        if (particula.equals(PM25)){
            index = getIndexPM25();

        }else if (particula.equals(PM10)){
            index = getIndexPM10();

        }else if (particula.equals(OZONE_1H)){
            index = getIndexOzone_1H();

        }else if (particula.equals(OZONE_8H)){
            index = getIndexOzone_8H();

        }else if (particula.equals(SULFURE_DIOXIDE_1H)){
            index = getIndexNitrogen_dioxide_1H();


        }else if (particula.equals(SULFURE_DIOXIDE_24H)){
            index = getIndexSulfure_dioxide_24H();


        }else if (particula.equals(NITROGEN_DIOXIDE_1H)){
            index = getIndexSulfure_dioxide_1H();

        }else if (particula.equals(CARBON_MONOXIDE_8H)){
            index = getIndexCarbon_monoxide_8H();
        }
        return calculateIndex(getIndexQuality(concetrationMean,index),concetrationMean, index);
    }

    private static String getIndexQuality(Double particula, Index index){
        if (particula < index.getConcentration_good()){
            return "good";
        }else if (particula < index.getConcentration_moderate() ) {
            return "moderate";
        }else if (particula <index.getSensitive()){
            return "sensitive";
        }else if(particula < index.getConcentration_unhealthy()){
            return "unhealthy";
        }else if(particula < index.getConcentration_very_unhealthy()){
            return "very_unhealthy";
        }else if(particula < index.getConcentration_hazardous_level1()){
            return "hazardous_level1";
        }else{
            return "hazardous_level2";
        }

    }

    private static int calculateIndex(String indexQuality, Double concetration, Index index){
        int indexScore =0;
        if (indexQuality.equals("good")){

            indexScore = (int) (((index.getGood() - 0)/
                        (index.getConcentration_good() - 0)) *
                         (concetration - 0)) + 0;

        }else if (indexQuality.equals("moderate") ) {
            indexScore = (int) (((index.getModerate() - index.getGood()+1)/
                    (index.getConcentration_moderate() - index.getConcentration_good()+1)) *
                    (concetration - index.getConcentration_good()+1)) + index.getGood()+1;

        }else if (indexQuality.equals("sensitive")){
            indexScore = (int) (((index.getSensitive() - index.getModerate()+1)/
                    (index.getConcentration_sensitive() - index.getConcentration_moderate()+1)) *
                    (concetration - index.getConcentration_moderate()+1)) + index.getModerate()+1;

        }else if(indexQuality.equals("unhealthy")){
            indexScore = (int) (((index.getUnhealthy() - index.getSensitive()+1)/
                    (index.getConcentration_unhealthy() - index.getConcentration_sensitive()+1)) *
                    (concetration - index.getConcentration_sensitive()+1)) + index.getSensitive()+1;

        }else if(indexQuality.equals("very_unhealthy")){
            indexScore = (int) (((index.getVery_unhealthy() - index.getUnhealthy()+1)/
                    (index.getConcentration_very_unhealthy() - index.getConcentration_unhealthy()+1)) *
                    (concetration - index.getConcentration_unhealthy()+1)) + index.getUnhealthy()+1;

        }else if(indexQuality.equals("hazardous_level1")){
            indexScore = (int) (((index.getHazardous_level1() - index.getVery_unhealthy()+1)/
                    (index.getConcentration_hazardous_level1() - index.getConcentration_very_unhealthy()+1)) *
                    (concetration - index.getConcentration_very_unhealthy()+1)) + index.getVery_unhealthy()+1;

        }else{
            indexScore = (int) (((index.getHazardous_level2() - index.getHazardous_level1()+1)/
                    (index.getConcentration_hazardous_level2() - index.getConcentration_hazardous_level1()+1)) *
                    (concetration - index.getConcentration_hazardous_level1()+1)) + index.getHazardous_level1()+1;
        }

        return indexScore;
    }


    public static Index getIndexPM25(){
        Index indexQuality = new Index();
        indexQuality.setGood(50);
        indexQuality.setConcentration_good(12.0);
        indexQuality.setModerate(100);
        indexQuality.setConcentration_moderate(35.4);
        indexQuality.setSensitive(150);
        indexQuality.setConcentration_sensitive(55.4);
        indexQuality.setUnhealthy(200);
        indexQuality.setConcentration_unhealthy(150.4);
        indexQuality.setVery_unhealthy(300);
        indexQuality.setConcentration_very_unhealthy(250.4);
        indexQuality.setHazardous_level1(400);
        indexQuality.setConcentration_hazardous_level1(350.4);
        indexQuality.setHazardous_level2(500);
        indexQuality.setConcentration_hazardous_level1(500.4);

        return indexQuality;
    }

    public static Index getIndexOzone_1H(){
        Index indexQuality = new Index();
        indexQuality.setSensitive(150);
        indexQuality.setConcentration_sensitive(164.0);
        indexQuality.setUnhealthy(200);
        indexQuality.setConcentration_unhealthy(204.0);
        indexQuality.setVery_unhealthy(300);
        indexQuality.setConcentration_very_unhealthy(404.0);
        indexQuality.setHazardous_level1(400);
        indexQuality.setConcentration_hazardous_level1(504.0);
        indexQuality.setHazardous_level2(500);
        indexQuality.setConcentration_hazardous_level1(604.0);

        return indexQuality;
    }

    public static Index getIndexPM10(){
        Index indexQuality = new Index();
        indexQuality.setGood(50);
        indexQuality.setConcentration_good(54.0);
        indexQuality.setModerate(100);
        indexQuality.setConcentration_moderate(154.0);
        indexQuality.setSensitive(150);
        indexQuality.setConcentration_sensitive(254.0);
        indexQuality.setUnhealthy(200);
        indexQuality.setConcentration_unhealthy(354.0);
        indexQuality.setVery_unhealthy(300);
        indexQuality.setConcentration_very_unhealthy(424.0);
        indexQuality.setHazardous_level1(400);
        indexQuality.setConcentration_hazardous_level1(504.0);
        indexQuality.setHazardous_level2(500);
        indexQuality.setConcentration_hazardous_level1(604.0);

        return indexQuality;
    }

    public static Index getIndexOzone_8H(){
        Index indexQuality = new Index();
        indexQuality.setGood(50);
        indexQuality.setConcentration_good(54.0);
        indexQuality.setModerate(100);
        indexQuality.setConcentration_moderate(70.0);
        indexQuality.setSensitive(150);
        indexQuality.setConcentration_sensitive(85.0);
        indexQuality.setUnhealthy(200);
        indexQuality.setConcentration_unhealthy(105.0);
        indexQuality.setVery_unhealthy(300);
        indexQuality.setConcentration_very_unhealthy(200.0);

        return indexQuality;
    }


    public static Index getIndexSulfure_dioxide_1H(){
        Index indexQuality = new Index();
        indexQuality.setGood(50);
        indexQuality.setConcentration_good(35.0);
        indexQuality.setModerate(100);
        indexQuality.setConcentration_moderate(75.0);
        indexQuality.setSensitive(150);
        indexQuality.setConcentration_sensitive(185.0);
        indexQuality.setUnhealthy(200);
        indexQuality.setConcentration_unhealthy(304.0);

        return indexQuality;
    }

    public static Index getIndexSulfure_dioxide_24H(){
        Index indexQuality = new Index();
        indexQuality.setVery_unhealthy(300);
        indexQuality.setConcentration_very_unhealthy(604.0);
        indexQuality.setHazardous_level1(400);
        indexQuality.setConcentration_hazardous_level1(804.0);
        indexQuality.setHazardous_level2(500);
        indexQuality.setConcentration_hazardous_level1(1004.0);

        return indexQuality;
    }

    public static Index getIndexNitrogen_dioxide_1H(){
        Index indexQuality = new Index();
        indexQuality.setGood(50);
        indexQuality.setConcentration_good(53.0);
        indexQuality.setModerate(100);
        indexQuality.setConcentration_moderate(100.0);
        indexQuality.setSensitive(150);
        indexQuality.setConcentration_sensitive(360.0);
        indexQuality.setUnhealthy(200);
        indexQuality.setConcentration_unhealthy(649.0);
        indexQuality.setVery_unhealthy(300);
        indexQuality.setConcentration_very_unhealthy(1249.0);
        indexQuality.setHazardous_level1(400);
        indexQuality.setConcentration_hazardous_level1(1649.0);
        indexQuality.setHazardous_level2(500);
        indexQuality.setConcentration_hazardous_level1(2049.0);

        return indexQuality;
    }

    public static Index getIndexCarbon_monoxide_8H(){
        Index indexQuality = new Index();
        indexQuality.setGood(50);
        indexQuality.setConcentration_good(4.4);
        indexQuality.setModerate(100);
        indexQuality.setConcentration_moderate(9.4);
        indexQuality.setSensitive(150);
        indexQuality.setConcentration_sensitive(12.4);
        indexQuality.setUnhealthy(200);
        indexQuality.setConcentration_unhealthy(15.4);
        indexQuality.setVery_unhealthy(300);
        indexQuality.setConcentration_very_unhealthy(30.4);
        indexQuality.setHazardous_level1(400);
        indexQuality.setConcentration_hazardous_level1(40.4);
        indexQuality.setHazardous_level2(500);
        indexQuality.setConcentration_hazardous_level1(50.4);

        return indexQuality;
    }

}
