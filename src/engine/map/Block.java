package engine.map;

/**
 * 
 * 
 * @author Samy, Mélissa, Billel
 * Cette classe déclare les lignes et les colonnes pour la map
 */
public class Block {
	private int line;
	private int column;

	public Block(int line, int column) {
		this.line = line;
		this.column = column;
	}
	
	public boolean Null() {
		if(line==0 && column==0) {
			return true;
		}
		else {
			return false;
		}
	}
	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public String toString() {
		return "Block [line=" + line + ", column=" + column + "]";
	}

}
