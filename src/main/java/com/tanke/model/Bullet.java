package com.tanke.model;

import com.tanke.enums.Dir;
import lombok.Data;

import java.awt.*;

@Data
public class Bullet {
  private int speed=10;
  private Dir dir;
  private int x,y;

    public Bullet(int speed, Dir dir) {
        this.speed = speed;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        Color c= g.getColor();

        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 50);

    }
}
