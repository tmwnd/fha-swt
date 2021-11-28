/**
 * Weitere Abrechungsart, welche leicht hinzugefuegt wurde
 * 
 * @author Tim Wende
 *
 */
public class ZahleProZeichen implements IAbrechnungsart {
	int kosten;
	Nachrichtenkanal nachrichtenkanal;
	
	/**
	 * default ctor
	 * 
	 * @param nachrichtenkanal Nachrichtenkanal
	 */
	public ZahleProZeichen(Nachrichtenkanal nachrichtenkanal) {
		this.nachrichtenkanal = nachrichtenkanal;
	}
	
	@Override
	public void setKosten(int kosten) {
		this.kosten = kosten;		
	}

	@Override
	public int makeRechnung() {
		return -1 * nachrichtenkanal.getContent().length() * kosten;
	}

	@Override
	public String getAbrechnungsart() {
		return "ZahleProZeichen";
	}

}
