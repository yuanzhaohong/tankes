package com.tanke.controller;


import com.tanke.enums.Dir;
import com.tanke.model.TanKe;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TanKeFrame extends Frame {
   TanKe tanKe=new TanKe(200,200,Dir.DOWN,5);

    public TanKeFrame() {
        setSize(800, 600);
        setResizable(false);
        setTitle("坦克大战");
        setVisible(true);
        addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });
    }

    @Override
    public void paint(Graphics g) {

        tanKe.paint(g);

    }

    class  MyKeyListener extends KeyAdapter{

        boolean bl=false;
        boolean bu=false;
        boolean br=false;
        boolean bd=false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bl=true;
                break;
                case KeyEvent.VK_UP:
                    bu=true;
                    break;
                case KeyEvent.VK_RIGHT:
                    br=true;
                    break;
                case KeyEvent.VK_DOWN:
                    bd=true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bl=false;
                    break;
                case KeyEvent.VK_UP:
                    bu=false;
                    break;
                case KeyEvent.VK_RIGHT:
                    br=false;
                    break;
                case KeyEvent.VK_DOWN:
                    bd=false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if(!bl && !bu && !br && !bd){
                tanKe.setMoving(false);
            }else{
                tanKe.setMoving(true);
                if(bl){ tanKe.setDir(Dir.LEFT); }
                if(bu){ tanKe.setDir(Dir.UP); }
                if(br){ tanKe.setDir(Dir.RIGHT); }
                if(bd){ tanKe.setDir(Dir.DOWN); }
            }
        }
    }

}
