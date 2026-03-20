package ru.innovationcampus.vsu26.lependin_e.happy_flappy_bird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	public static final int SCR_WIDTH = 800; //1280
	public static final int SCR_HEIGHT = 600; //720
	SpriteBatch batch;

	Texture birdTexture;
	int birdX = 0;
	int birdY = 0;
	int birdSpeed = 5;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		birdTexture = new Texture("bird0.png");



	}

	@Override
	public void render () {
		birdX += birdSpeed;
		birdY += birdSpeed;
		ScreenUtils.clear(0.15f,0.15f, 0.15f, 0.15f);
		batch.begin();
		batch.draw(birdTexture, birdX, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		birdTexture.dispose();

	}
}
