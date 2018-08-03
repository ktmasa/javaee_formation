package collectionsEtGeneriquesForm;
// couple est parametre par 2 types T1 et T2, T1 doit etre comparable avec un autre T1
public class Couple <T1 extends Comparable<T1>, T2>  implements Comparable<Couple<T1, T2>>
{
	private T1 valeur1;
	private T2 valeur2;
	
	public T1 getValeur1() {return valeur1;}
	public void setValeur1(T1 valeur1) {this.valeur1 = valeur1;}
	public T2 getValeur2() {return valeur2;}
	public void setValeur2(T2 valeur2) {this.valeur2 = valeur2;}
	
	public Couple(T1 valeur1, T2 valeur2) {
		super();
		this.valeur1 = valeur1;
		this.valeur2 = valeur2;
	}
	@Override
	public String toString() {
		return "Couple [valeur1=" + valeur1 + ", valeur2=" + valeur2 + "]";
	}
	
	@Override
	public int compareTo(Couple<T1, T2> o) {
		return getValeur1().compareTo(o.getValeur1());
	}
	
	
}
