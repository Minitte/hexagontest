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
    
	static int[] clockwiseOne = {0, 10, 9, 9, 8, 8, 7, 6, 5, 3, 1};
    

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
        arrayCenterX = r + 4;
        arrayCenterY = r + 4;
        tiles = new HexagonTile[r * 2 + 8][r * 2 + 8];
    }
    
    /**
     * Builds the board based on value of r
     */
    public void buildBoard() {
        tiles[arrayCenterX][arrayCenterY] = new HexagonTile(arrayCenterX, arrayCenterY);
        center = tiles[arrayCenterX][arrayCenterY];
        
        // rest of the tiles
        
        for(int dir = 0; dir < 6; dir++){
        
	        for (int i = 1; i <= r; i++) { // go in one direction
	        	HexagonDirection dir1 = HexagonDirection.getDir(dir);
	        	int xPos1 = arrayCenterX + (dir1.x * i);
	        	int yPos1 = arrayCenterY + (dir1.y * i);
	    		tiles[xPos1][yPos1] = new HexagonTile(xPos1, yPos1);
	        		
	    		
	    		
	        	for (int j = 1; j <= clockwiseOne[i]; j++) { // do the other ones in direction "+1" 
	        		HexagonDirection dir2 = HexagonDirection.getDir(dir+1);
	        		int xPos2 = xPos1 + (dir2.x * j);
	        		int yPos2 = yPos1 + (dir2.y * j);
	        		tiles[xPos2][yPos2] = new HexagonTile(xPos2, yPos2);
	        		
	        	}	
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
