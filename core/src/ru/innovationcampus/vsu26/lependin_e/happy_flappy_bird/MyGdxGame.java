package ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends Game  {
	public static final int SCR_WIDTH = 800; //1280
	public static final int SCR_HEIGHT = 600; //720
	public OrthographicCamera camera;
	SpriteBatch batch;

	ScreenGame screenGame;


	@Override
	public void create() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);



		screenGame = new ScreenGame(this);
		setScreen(screenGame);
	}







	
	@Override
	public void dispose () {
		batch.dispose();


	}

}


