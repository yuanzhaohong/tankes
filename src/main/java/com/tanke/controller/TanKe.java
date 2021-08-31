package com.tanke.controller;



public class TanKe {


    public static void main(String[] args) throws InterruptedException {
        TanKeFrame tanKeFrame=new TanKeFrame();
        while (true){
            Thread.sleep(50);
            tanKeFrame.repaint();
        }
    }



}
