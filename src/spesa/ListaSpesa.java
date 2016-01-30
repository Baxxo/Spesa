package spesa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;

public class ListaSpesa {

	Alimentare a = new Alimentare();
	NonAlimentare n = new NonAlimentare();
	Data d;
	public double tot = 0;
	public List<Prodotto> carrello = new ArrayList<Prodotto>();

	public ListaSpesa() {
	}

	public void aggiungiProdotto(Prodotto p) {
		carrello.add(p);
	}

	public double calcolaTotale(boolean Tessera) {
		if (Tessera == false) {
			for (int i = 0; i < carrello.size(); i++) {
				tot += carrello.get(i).getPrezzo();
			}
		} else {
			for (int i = 0; i < carrello.size(); i++) {
				if (carrello.get(i) instanceof Alimentare == true) {
					a = (Alimentare) carrello.get(i);
					a.applicaSconto();
					tot = tot + a.getPrezzo();
				} else {
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

	public void leggiFile() {
		BufferedReader lettore;
		String riga = "";
		String testo = "";
		try {
			lettore = new BufferedReader(new FileReader("prova.txt"));
			do {
				testo = testo + riga + "\n";
				riga = lettore.readLine();
			} while (riga != null);
			// MessageDialog.openInformation(shell, "Lettura file", "Riga: " +
			// testo);
			System.out.println(testo);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			// MessageDialog.openError(shell, "Lettura file", "ERRORE");
			System.out.println("ERRORE");
		}

	}

	public void salvaFile() {
		BufferedWriter scrittore;
		try {
			scrittore = new BufferedWriter(new FileWriter("Scontrino.txt", true));

			for (int i = 0; i < carrello.size(); i++) {
				Prodotto p = carrello.get(i);
				try {
					scrittore.write(p.getDescr() + "\n");
					scrittore.write(p.getCod() + "\n");

					// MessageDialog.openInformation(shell, "Scrittura file",
					// "TUTTO OK");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					// MessageDialog.openError(shell, "Scrittura file",
					// "ERRORE");
				}
			}

			scrittore.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // NB true per APPEND

	}

}
