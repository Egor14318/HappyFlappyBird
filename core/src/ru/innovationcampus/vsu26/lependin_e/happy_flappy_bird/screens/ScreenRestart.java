package ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.MyGdxGame;

public class ScreenRestart implements Screen {

    MyGdxGame myGdxGame;

    public ScreenRestart(MyGdxGame myGdxGame) {
        this.myGdxGame  = myGdxGame;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta){
            ScreenUtils.clear(1, 0, 0, 1);
            myGdxGame.camera.update();
            myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);


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

    }
}

