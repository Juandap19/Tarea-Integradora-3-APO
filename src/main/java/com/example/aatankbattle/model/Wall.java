package com.example.aatankbattle.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Wall {
    private Canvas canvas;
    private GraphicsContext gc;
    public int life;
    public int x,y;
    private Image wall;
    private Rectangle hitbox;
    public Wall(Canvas canvas,int x,int y){
        this.canvas=canvas;
        gc=canvas.getGraphicsContext2D();
        try {
            wall=new Image(new FileInputStream("data/wall.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.x=x;
        this.y=y;
        life=4;
    }
    public void draw(){
        hitbox=new Rectangle(x,y,60,40);
        if(life==3){
            try {
                wall = new Image(new FileInputStream("data/wall.png"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        if(life==2){
            try {
                wall= new Image(new FileInputStream("data/wall.png"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            ;
        }
        if(life==1){
            try {
                wall=new Image(new FileInputStream("data/wall.png"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            ;
        }
        gc.drawImage(wall,x,y,50,50);

    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }


}
