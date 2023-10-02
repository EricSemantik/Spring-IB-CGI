package spring.formation;

public class Pianiste implements IMusicien {

	private IInstrument instrument;
	private String morceau;

	public Pianiste() {
		super();
	}

	public Pianiste(IInstrument instrument) {
		super();
		this.instrument = instrument;
	}

	@Override
	public void jouer() {
		System.out.println("Le pianiste joue : " + this.morceau + "(" + this.instrument.toString() + ")");

	}

}
