package exempleObjetAvance;

// par defaut, toutes les classes en java, si on ne spécifier pas d'heritage
// herite de la classe Object
public abstract class Figure /*extends Object*/ {
	private int x;
	private int y;
	
	public int getX() {return x;}
	public void setX(int x) {this.x = x;}
	public int getY() {return y;}
	public void setY(int y) {this.y = y;}
	
	public Figure(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	// méthode abstraite
	protected abstract void dessiner();
	
	
}
