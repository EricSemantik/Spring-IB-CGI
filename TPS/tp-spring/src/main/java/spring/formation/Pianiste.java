package spring.formation;

import javax.annotation.PostConstruct;

public class Pianiste implements IMusicien {

	private IInstrument instrument;
	private String morceau;

	public Pianiste() {
		super();
		System.out.println("Pianiste Constructeur : " + this.morceau);
	}

	public Pianiste(IInstrument instrument) {
		super();
		this.instrument = instrument;
	}

	public Pianiste(IInstrument instrument, String morceau) {
		super();
		this.instrument = instrument;
		this.morceau = morceau;
	}

	@Override
	public void jouer() {
		System.out.println("Le pianiste joue : " + this.morceau + "(" + this.instrument.toString() + ")");

	}

	public IInstrument getInstrument() {
		return instrument;
	}

	public void setInstrument(IInstrument instrument) {
		this.instrument = instrument;
	}

	public String getMorceau() {
		return morceau;
	}

	public void setMorceau(String morceau) {
		this.morceau = morceau;
	}
	
	@PostConstruct
	public void apresInjection() {
		System.out.println("Pianiste - Après injection : " + this.morceau);
	}

}
