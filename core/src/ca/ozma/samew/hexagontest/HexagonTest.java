package ca.ozma.samew.hexagontest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;

public class HexagonTest extends ApplicationAdapter {
	
	static float camMove = 50f;
	
	SpriteBatch batch;
	Texture img;
	HexagonBoard board;
	
	Camera cam;
	Viewport view;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		board = new HexagonBoard(10);
		board.buildBoard();
		
	}

	@Override
	public void render () {
		act();
		
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		
		Gdx.gl.glClearColor(0.75f, 0.8f, 1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
	    board.render(batch);
		batch.end();
	}
	
	private void act() {
		if (Gdx.input.isKeyPressed(Keys.W)) {
			cam.translate(0f, camMove, 0f);
		}
		
		if (Gdx.input.isKeyPressed(Keys.A)) {
			cam.translate(-camMove, 0f, 0f);
		}
		
		if (Gdx.input.isKeyPressed(Keys.S)) {
			cam.translate(0f, -camMove, 0f);
		}
		
		if (Gdx.input.isKeyPressed(Keys.D)) {
			cam.translate(camMove, 0f, 0f);
		}
		
		if (Gdx.input.isKeyPressed(Keys.NUM_1)) {
			cam.viewportWidth = cam.viewportWidth * 1.2f;
			cam.viewportHeight = cam.viewportHeight * 1.2f;
		}
		
		if (Gdx.input.isKeyPressed(Keys.NUM_2)) {
			cam.viewportWidth = cam.viewportWidth / 1.2f;
			cam.viewportHeight = cam.viewportHeight / 1.2f;
		}
		
	}
	
	@Override
	public void resize(int width, int height) {
		cam = new OrthographicCamera(width * 2, height * 2);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
