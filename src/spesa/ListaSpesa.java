package spesa;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaSpesa {
	
	Alimentare a = new Alimentare();
	NonAlimentare n = new NonAlimentare();
	Data d;
	public double tot = 0;

	public ListaSpesa() {
	}

	public void aggiungiProdotto(Prodotto p) {
		carrello.add(p);
	}

	public double calcolaTotale(boolean Tessera) {
		if(Tessera == false){
			for (int i = 0; i < carrello.size(); i++) {
				tot += carrello.get(i).getPrezzo();
			}			
		}else{
			for (int i = 0; i < carrello.size(); i++) {
				if(carrello.get(i) instanceof Alimentare == true){
					a = (Alimentare) carrello.get(i);
					a.applicaSconto();
					tot = tot + a.getPrezzo();
				}else{
					n = (NonAlimentare) carrello.get(i);
					n.applicaSconto();
					tot = tot + n.getPrezzo();
				}
			}
		}
		System.out.println("Prezzo: " + tot);
		return tot;
	}

	public void eliminaProdotto(int index) {
		carrello.remove(index);
	}

	public List<Prodotto> carrello = new ArrayList<Prodotto>();

	public String leggiStringa(BufferedReader br) {
		try {
			return br.readLine();
		} catch (IOException e) {
			System.out.println("ERRORE");
			return leggiStringa(br);
		}
	}

	public int leggiInt(BufferedReader br) {
		return Integer.parseInt(leggiStringa(br));
	}
}
