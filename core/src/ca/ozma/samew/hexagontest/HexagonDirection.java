package ca.ozma.samew.hexagontest;

public enum HexagonDirection {
	
	N	(+0, +1), 
	NE	(+1, +1), 
	SE	(+1, +0),
	S	(+0, -1),
	SW	(-1, -1),
	NW	(-1, +0),
	UNKNOWN(-999,999);
	
	public int x, y;

	
	private HexagonDirection(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Returns hexagon direction, supports overlaps in clockwise rotation
	 * @param dir the direction where 0 is North and 5 NorthWest
	 * @return the direction after overlaps / wrapping
	 */
	public static HexagonDirection getDir(int dir){
		switch(dir % 6) {
		case 0:
			return N;
		case 1:
			return NE;
		case 2:
			return SE;
		case 3:
			return S;
		case 4:
			return SW;
		case 5:
			return NW;
		default:
			return UNKNOWN;
		}
	}
	
}
