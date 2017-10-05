/**
 * 
 */
package ca.ozma.samew.hexagontest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * @author Davis
 *
 */
public class HexagonTile {
	
	
	// center of screen
    static float offsetX = 1280 / 2;
    static float offsetY = 720 / 2;
    
    // cord center
    static float centerCordX = 11, centerCordY = 11;
	
    Sprite sprite;
    static Texture texture;
    
    static float faceRadius = new Double(215.0 * Math.cos(30.0 * (Math.PI/180.0))).floatValue(); // for y
    static float edgeRadius = 215f; // for x
    
    float x, y;
    HexagonTile[] tiles = new HexagonTile[6];
    
    BitmapFont font;
    int cordX, cordY;
    
    /**
     * makes a hexagon tilea at x and y
     * @param x
     * @param y
     */
    public HexagonTile(float x, float y) {
    	
    	cordX = Math.round(x);
    	cordY = Math.round(y);
    	
        if (texture == null) {
            texture = new Texture(Gdx.files.internal("hexagon-fill.png"));
        }
        
        sprite = new Sprite(texture);
        font = new BitmapFont();
        font.getData().scale(2.5f);
        
        this.y = (offsetX - (sprite.getHeight() / 2f));
        if ((x - centerCordX) == 0) {
        	this.y += (y - centerCordY) * faceRadius * 2.0f;
        } else {
        	this.y += (y - centerCordY) * faceRadius * 1.0f;
        }
        
        this.x = (offsetY - (sprite.getWidth() / 2f));
        this.x += (x - centerCordX) * edgeRadius * 1.5f;
        
        
    }
    
    /**
     * Renders the sprite
     * @param batch
     */
    public void render(Batch batch) {
        batch.draw(sprite, x, y);
        font.draw(batch, "[" + cordX + ", " + cordY + "]", x + edgeRadius - 75, y + faceRadius);
    }
}
