/**
 * Schoenes Abrechnungsartengeruest zum noch leichteren Hinzufuegen von neuen Abrechnungsartens
 * via Lambda Expressions
 * 
 * @author Tim Wende
 *
 */
public class Abrechnungsart implements IAbrechnungsart {
	String bezeichnung;
	IBerechne berechne;
	int kosten;
	
	public Abrechnungsart(String bezeichnung, IBerechne berechne) {
		this.bezeichnung = bezeichnung;
		this.berechne = berechne;
	}

	@Override
	public void setKosten(int kosten) {
		this.kosten = kosten;		
	}

	@Override
	public int makeRechnung() {
		return berechne.makeRechnung(kosten);
	}

	@Override
	public String getAbrechnungsart() {
		return bezeichnung;
	}

}
