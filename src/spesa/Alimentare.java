package spesa;

class Alimentare extends Prodotto {

	Data scadenza;
	private double p = 0;

	public double getP() {
		return p;
	}

	public Alimentare(String cod, String descr, double prezzo, Data scadenza) {
		super(cod, descr, prezzo);
		this.scadenza = scadenza;
	}

	public Alimentare() {
		// TODO Auto-generated constructor stub
	}

	public void applicaSconto(Data oggi){
		p = prezzo;
		if (scadenza.getDifference(oggi) > 10) {
			p -= prezzo / 100 * 20;
		}
	}
}
