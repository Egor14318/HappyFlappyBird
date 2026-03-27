package ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class ScreenGame implements Screen {

    Bird bird;

    MyGdxGame myGdxGame;


    ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        bird = new Bird(0,0, 2,240,160);
    }

    @Override
    public void show() {}


    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()){
            System.out.println("Just touched");
        }
        bird.fly();


        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        myGdxGame.batch.begin();
        bird.draw(myGdxGame.batch);
        myGdxGame.batch.end();
    }


    @Override
    public void resize(int width, int height) {}


    @Override
    public void pause() {}


    @Override
    public void resume() {}


    @Override
    public void hide() {}


    @Override
    public void dispose() {
        bird.dispose();
    }

}

