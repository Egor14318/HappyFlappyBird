package ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

public class ScreenGame implements Screen {

    Bird bird;


    boolean isGameOver;
    MyGdxGame myGdxGame;
    Tube[] tubes;
    int tubeCount = 3;


    ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        bird = new Bird(0, 0, 2, 240, 160);
        initTubes();
    }

    @Override
    public void show(){
        isGameOver = false;
    }


    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()) {
            System.out.println("Just touched");
            bird.onClick();
        }
        bird.fly();
        if (!bird.isInField()) {
            System.out.println("not in field");
            isGameOver = true;
        }

        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        for (Tube tube : tubes) {
            tube.move();
            if (tube.isHit(bird)) {
                System.out.println("hit");
                isGameOver = true;
            }
        }
        myGdxGame.batch.begin();
        bird.draw(myGdxGame.batch);

        for (Tube tube : tubes) tube.draw(myGdxGame.batch);

        myGdxGame.batch.end();
    }


    public void initTubes() {
        tubes = new Tube[tubeCount];
        for (int i = 0; i < tubeCount; i++) {
            tubes[i] = new Tube(tubeCount, i);
        }
    }


    @Override
    public void resize(int width, int height) {
    }


    @Override
    public void pause() {
    }


    @Override
    public void resume() {
    }


    @Override
    public void hide() {
    }


    @Override
    public void dispose() {
        bird.dispose();
    }

}

