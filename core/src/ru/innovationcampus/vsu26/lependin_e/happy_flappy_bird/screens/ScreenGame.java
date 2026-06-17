package ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.characters.Bird;
import ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.characters.Tube;
import ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.components.MovingBackground;
import ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.MyGdxGame;
import ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird.components.PointCounter;

public class ScreenGame implements Screen {

    ScreenRestart screenRestart;
    Bird bird;
    PointCounter pointCounter;
    MovingBackground background;
    int gamePoints;
    boolean isGameOver;
    MyGdxGame myGdxGame;
    Tube[] tubes;
    int tubeCount = 3;
    final int pointCounterMarginTop = 60;
    final int pointCounterMarginRight = 400;

    // Параметры сложности
    public static int speed = 7;
    public static int bwidth = 240;
    public static int bheight = 160;
    public static int birdSpeed = 7;

    public ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        pointCounter = new PointCounter(MyGdxGame.SCR_WIDTH - pointCounterMarginRight, MyGdxGame.SCR_HEIGHT - pointCounterMarginTop);
        background = new MovingBackground("backgrounds/game_bg.png");
        applyDifficulty();
        initGame();
    }


    private void applyDifficulty() {

        speed = 7;
        bwidth = 240;
        bheight = 160;
        birdSpeed = 7;

        //Tube параметры
        Tube.speed = 10;
        Tube.width = 200;
        Tube.height = 700;
        Tube.gapHeight = 400;

        int diff = ScreenMenu.difficult;
        System.out.println("Applying difficulty: " + diff);

        if (diff == 1) {
            // Лёгкая сложность - значения по умолчанию
            System.out.println("Difficulty: EASY");
        } else if (diff == 2) {
            // Средняя сложность
            speed = 10;
            bwidth = 220;
            bheight = 150;
            birdSpeed = 8;
            Tube.speed = 12;
            Tube.width = 220;
            Tube.height = 750;
            Tube.gapHeight = 350;
            System.out.println("Difficulty: MEDIUM");
        } else if (diff == 3) {
            // Сложная сложность
            speed = 12;
            bwidth = 200;
            bheight = 140;
            birdSpeed = 9;
            Tube.speed = 14;
            Tube.width = 230;
            Tube.height = 770;
            Tube.gapHeight = 300;
            System.out.println("Difficulty: HARD");
        }
    }

    private void initGame() {
        bird = new Bird(20, MyGdxGame.SCR_HEIGHT / 2, birdSpeed, bwidth, bheight);
        initTubes();
    }

    @Override
    public void show() {
        isGameOver = false;
        gamePoints = 0;
        applyDifficulty();
        bird.setY(MyGdxGame.SCR_HEIGHT / 2);
        initTubes();
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()) {
            System.out.println("Just touched");
            bird.onClick();
        }

        background.move();
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
            } else if (tube.needAddPoint(bird)) {
                gamePoints += 1;
                tube.setPointReceived();
                System.out.println(gamePoints);
            }
        }

        if (isGameOver) {
            myGdxGame.screenRestart.gamePoints = gamePoints;
            myGdxGame.setScreen(myGdxGame.screenRestart);
        }

        myGdxGame.batch.begin();
        background.draw(myGdxGame.batch);
        bird.draw(myGdxGame.batch);
        pointCounter.draw(myGdxGame.batch, gamePoints);
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
        background.dispose();
    }
}