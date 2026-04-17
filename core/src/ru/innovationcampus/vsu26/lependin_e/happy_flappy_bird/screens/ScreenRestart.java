package ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.MyGdxGame;
import ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.components.MovingBackground;
import ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.components.PointCounter;
import ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.components.TextButton;

public class ScreenRestart implements Screen {


    TextButton buttonRestart;
    TextButton buttonMenu;
    MovingBackground background;
    MyGdxGame myGdxGame;
    PointCounter pointCounter;
    int gamePoints;

    public ScreenRestart(MyGdxGame myGdxGame) {
        this.myGdxGame  = myGdxGame;
        buttonRestart = new TextButton(100,400,"Restart");
        background = new MovingBackground("backgrounds/restart_bg.png");
        pointCounter = new PointCounter(700,400);
        buttonMenu = new TextButton(100,200, "Main Menu");

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta){
            if (Gdx.input.justTouched()){
                Vector3 touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
                if (buttonRestart.isHit((int)touch.x, (int) touch.y)){
                    myGdxGame.setScreen(myGdxGame.screenGame);
                }
                if (buttonMenu.isHit((int) touch.x,(int) touch.y)){
                    myGdxGame.setScreen(myGdxGame.screenMenu);
                }
            }

            ScreenUtils.clear(1, 0, 0, 1);
            myGdxGame.camera.update();
            myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);




            myGdxGame.batch.begin();
            background.draw(myGdxGame.batch);
            buttonRestart.draw(myGdxGame.batch);
            pointCounter.draw(myGdxGame.batch, gamePoints);
            buttonMenu.draw(myGdxGame.batch);
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
        buttonRestart.dispose();
        background.dispose();
    }
}

