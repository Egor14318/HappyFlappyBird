package ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.characters;


import static ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.MyGdxGame.SCR_HEIGHT;
import static ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.MyGdxGame.SCR_WIDTH;
import static ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.screens.ScreenMenu.difficult;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.Random;

import ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.characters.Bird;


public class Tube {
    static int  width = 200;
    static int height = 700;
    int gapHeight = 400;
    int padding = 100;
    int gapY;
    int x;
    int distanceBetweenTubes;
    static int speed = 10;
    boolean isPointReceived;
    Random random = new Random();
    Texture textureUpperTube;
    Texture textureDownTube;


    public static void dif(){
        if (difficult ==1) {
                System.out.println("1");
        }

        if (difficult ==2 ) {
            speed = 12;
            width = 220;
            height = 750;

            System.out.println("2");
        }
         if (difficult==3) {
             speed = 12;
             width = 230;
             height = 770;

             System.out.println("3");
         }
         if (difficult==4) {
             difficult = 1;
             System.out.println("4");
         }





    }


    public Tube(int tubeCount, int tubeIdx) {
        random = new Random();

        gapY = gapHeight / 2 + padding + random.nextInt(SCR_HEIGHT - 2 * (padding + gapHeight / 2));
        distanceBetweenTubes = (SCR_WIDTH + width) / (tubeCount - 1);
        x = distanceBetweenTubes * tubeIdx + SCR_WIDTH;

        textureUpperTube = new Texture("tubes/tube_flipped.png");
        textureDownTube = new Texture("tubes/tube.png");
    }

    public void draw(Batch batch) {
        batch.draw(textureUpperTube, x, gapY + gapHeight / 2, width, height);
        batch.draw(textureDownTube, x, gapY - gapHeight / 2 - height, width, height);
    }

    public void move() {
        x -= speed;
        if (x < -width) {
            isPointReceived = false;
            x = SCR_WIDTH + distanceBetweenTubes;
            gapY = gapHeight / 2 + padding + random.nextInt(SCR_HEIGHT - 2 * (padding + gapHeight / 2));
        }
    }

    public boolean isHit(Bird bird) {

        // down tube collision
        if (bird.y <= gapY - gapHeight / 2 && bird.x + bird.width >= x && bird.x <= x)
            return true;
        if (bird.y + bird.height >= gapY + gapHeight / 2 && bird.x + bird.width >= x && bird.x <= x)
            return true;
        // upper tube collision
        // сделать проверку самостоятельно тут

        return false;
    }


    public void setPointReceived() {
        isPointReceived = true;

    }

    public boolean needAddPoint(Bird bird) {
        if (bird.x > x + width && !isPointReceived) {
            return true;
        }

        return false;

    }

    /*
    public boolean isHit(Bird bird) {
        if (bird.x + bird.width == x && bird.x == x + width) {
            return true;
        }
        return false;
    }
    */
    void dispose() {
        textureDownTube.dispose();
        textureUpperTube.dispose();
    }


}