/**
 * 
 */
package ca.ozma.samew.hexagontest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * @author Davis
 *
 */
public class HexagonTile {
	
	// mark first
	static boolean first = true;
	
	// center of screen
    static float offsetX = 1280 / 2;
    static float offsetY = 720 / 2;
    
    // cord center
    static float centerCordX = 11, centerCordY = 11;
	
    Sprite sprite;
    Sprite centerMarkSprite;
    static Texture texture;
    static Texture centerMarkTexture;
    static Texture firstMarkTexture;
    
    static float faceRadius = new Double(215.0 * Math.cos(30.0 * (Math.PI/180.0))).floatValue(); // for y
    static float edgeRadius = 215f; // for x
    
    float x, y, markX, markY;
    HexagonTile[] tiles = new HexagonTile[6];
    
    /**
     * makes a hexagon tilea at x and y
     * @param x
     * @param y
     */
    public HexagonTile(float x, float y) {
        if (texture == null) {
            texture = new Texture(Gdx.files.internal("hexagon-fill.png"));
            centerMarkTexture = new Texture(Gdx.files.internal("centermark.png"));
            firstMarkTexture = new Texture(Gdx.files.internal("firstmark.png"));
        }
        
        if (first) {
        	first = false;
        	centerMarkSprite = new Sprite(firstMarkTexture);
        	centerMarkSprite.scale(2f);
        } else {
        	centerMarkSprite = new Sprite(centerMarkTexture);
        }
        
        sprite = new Sprite(texture);
        
        this.x = offsetX - (sprite.getWidth() / 2f) + (Math.abs(x - centerCordX) * edgeRadius * 2f);
        
        if (x % 2 == 0) {
        	this.y = offsetY - (sprite.getHeight() / 2f) + (Math.abs(y - centerCordY) * faceRadius * 2f);
        } else {
        	this.y = offsetY - (sprite.getHeight() / 2f) + ((Math.abs(y - centerCordY) + 1f) * faceRadius * 2f);
        }
        	
        //this.x = offsetX - sprite.getWidth() / 2f + (x * edgeRadius * 2);
        //this.y = offsetY - sprite.getHeight() / 2f + (y * faceRadius * 2);
        
        markX = offsetX - centerMarkSprite.getWidth() / 2f + (x * edgeRadius * 2);
        markY = offsetY - centerMarkSprite.getHeight() / 2f + (y * faceRadius * 2);
        
        
    }
    
    /**
     * Renders the sprite
     * @param batch
     */
    public void render(Batch batch) {
        batch.draw(sprite, x, y);
        batch.draw(centerMarkSprite, markX, markY);
    }
}
