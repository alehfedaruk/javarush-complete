package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {

    int getCountOfEggsPerMonth(int eggsPerDay) {
        return 30*eggsPerDay;
    }

    @Override
    int getCountOfEggsPerMonth() {
        return 5;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA +". " + "Я несу " +
                getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
