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
    	
    	cordX = Math.round(x) - 11;
    	cordY = Math.round(y) - 11;
    	
        if (texture == null) {
            texture = new Texture(Gdx.files.internal("hexagon-fill.png"));
        }
        
        sprite = new Sprite(texture);
        font = new BitmapFont();
        font.getData().scale(2.5f);
        
        
        this.x = cordX * edgeRadius * 1.5f;
        this.y = cordY * faceRadius * 2.0f;
        this.y -= cordX * faceRadius;

        
    }
    
    /**
     * Renders the sprite
     * @param batch
     */
    public void render(Batch batch) {
        batch.draw(sprite, x, y);
        font.draw(batch, "[" + (cordX + centerCordY) + ", " + (cordY + centerCordY)+ "]", x + edgeRadius - 90, y + faceRadius);
    }
}
