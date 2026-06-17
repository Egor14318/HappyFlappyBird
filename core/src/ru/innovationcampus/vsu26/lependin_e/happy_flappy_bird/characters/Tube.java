package ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.characters;

import static ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.MyGdxGame.SCR_HEIGHT;
import static ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import java.util.Random;

public class Tube {

    public static int width = 200;
    public static int height = 700;
    public static int speed = 10;
    public static int gapHeight = 400; // высота промежутка между трубами

    int padding = 100;
    int gapY;
    int x;
    int distanceBetweenTubes;
    boolean isPointReceived;
    Random random = new Random();
    Texture textureUpperTube;
    Texture textureDownTube;

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

        if (bird.y + bird.height >= gapY + gapHeight / 2 &&
                bird.x + bird.width >= x && bird.x <= x + width) {
            return true;
        }

        if (bird.y <= gapY - gapHeight / 2 &&
                bird.x + bird.width >= x && bird.x <= x + width) {
            return true;
        }
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

    void dispose() {
        textureDownTube.dispose();
        textureUpperTube.dispose();
    }
}