package com.example.aatankbattle.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Bullet {

    private Canvas canvas;
    private GraphicsContext gc;
    public Vector pos;
    public Vector direction;
    private int player;
    private Image bullet;
    public Bullet(Canvas canvas, Vector pos, Vector dir,int player) {
        this.canvas = canvas;
        gc= canvas.getGraphicsContext2D();
        this.player=player;
        this.pos = pos;
        this.direction = dir;
        try {
            bullet=new Image(new FileInputStream("data/bullet.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void draw(){

        gc.drawImage(bullet,pos.x-5,pos.y-5,10,10);
        pos.x+= direction.x;
        pos.y+= direction.y;

    }

    public int getPlayer() {
        return player;
    }
}
