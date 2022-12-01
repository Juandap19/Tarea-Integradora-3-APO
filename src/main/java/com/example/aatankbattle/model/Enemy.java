package com.example.aatankbattle.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Enemy {
    private Canvas canvas;
    private GraphicsContext gc;
    public int x,y;
    private Image tank;

    public Enemy(Canvas canvas, int x, int y){
        this.canvas = canvas;
        gc = canvas.getGraphicsContext2D();
        try {
            tank =new Image(new FileInputStream("data/t3.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.x = x;
        this.y = y;
    }

    public void draw(){
        gc.save();
        gc.drawImage(tank,x-12.5,y-12.5,50,50);
    }

}