package spesa;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.DateTime;

public class Spesagrafica {

	protected Shell shell;

	Negozio n = new Negozio();
	private int l = n.inventario.length;
	private int j = 0;
	private int g;
	private int m;
	private int y;
	private boolean isAlimentare;
	private boolean isScontrino = false;
	private boolean isTessera = false;
	private double prezzo;
	private String textBox;
	private String tot;
	private String cod;
	private String descr;
	private String materiale;
	private String pr;
	private Data scadenza;
	private Alimentare newAlimentare;
	private NonAlimentare newNonAlimentare;
	private List list;
	private List list_1;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_6;
	private Text text_7;
	private Button btnElimina;
	private Button btnRistampa;
	private Button btnTessera;
	private Button btnCassa;
	private Button btnScontrino;
	private Button btnEliminaProdotto;
	private Button btnInserisciProdotto;
	private Button btnAlimentare;
	private Button btnNonAlimentare;
	private Button btnProdotto;
	private Label lblProdotti;
	private Label lblNegozio;
	private Label lblTotale;
	private Label lblCod;
	private Label lblPrezzo;
	private Label lblDescrizione;
	private Label lblScadenza;
	private Label lblMateriale;
	private Label lblPrezzo_1;
	private Label lblCarrello;
	private DateTime dateTime;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Spesagrafica window = new Spesagrafica();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public void ristampa() {
		list_1.setVisible(true);
		btnElimina.setVisible(true);
		btnAlimentare.setVisible(false);
		btnNonAlimentare.setVisible(false);
		btnInserisciProdotto.setVisible(false);
		btnScontrino.setVisible(true);
		lblCod.setVisible(false);
		lblDescrizione.setVisible(false);
		lblMateriale.setVisible(false);
		lblPrezzo.setVisible(false);
		lblScadenza.setVisible(false);
		dateTime.setVisible(false);
		stampa();
		stampa1();
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {

		newAlimentare = new Alimentare("0123", "Pera", 0.3, new Data(26, 1, 2016));
		n.inventario[0] = newAlimentare;
		j++;
		newAlimentare = new Alimentare("4567", "Mela", 0.5, new Data(22, 1, 2016));
		n.inventario[1] = newAlimentare;
		j++;
		newAlimentare = new Alimentare("8910", "Banana", 0.7, new Data(10, 1, 2016));
		n.inventario[2] = newAlimentare;
		j++;
		newNonAlimentare = new NonAlimentare("1112", "Bottiglia d'acqua", 1, "plastica");
		n.inventario[3] = newNonAlimentare;
		j++;
		newNonAlimentare = new NonAlimentare("1314", "Bottiglia di birra", 5, "vetro");
		n.inventario[4] = newNonAlimentare;
		j++;
		newNonAlimentare = new NonAlimentare("1516", "cartone di tavernello (no sta ciorlo)", 10, "carta");
		n.inventario[5] = newNonAlimentare;
		j++;

		shell = new Shell();
		shell.setSize(750, 550);
		shell.setText("SWT Application");

		dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(492, 275, 80, 24);
		dateTime.setVisible(false);

		lblNegozio = new Label(shell, SWT.NONE);
		lblNegozio.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		lblNegozio.setBounds(308, 10, 97, 30);
		lblNegozio.setText("NEGOZIO");

		lblProdotti = new Label(shell, SWT.CENTER);
		lblProdotti.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblProdotti.setBounds(112, 67, 62, 15);
		lblProdotti.setText("PRODOTTI");

		lblTotale = new Label(shell, SWT.NONE);
		lblTotale.setBounds(270, 482, 43, 15);
		lblTotale.setText("TOTALE");
		lblTotale.setVisible(false);

		lblCod = new Label(shell, SWT.NONE);
		lblCod.setBounds(443, 144, 43, 15);
		lblCod.setText("Codice:");
		lblCod.setVisible(false);

		lblPrezzo = new Label(shell, SWT.NONE);
		lblPrezzo.setBounds(443, 189, 43, 15);
		lblPrezzo.setText("Prezzo:");
		lblPrezzo.setVisible(false);

		lblDescrizione = new Label(shell, SWT.NONE);
		lblDescrizione.setBounds(418, 235, 68, 15);
		lblDescrizione.setText("Descrizione:");
		lblDescrizione.setVisible(false);

		lblScadenza = new Label(shell, SWT.NONE);
		lblScadenza.setBounds(431, 275, 55, 15);
		lblScadenza.setText("Scadenza:");
		lblScadenza.setVisible(false);

		lblMateriale = new Label(shell, SWT.NONE);
		lblMateriale.setBounds(431, 278, 55, 15);
		lblMateriale.setText("Materiale:");
		lblMateriale.setVisible(false);

		lblPrezzo_1 = new Label(shell, SWT.NONE);
		lblPrezzo_1.setBounds(299, 106, 43, 15);
		lblPrezzo_1.setText("Prezzo:");

		lblCarrello = new Label(shell, SWT.NONE);
		lblCarrello.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblCarrello.setBounds(539, 67, 70, 15);
		lblCarrello.setText("CARRELLO");

		list = new List(shell, SWT.BORDER);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				text_3.setText("");
				;
				list_1.setVisible(true);
				stampa1();
				pr = "" + n.inventario[list.getSelectionIndex()].getPrezzo();
				text_3.setText(pr);
				btnElimina.setVisible(true);
			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				n.ls.aggiungiProdotto(n.inventario[list.getSelectionIndex()]);
			}
		});
		list.setBounds(30, 102, 250, 301);

		list_1 = new List(shell, SWT.BORDER);
		list_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				text_3.setText("");
				System.out.println(n.ls.carrello.get(list_1.getSelectionIndex()));
				pr = "" + n.ls.carrello.get(list_1.getSelectionIndex()).getPrezzo();
				text_3.setText(pr);
			}
		});
		list_1.setBounds(410, 102, 289, 301);

		btnTessera = new Button(shell, SWT.CHECK);
		btnTessera.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				isTessera = true;
			}
		});
		btnTessera.setBounds(516, 481, 93, 16);
		btnTessera.setText("TESSERA");
		btnTessera.setVisible(false);

		btnCassa = new Button(shell, SWT.NONE);
		btnCassa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				text_7.setVisible(true);
				lblTotale.setVisible(true);
				tot = "" + n.ls.calcolaTotale(isTessera);
				text_7.setText(tot);
				n.ls.tot = 0;

			}
		});
		btnCassa.setBounds(632, 477, 75, 25);
		btnCassa.setText("CASSA");

		btnScontrino = new Button(shell, SWT.NONE);
		btnScontrino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				list_1.setVisible(true);
				setScontrino(true);
				btnTessera.setVisible(true);
			}
		});
		btnScontrino.setBounds(553, 409, 75, 25);
		btnScontrino.setText("SCONTRINO");

		btnElimina = new Button(shell, SWT.NONE);
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				n.ls.eliminaProdotto(list_1.getSelectionIndex());
				list_1.remove(list_1.getSelectionIndex());
				ristampa();
			}
		});
		btnElimina.setBounds(443, 409, 75, 25);
		btnElimina.setText("ELIMINA");

		btnEliminaProdotto = new Button(shell, SWT.NONE);
		btnEliminaProdotto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				int sel = list.getSelectionIndex();
				for (int i = sel; i < j; i++) {
					n.inventario[i] = n.inventario[i++];
				}
				j--;
				ristampa();
			}
		});
		btnEliminaProdotto.setBounds(90, 419, 128, 25);
		btnEliminaProdotto.setText("ELIMINA PRODOTTO");

		btnInserisciProdotto = new Button(shell, SWT.NONE);
		btnInserisciProdotto.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});

		text = new Text(shell, SWT.BORDER);
		text.setBounds(492, 141, 170, 21);
		text.setVisible(false);

		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(492, 186, 170, 21);
		text_1.setVisible(false);

		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(492, 232, 170, 21);
		text_2.setVisible(false);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(348, 103, 37, 21);

		text_6 = new Text(shell, SWT.BORDER);
		text_6.setBounds(492, 275, 170, 21);
		text_6.setVisible(false);

		text_7 = new Text(shell, SWT.BORDER);
		text_7.setBounds(348, 479, 76, 21);
		text_7.setVisible(false);

		btnAlimentare = new Button(shell, SWT.RADIO);
		btnAlimentare.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				list_1.setVisible(false);
				btnInserisciProdotto.setVisible(true);
				if (btnAlimentare.getSelection() == true) {
					isAlimentare = true;
					text.setVisible(true);
					text_1.setVisible(true);
					text_2.setVisible(true);
					lblCod.setVisible(true);
					lblPrezzo.setVisible(true);
					lblDescrizione.setVisible(true);
					lblScadenza.setVisible(true);
					dateTime.setVisible(true);
					text_6.setVisible(false);
					btnElimina.setVisible(false);
					lblMateriale.setVisible(false);
				}
			}
		});
		btnAlimentare.setBounds(443, 66, 90, 16);
		btnAlimentare.setText("Alimentare");
		btnAlimentare.setVisible(false);

		btnNonAlimentare = new Button(shell, SWT.RADIO);
		btnNonAlimentare.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				list_1.setVisible(false);
				btnInserisciProdotto.setVisible(true);
				if (btnNonAlimentare.getSelection() == true) {
					isAlimentare = false;
					text.setVisible(true);
					text_1.setVisible(true);
					text_2.setVisible(true);
					text.setVisible(true);
					text_6.setVisible(true);
					lblCod.setVisible(true);
					lblPrezzo.setVisible(true);
					lblMateriale.setVisible(true);
					lblDescrizione.setVisible(true);
					dateTime.setVisible(false);
					btnElimina.setVisible(false);
					lblScadenza.setVisible(false);
				}
			}
		});
		btnNonAlimentare.setText("Non Alimentare");
		btnNonAlimentare.setBounds(555, 65, 107, 16);
		btnNonAlimentare.setVisible(false);

		btnProdotto = new Button(shell, SWT.NONE);
		btnProdotto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				btnAlimentare.setVisible(true);
				btnNonAlimentare.setVisible(true);
				btnElimina.setVisible(false);
				btnScontrino.setVisible(false);
				list_1.setVisible(false);
				text.setVisible(false);
				text_1.setVisible(false);
				text_2.setVisible(false);
				lblCod.setVisible(false);
				lblDescrizione.setVisible(false);
				lblMateriale.setVisible(false);
				lblScadenza.setVisible(false);
				lblPrezzo.setVisible(false);
				lblCarrello.setVisible(false);
				dateTime.setVisible(false);
				text_6.setVisible(false);
				btnInserisciProdotto.setVisible(false);
				text.setText("");
				text_1.setText("");
				text_2.setText("");
				text_6.setText("");
			}
		});
		btnProdotto.setBounds(534, 15, 75, 25);
		btnProdotto.setText("PRODOTTO");

		btnRistampa = new Button(shell, SWT.NONE);
		btnRistampa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ristampa();
			}
		});
		btnRistampa.setBounds(76, 17, 75, 25);
		btnRistampa.setText("RISTAMPA");

		btnInserisciProdotto.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				list_1.setVisible(false);
				if (j < 100) {
					if (isAlimentare == true) {
						cod = text.getText();
						prezzo = Double.parseDouble(text_1.getText());
						descr = text_2.getText();
						g = dateTime.getDay();
						m = dateTime.getMonth();
						y = dateTime.getYear();
						scadenza = new Data(g, m, y);
						n.inventario[j] = new Alimentare(cod, descr, prezzo, scadenza);
					} else {
						cod = text.getText();
						prezzo = Double.parseDouble(text_1.getText());
						descr = text_2.getText();
						materiale = text_6.getText();
						n.inventario[j] = new NonAlimentare(cod, descr, prezzo, materiale);
					}
				} else {
					System.out.println("elimina qualche prodotto");
				}
				j++;
				ristampa();

			}

		});
		btnInserisciProdotto.setBounds(555, 361, 128, 25);
		btnInserisciProdotto.setText("NUOVO PRODOTTO");
		btnInserisciProdotto.setVisible(false);
		
		stampa();

	}

	public void stampa() {
		list.removeAll();
		for (int i = 0; i < j; i++) {
			list.add(Negozio.inventario[i].getDescr());
		}
	}

	public void stampa1() {
		list_1.removeAll();
		for (int i = 0; i < n.ls.carrello.size(); i++) {
			list_1.add(n.ls.carrello.get(i).getDescr());
		}
	}

	public String getTextBox() {
		return textBox;
	}

	public void setTextBox(String textBox) {
		this.textBox = textBox;
	}

	public boolean isScontrino() {
		return isScontrino;
	}

	public void setScontrino(boolean isScontrino) {
		this.isScontrino = isScontrino;
	}
}
