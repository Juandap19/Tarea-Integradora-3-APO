package com.example.aatankbattle.model;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Avatar {
    private Canvas canvas;
    private GraphicsContext gc;
    private Image tank;
    private Image heart;
    private Image bullet;
    public Vector pos;
    public Vector direction;
    public int bullets;
    public int life;
    private String name;
    public Avatar(Canvas canvas){
        bullets=5;
        life=5;
        name="JuanDi";
        this.canvas=canvas;
        gc=canvas.getGraphicsContext2D();
        try {
            tank = new Image(new FileInputStream("data/t1.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        pos = new Vector(100,100);
        direction = new Vector(2,0);
        try {
            heart = new Image(new FileInputStream("data/cora.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            bullet=new Image(new FileInputStream("data/bullet.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public Avatar(Canvas canvas,int o){
        bullets=5;
        life=5;
        name="JuanDa";
        this.canvas=canvas;
        gc=canvas.getGraphicsContext2D();
        try {
            tank = new Image(new FileInputStream("data/t2.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        pos = new Vector(100,100);
        direction = new Vector(2,0);
        try {
            heart = new Image(new FileInputStream("data/cora.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            bullet=new Image(new FileInputStream("data/bullet.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void draw(){
        gc.save();
        gc.translate(pos.x,pos.y);
        gc.setFont(Font.font(10));
        gc.setFill(Color.WHITE);
        gc.fillText(name,-20, -35);
        //Hearts
        if(life>=1){
            gc.drawImage(heart,-25,-30,10,10);
        }
        if(life>=2){
            gc.drawImage(heart,-15,-30,10,10);
        }
        if(life>=3){
            gc.drawImage(heart,-5,-30,10,10);
        }
        if(life>=4){
            gc.drawImage(heart,5,-30,10,10);
        }
        if (life >= 5) {
            gc.drawImage(heart, 15, -30, 10, 10);
        }
        //bullets
        if(bullets>=1){
            gc.drawImage(bullet,-25,20,10,10);
        }
        if(bullets>=2){
            gc.drawImage(bullet,-15,20,10,10);
        }
        if(bullets>=3){
            gc.drawImage(bullet,-5,20,10,10);
        }
        if(bullets>=4){
            gc.drawImage(bullet,5,20,10,10);
        }
        if (bullets >= 5) {
            gc.drawImage(bullet, 15, 20, 10, 10);
        }
        gc.rotate(90+direction.getAngle());
        gc.drawImage(tank,-25,-25,50,50);
        gc.restore();

    }


    public void changeAngle(double a ){

        double amp = direction.getApmlitude();
        double angle = direction.getAngle();
        angle += a;
        direction.x = amp*Math.cos(Math.toRadians(angle));
        direction.y = amp*Math.sin(Math.toRadians(angle));

    }
    public void moveForward(){
        pos.x += direction.x;
        pos.y += direction.y;
    }

    public void moveBackward(){
        pos.x -= direction.x;
        pos.y -= direction.y;
    }

    public String getName() {
        return name;
    }
}
