
package spesa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//import org.eclipse.jface.dialogs.MessageDialog;

public class ListaSpesa {

	Alimentare a = new Alimentare();
	NonAlimentare n = new NonAlimentare();
	Data d;
	public double tot = 0;
	public List<Prodotto> carrello = new ArrayList<Prodotto>();

	public ListaSpesa() {
	}

	public void aggiungiProdotto(Prodotto p) {
		try {
			carrello.add(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public void caricaFile() {
		carrello.clear();
		BufferedReader lettore;

		try {
			lettore = new BufferedReader(new FileReader("Scontrino.txt"));
			while (true) {
				try {
					//String line = lettore.readLine();
					String s = lettore.readLine();
					if (s == null)
						break;

					
					String[] parti = s.split(",");
					if (parti[0].equalsIgnoreCase("Alimentare")) {
						Alimentare a = new Alimentare();
						a.setDescr(parti[1]);
						a.setCod(parti[2]);
						a.setPrezzo(Double.parseDouble(parti[3]));
						String[] d = parti[4].split("/");
						Data scadenza = new Data(Integer.parseInt(d[0]),Integer.parseInt(d[1]),Integer.parseInt(d[2]));
						a.setScadenza(scadenza);
						aggiungiProdotto(a);
					} else{
						NonAlimentare n = new NonAlimentare();
						n.setDescr(parti[1]);
						n.setCod(parti[2]);
						n.setPrezzo(Double.parseDouble(parti[3]));
						n.setMateriale(parti[4]);
						aggiungiProdotto(n);						
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("ciao");
					// MessageDialog.openError(shell, "Lettura file", "ERRORE");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
					if (carrello.get(i) instanceof Alimentare == true) {
						a = (Alimentare) p;
						scrittore.write("Alimentare" + ",");
						scrittore.write(a.getDescr() + ",");
						scrittore.write(a.getCod() + ",");
						scrittore.write(a.getPrezzo() + ",");
						scrittore.write(a.getScadenza() + "\r\n");
					} else {
						n = (NonAlimentare) p;
						scrittore.write("Non alimentare" + ",");
						scrittore.write(n.getDescr() + ",");
						scrittore.write(n.getCod() + ",");
						scrittore.write(n.getPrezzo() + ",");
						scrittore.write(n.getMateriale() + "\r\n");
					}

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
