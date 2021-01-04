package com.celik.app17jsoupapplication;

public class Test {

    private boolean isLoad;

    public void elma() {

        if (isLoad) {
            System.out.println("elma");
        }

        if (isLoad) {
            System.out.println("armut");
        }


    }


    public void depends(){
        isLoad = true;
    }



}
