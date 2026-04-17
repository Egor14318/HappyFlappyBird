package ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector3;

import ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.MyGdxGame;
import ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.components.MovingBackground;
import ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.components.PointCounter;
import ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.components.TextButton;


public class ScreenMenu implements Screen {
    MyGdxGame myGdxGame;
    Batch batch;
    TextButton buttonExit;
    TextButton buttonStart;
    MovingBackground background;



    public ScreenMenu(MyGdxGame myGdxGame) {
        this.myGdxGame  = myGdxGame;

        background = new MovingBackground("backgrounds/restart_bg.png");
        buttonExit = new TextButton(50,400,"Exit");
        buttonStart = new TextButton(600,400,"Start");


    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched())
        {
            Vector3 touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (buttonStart.isHit((int) touch.x, (int) touch.y)) {
                myGdxGame.setScreen(myGdxGame.screenGame);
            }
            if (buttonExit.isHit((int) touch.x, (int) touch.y)) {
                Gdx.app.exit();
            }
        }


        myGdxGame.batch.begin();
        background.draw(myGdxGame.batch);
        buttonExit.draw(myGdxGame.batch);
        buttonStart.draw(myGdxGame.batch);
        myGdxGame.batch.end();

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
        buttonStart.dispose();
        buttonExit.dispose();
        background.dispose();

    }
}


