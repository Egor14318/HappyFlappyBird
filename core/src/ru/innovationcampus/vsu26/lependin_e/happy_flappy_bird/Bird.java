package ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird;

import static ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.MyGdxGame.SCR_HEIGHT;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Bird {
    int x=100, y;
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

    public boolean isInField() {
        if (y + height < 0) return false;
        if (y > SCR_HEIGHT) return false;
        return  true;

    }

    void onClick() {
        jump = true;
        jumpHeight = maxHeightOfJump + y;
    }

    public void fly() {
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
            int frameMultiplier = 5;
            batch.draw(framesArray[frameCounter / frameMultiplier], x, y, width, height);   //длинна и ширина фиксированные
            if (frameCounter++ == framesArray.length * frameMultiplier - 1) frameCounter = 0;

    }

    public void dispose() {
        for (Texture t:framesArray){
            t.dispose();
        }
    }
}