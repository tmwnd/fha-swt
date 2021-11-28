/**
 * Abonnement Klasse
 * 
 * Theoretisch koennte man diese Klasse weglassen und Observer zu einem Abonnement umstrukturieren.
 * Da ich diese Klasse jedoch logisch sinnvoll finde, bleibt alles so wie es hier ist.
 * 
 * @author Tim Wende
 *
 */
public class Abonnement {
	private Observer observer;
	
	/**
	 * default ctor
	 * 
	 * @param observer Observer
	 */
	public Abonnement(Observer observer) {
		this.observer = observer;
	}
	
	/**
	 * toString in schoen
	 */
	public void print() {
		System.out.println(Test.box(observer.toString()));
	}
}
