/**
 * 
 */
package ca.ozma.samew.hexagontest;

import com.badlogic.gdx.graphics.g2d.Batch;

/**
 * @author Davis
 *
 */
public class HexagonBoard {
    
	static int[] clockwiseOne = {0, 10, 10, 9, 9, 8, 7, 6, 5, 3, 1};
    
    // raidus to vertex
    static float tileR = 215;
    
    // raidus to face
    static float tileR2 = (float) (tileR * Math.sin(60f * (Math.PI * 2 / 360f)));
    HexagonTile center;
    
    HexagonTile[][] tiles;
    int r;
    int arrayCenterX, arrayCenterY;
    
    /**
     * 
     * @param r the radius to the face of a hexagon not including the center tile 
     */
    public HexagonBoard(int r) {
        this.r = r;
        arrayCenterX = r + 1;
        arrayCenterY = r + 1;
        tiles = new HexagonTile[r * 2 + 2][r * 2 + 2];
    }
    
    /**
     * Builds the board based on value of r
     */
    public void buildBoard() {
        tiles[11][11] = new HexagonTile(11, 11);
        center = tiles[11][11];
        
        // rest of the tiles
        for (int i = 1; i <= r; i++) { // go in one direction
        	HexagonDirection dir1 = HexagonDirection.getDir(0);
        	int xPos1 = 11 + (dir1.x * i);
        	int yPos1 = 11 + (dir1.y * i);
    		tiles[xPos1][yPos1] = new HexagonTile(xPos1, yPos1);
        		
        	for (int j = 1; j < clockwiseOne[i]; j++) { // do the other ones in direction "+1" 
        		HexagonDirection dir2 = HexagonDirection.getDir(1);
        		int xPos2 = 11 + (dir2.x * j);
        		int yPos2 = 11 + (dir2.x * j);
        		tiles[xPos2][yPos2] = new HexagonTile(xPos2, yPos2);
        		
        	}	
        }
    }
    
    /**
     * Calls render on all of the tiles
     * @param batch
     */
    public void render(Batch batch) {
        for (int x = 0; x < tiles.length; x++)
            for (int y = 0; y < tiles[0].length; y++)
                if (tiles[x][y] != null)
                    tiles[x][y].render(batch);
    }
    
}
