package spesa;

public class Prodotto {
	protected String cod = new String();
	protected String descr = new String();
	protected double prezzo;

	public Prodotto(String cod, String descr, double prezzo) {
		this.cod = cod;
		this.descr = descr;
		this.prezzo = prezzo;
	}

	public Prodotto() {
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String toString() {
		return "Prodotto [cod=" + cod + ", descr=" + descr + ", prezzo=" + prezzo + "]";
	}

	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}
