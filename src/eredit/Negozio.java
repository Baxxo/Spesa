package eredit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Negozio {

	public static ListaSpesa ls = new ListaSpesa();

	private static Prodotto[] inventario = { new Alimentare("4134", "Una Mela", 0.15, new Data(22, 1, 2016)),
			new Alimentare("4634", "Una Pera", 0.20, new Data(26, 1, 2016)),
			new Alimentare("4164", "Una Banana", 0.35, new Data(10, 1, 2016)) };

	public static void main(String args[]) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int sel = 0;
		int elimina;
		
		while (sel != 99) {
			if (sel == 98) {
				stampaProdotti();
				System.out.println("98 - per eliminare");
				System.out.println("99 - per uscire");
				System.out.println("ins numero prodotto: ");
				elimina = ls.leggiInt(br);
				ls.eliminaProdotto(elimina);
			}
			
			stampaProdotti();
			System.out.println("98 - per eliminare");
			System.out.println("99 - per uscire");
			sel = ls.leggiInt(br);
			if (sel != 99 && sel >= 0 && sel < inventario.length) {
				ls.aggiungiProdotto(inventario[sel]);
			} else {
				System.out.print("");
			}

	
		}
		ls.calcolaTotale();
	}

	private static void stampaProdotti() {
		for (int i = 0; i < inventario.length; i++) {
			System.out.println(i + " - " + inventario[i].getDescr() + " prezzo: " + inventario[i].getPrezzo());
		}
	}

}

/*
 * 
 * String c = new String(); String d = new String(); String f = new String();
 * String pre = new String(); Double pr; Boolean tessera; InputStreamReader i =
 * new InputStreamReader(System.in); BufferedReader br = new BufferedReader(i);
 * 
 * 
 * System.out.print("ins codice: "); try { c = br.readLine(); } catch
 * (IOException e) { e.printStackTrace(); }
 * 
 * System.out.print("ins descrizione: "); try { d = br.readLine(); } catch
 * (IOException e) { e.printStackTrace(); }
 * 
 * System.out.print("ins prezzo: "); try { pre = br.readLine(); } catch
 * (IOException e) { e.printStackTrace(); } pr = Double.parseDouble(pre);
 * 
 * System.out.print("tessera?[0/1]: "); try { f = br.readLine(); } catch
 * (IOException e) { e.printStackTrace(); } tessera = Boolean.parseBoolean(f);
 * Prodotto p = new Prodotto(c, d, pr); System.out.println(p.toString());
 */
