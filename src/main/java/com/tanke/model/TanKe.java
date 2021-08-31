package com.tanke.model;

import com.tanke.enums.Dir;
import lombok.Data;

import java.awt.*;

@Data
public class TanKe {
    private int x,y;
    private Dir dir;
    private int speed=10;
    private boolean moving = false;

    public TanKe(int x, int y, Dir dir, int speed) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.speed = speed;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        move();

    }

    private void move() {
        if(!moving){
            return;
        }
        switch (dir){
            case LEFT:
                x-=speed;
                break;
            case UP:
                y-=speed;
                break;
            case RIGHT:
                x+=speed;
                break;
            case DOWN:
                y+=speed;
                break;
            default:
                break;
        }
    }
}
