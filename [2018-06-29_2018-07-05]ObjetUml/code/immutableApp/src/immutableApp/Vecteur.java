package immutableApp;

public class Vecteur {
	private final double x;
	private final double y;
	private final double z;
	
	public double getX() {return x;}
	public double getY() {return y;}
	public double getZ() {return z;}
	
	public Vecteur(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vecteur translate(double dx, double dy, double dz ) {
		return new Vecteur(this.x + dx, this.y + dy, this.z + dz);
	}
	
	public Vecteur add(Vecteur other) {
		return new Vecteur(this.x + other.x, this.y + other.y, this.z + other.z);
	}
	
	
	/*
	public void translate2(double dx, double dy, double dz ) {
		this.x += dx;
		this.y += dy;
		this.z += dz;
	}
	*/
	
	@Override
	public String toString() {
		return "Vecteur [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
}
