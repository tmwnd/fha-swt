public class Diskobesuch {
	private static double berechneRabatt(GESCHLECHT geschlecht, int alter, boolean istVerbeamteter) {
		if (alter <= 17)
			throw new IllegalArgumentException("FF 0: alter muss >= 18 sein!");
		if (alter >= 80)
			throw new IllegalArgumentException("FF 1: alter muss <= 79 sein!");
		
		if (geschlecht == null)
			throw new IllegalArgumentException("F 2: geschlecht darf nicht null sein");
		
		System.out.print("(" + geschlecht + ", " + alter + ") ist "
			+ ((istVerbeamteter) ? "" : "kein ") + "Beamter; "
			+ ((istVerbeamteter) ? " ".repeat(5) : "") + "Rabatt: ");
		return (((geschlecht == GESCHLECHT.weiblich) ? 5 + ((alter < 30) ? 2 : 0) : 0)
			+ ((istVerbeamteter) ? 5 : 0)) / 100.;
	}

	public static void main(String[] args) {
		// AK 0
		System.out.println(berechneRabatt(GESCHLECHT.maennlich, 20, false)); // UK 0
		System.out.println(berechneRabatt(GESCHLECHT.maennlich, 20, true)); // UK 1
		System.out.println(berechneRabatt(GESCHLECHT.weiblich, 20, true)); // UK 4
		System.out.println(berechneRabatt(GESCHLECHT.weiblich, 20, false)); // UK 2
		System.out.println(berechneRabatt(GESCHLECHT.weiblich, 79, true)); // UK 3
		System.out.println(berechneRabatt(GESCHLECHT.weiblich, 79, false)); // UK 1
		System.out.println(berechneRabatt(GESCHLECHT.maennlich, 79, true)); // UK 1
		System.out.println(berechneRabatt(GESCHLECHT.maennlich, 79, false)); // UK 0

		// AK 1; FF 0
//		System.out.println(berechneRabatt(GESCHLECHT.maennlich, -7, false));
//		System.out.println(berechneRabatt(GESCHLECHT.maennlich, 17, false));
		
		// AK 1; FF 1
//		System.out.println(berechneRabatt(GESCHLECHT.maennlich, 80, false));
//		System.out.println(berechneRabatt(GESCHLECHT.maennlich, Integer.MAX_VALUE, false));
		
		// AK 1; FF 2
//		System.out.println(berechneRabatt(null, 20, false));
	}

	private enum GESCHLECHT {
		maennlich, weiblich, divers
	}
}
