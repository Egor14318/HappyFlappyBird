package ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Bird {
    int x, y;
    int speed;
    int width;
    int height;
    Texture[] framesArray = new Texture[]{
        new Texture("birdTiles/bird0.png"),
        new Texture("birdTiles/bird1.png"),
        new Texture("birdTiles/bird2.png"),
        new Texture("birdTiles/bird1.png")
    };
    int frameCounter;
    int jumpHeight;
    final int maxHeightOfJump = 200;
    boolean jump;

    public Bird(int x, int y,  int speed,int width, int height) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;

    }



    void onClick() {
        jump = true;
        jumpHeight = maxHeightOfJump + y;
    }

    public void fly() {
        x += speed;
        y += speed;
        if (y >= jumpHeight) {
            jump = false;

        }
        if (jump) {
            y += speed;
        }else {
            y-=speed;
        }


    }

    public void draw(Batch batch) {
            int frameMultiplier = 10;
            batch.draw(framesArray[frameCounter / frameMultiplier], x, y, width, height);   //длинна и ширина фиксированные
            if (frameCounter++ == framesArray.length * frameMultiplier - 1) frameCounter = 0;

    }

    public void dispose() {
        for (Texture t:framesArray){
            t.dispose();
        }
    }
}