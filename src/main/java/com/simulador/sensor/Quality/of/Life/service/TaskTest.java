package com.simulador.sensor.Quality.of.Life.service;

import com.simulador.sensor.Quality.of.Life.model.Index;
import com.simulador.sensor.Quality.of.Life.model.PollutionData;
import com.simulador.sensor.Quality.of.Life.util.IndexUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TaskTest {

    public static void main(String[] args) {
        scheduleFixedRateTask();
    }



        static Random random = new Random();


  private static int geraRamdomRange10(){
      return random.nextInt(10);
  }

    private static int geraRamdomNegativo(){
        int val_ramdom = random.nextInt(2);
       // System.out.println(val_ramdom);
        int  val_range_5 = random.nextInt(5);
        if (val_ramdom == 1){
            return val_range_5;
        }else {
            return val_range_5 * (-1);
        }
    }


    private static int val = 30;


    @Scheduled(fixedRate = 100)
    public static void scheduleFixedRateTask() {
        PollutionData pollutionData = new PollutionData();

        if (val < 20){
            val = val +geraRamdomRange10();
        }else if (val > 210){
            val = val - geraRamdomRange10();
        } else{
            val = val + geraRamdomNegativo();
        }
        //System.out.println(val);

        int indexScore = IndexUtil.calculateIndexPM25_24H(50.0, IndexUtil.PM25);
        System.out.println(indexScore);
    }


    /*
    @Scheduled(fixedRate = 2000)
    public static void scheduleFixedRateTask2() {
        System.out.println(
                "Task 2 - " + System.currentTimeMillis() / 1000);
    }

    @Scheduled(fixedRate = 3000)
    public static void scheduleFixedRateTask3() {
        System.out.println(
                "Task 3 - " + System.currentTimeMillis() / 1000);
    }

    @Scheduled(fixedRate = 4000)
    public static void scheduleFixedRateTask4() {
        System.out.println(
                "Task 4 - " + System.currentTimeMillis() / 1000);
    }

    @Scheduled(fixedRate = 5000)
    public static void scheduleFixedRateTask5() {
        System.out.println(
                "Task 5 - " + System.currentTimeMillis() / 1000);
    }

    @Scheduled(fixedRate = 6000)
    public static void scheduleFixedRateTask6() {
        System.out.println(
                "Task 6 - " + System.currentTimeMillis() / 1000);
    }
*/

}
