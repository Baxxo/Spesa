package spesa;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.jface.dialogs.MessageDialog;
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
import org.eclipse.swt.events.MouseTrackAdapter;

public class Spesagrafica {

	protected Shell shell;

	Negozio n = new Negozio();
	private double t = 0;
	private int l = n.inventario.length;
	private int j = 0;
	private int g;
	private int m;
	private int y;
	private boolean isAlimentare;
	private boolean isExtended;
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
	private List list;
	private List list_1;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_6;
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
	private Label lblNewLabel;
	private Label lblNewLabel_1;
	private Label lblNewLabel_2;
	private Label lblDsad;
	private DateTime dateTime;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */

	public static Spesagrafica window;

	public static void main(String[] args) {
		window = new Spesagrafica();
		try {
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

		n.inventario[0] = new Alimentare("0123", "Pera", 0.3, new Data(26, 1, 2020));
		j++;

		n.inventario[1] = new Alimentare("4567", "Mela", 0.5, new Data(22, 1, 2020));
		j++;		
		
		n.inventario[2] = new Alimentare("8910", "Banana", 0.7, new Data(10, 1, 2020));
		j++;		
		
		n.inventario[3] = new NonAlimentare("1112", "Acqua", 1, "plastica");
		j++;		
		
		n.inventario[4] = new NonAlimentare("1314", "Birra", 5, "vetro");
		j++;		
		
		n.inventario[5] = new NonAlimentare("1516", "Tavernello", 10, "carta");
		j++;

		shell = new Shell();
		shell.setSize(750, 550);
		shell.setText("SWT Application");

		dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblNewLabel_2.setText("");
				lblNewLabel_2.setText("Data scadenza");
			}

			@Override
			public void mouseExit(MouseEvent e) {
				lblNewLabel_2.setText("");
			}
		});
		dateTime.setBounds(843, 275, 80, 24);
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
		lblTotale.setBounds(352, 482, 55, 15);
		lblTotale.setText("TOTALE :");

		lblCod = new Label(shell, SWT.NONE);
		lblCod.setBounds(768, 144, 43, 15);
		lblCod.setText("Codice:");
		lblCod.setVisible(false);

		lblPrezzo = new Label(shell, SWT.NONE);
		lblPrezzo.setBounds(768, 189, 43, 15);
		lblPrezzo.setText("Prezzo:");
		lblPrezzo.setVisible(false);

		lblDescrizione = new Label(shell, SWT.NONE);
		lblDescrizione.setBounds(743, 235, 68, 15);
		lblDescrizione.setText("Descrizione:");
		lblDescrizione.setVisible(false);

		lblScadenza = new Label(shell, SWT.NONE);
		lblScadenza.setBounds(756, 275, 55, 15);
		lblScadenza.setText("Scadenza:");
		lblScadenza.setVisible(false);

		lblMateriale = new Label(shell, SWT.NONE);
		lblMateriale.setBounds(756, 275, 55, 15);
		lblMateriale.setText("Materiale:");
		lblMateriale.setVisible(false);

		lblPrezzo_1 = new Label(shell, SWT.NONE);
		lblPrezzo_1.setBounds(299, 106, 37, 15);
		lblPrezzo_1.setText("Prezzo:");

		lblCarrello = new Label(shell, SWT.NONE);
		lblCarrello.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblCarrello.setBounds(539, 67, 70, 15);
		lblCarrello.setText("CARRELLO");

		lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setText("Hint");
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(30, 450, 250, 52);

		lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(342, 106, 37, 15);

		lblDsad = new Label(shell, SWT.NONE);
		lblDsad.setBounds(413, 482, 97, 15);
		lblDsad.setText("0.0");

		list = new List(shell, SWT.BORDER);
		list.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblPrezzo_1.setVisible(true);
				lblNewLabel_1.setVisible(true);
				lblNewLabel.setText("");
				lblNewLabel.setText(
						"Lista prodotti negozio\nClick per visualizzare prezzo \nDoppio click per scegliere prodotto");

			}

			@Override
			public void mouseExit(MouseEvent e) {
				lblNewLabel.setText("");
			}
		});
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {

				try {
					lblNewLabel_1.setText("");
					;
					list_1.setVisible(true);
					stampa1();
					pr = "" + n.inventario[list.getSelectionIndex()].getPrezzo();
					lblNewLabel_1.setText(pr);
					btnElimina.setVisible(true);
					lblNewLabel.setText("");
					lblNewLabel.setText("" + n.inventario[list.getSelectionIndex()]);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				n.ls.aggiungiProdotto(n.inventario[list.getSelectionIndex()]);
				btnScontrino.setVisible(true);
			}
		});
		list.setBounds(30, 102, 250, 301);

		list_1 = new List(shell, SWT.BORDER);
		list_1.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblPrezzo_1.setVisible(true);
				lblNewLabel_1.setVisible(true);
				lblNewLabel.setText("");
				lblNewLabel.setText("Lista oggetti nel carrello\nClick per visualizzare prezzo");
			}

			@Override
			public void mouseExit(MouseEvent e) {
				lblNewLabel.setText("");
			}
		});
		list_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					lblNewLabel_1.setText("");
					pr = "" + n.ls.carrello.get(list_1.getSelectionIndex()).getPrezzo();
					lblNewLabel_1.setText(pr);
					lblNewLabel.setText("");
					lblNewLabel.setText("\n" + n.ls.carrello.get(list_1.getSelectionIndex()));
					btnScontrino.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
			}
		});
		list_1.setBounds(410, 102, 289, 301);

		btnTessera = new Button(shell, SWT.CHECK);
		btnTessera.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblNewLabel.setText("Sconto su prodotti");
			}

			@Override
			public void mouseExit(MouseEvent e) {
				lblNewLabel.setText("");
			}
		});
		btnTessera.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				isTessera = true;
				btnCassa.setVisible(true);
			}
		});
		btnTessera.setBounds(516, 481, 93, 16);
		btnTessera.setText("TESSERA");
		btnTessera.setVisible(false);

		btnCassa = new Button(shell, SWT.NONE);
		btnCassa.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblNewLabel.setText("");
				lblNewLabel.setText("Finisci spesa");
			}

			@Override
			public void mouseExit(MouseEvent e) {
				lblNewLabel.setText("");
			}
		});
		btnCassa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				lblDsad.setVisible(true);
				lblTotale.setVisible(true);
				t = Math.floor(n.ls.calcolaTotale(isTessera) * 100.0) / 100.0;
				tot = "" + t;
				t = 0;
				lblDsad.setText(tot);
				tot = "";
				n.ls.tot = 0;
				btnCassa.setVisible(false);
				btnTessera.setVisible(false);
			}
		});
		btnCassa.setBounds(632, 477, 75, 25);
		btnCassa.setText("CASSA");
		btnCassa.setVisible(false);

		btnScontrino = new Button(shell, SWT.NONE);
		btnScontrino.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblDsad.setVisible(true);
				lblTotale.setVisible(true);
				lblNewLabel.setText("");
				lblNewLabel.setText("Vai alla cassa \nMouse Over per visualizzare totale");
			}

			@Override
			public void mouseExit(MouseEvent e) {
				lblNewLabel.setText("");
			}
		});
		btnScontrino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				list_1.setVisible(true);
				setScontrino(true);
				btnTessera.setVisible(true);
				btnCassa.setVisible(true);
				lblDsad.setText("");
				// btnScontrino.setVisible(false);
			}
		});
		btnScontrino.setBounds(553, 409, 90, 25);
		btnScontrino.setText("FINE SPESA");
		// btnScontrino.setVisible(false);

		btnElimina = new Button(shell, SWT.NONE);
		btnElimina.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblNewLabel.setText("");
				lblNewLabel.setText("Elimina prodotto dal carrello");
			}

			@Override
			public void mouseExit(MouseEvent e) {
				lblNewLabel.setText("");
			}
		});
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				try {
					n.ls.eliminaProdotto(list_1.getSelectionIndex());
					list_1.remove(list_1.getSelectionIndex());
					ristampa();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					MessageDialog.openInformation(shell, "ERRORE", "Seleziona elemento");
				}
			}
		});
		btnElimina.setBounds(443, 409, 75, 25);
		btnElimina.setText("ELIMINA");

		btnEliminaProdotto = new Button(shell, SWT.NONE);
		btnEliminaProdotto.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblNewLabel.setText("");
				lblNewLabel.setText("Elimina prodotto dal negozio");
			}

			@Override
			public void mouseExit(MouseEvent e) {
				lblNewLabel.setText("");
			}
		});
		btnEliminaProdotto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				try {
					int sel = list.getSelectionIndex();
					for (int i = sel; i < j; i++) {
						n.inventario[i] = n.inventario[i++];
					}
					j--;
					ristampa();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					MessageDialog.openInformation(shell, "ERRORE", "Seleziona elemento");
				}
			}
		});
		btnEliminaProdotto.setBounds(90, 419, 128, 25);
		btnEliminaProdotto.setText("ELIMINA PRODOTTO");

		btnInserisciProdotto = new Button(shell, SWT.NONE);
		btnInserisciProdotto.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblNewLabel_2.setText("");
				lblNewLabel_2.setText("crea prodotto");
			}

			@Override
			public void mouseExit(MouseEvent e) {
				lblNewLabel_2.setText("");
			}
		});
		btnInserisciProdotto.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});

		text = new Text(shell, SWT.BORDER);
		text.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblNewLabel_2.setText("");
				lblNewLabel_2.setText("Codice a barre del prodotto");
			}

			@Override
			public void mouseExit(MouseEvent e) {
				lblNewLabel_2.setText("");
			}
		});
		text.setBounds(843, 141, 170, 21);
		text.setVisible(false);

		text_1 = new Text(shell, SWT.BORDER);
		text_1.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblNewLabel_2.setText("");
				lblNewLabel_2.setText("Prezzo \nEs.: 2.0");
			}

			@Override
			public void mouseExit(MouseEvent e) {
				lblNewLabel_2.setText("");
			}
		});
		text_1.setBounds(843, 186, 170, 21);
		text_1.setVisible(false);

		text_2 = new Text(shell, SWT.BORDER);
		text_2.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblNewLabel_2.setText("");
				lblNewLabel_2.setText("Nome prodotto");
			}

			@Override
			public void mouseExit(MouseEvent e) {
				lblNewLabel_2.setText("");
			}
		});
		text_2.setBounds(843, 232, 170, 21);
		text_2.setVisible(false);

		text_6 = new Text(shell, SWT.BORDER);
		text_6.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblNewLabel_2.setText("");
				lblNewLabel_2.setText("Materiale di composizione prodotto \nEs: plastica, carta, vetro");
			}

			@Override
			public void mouseExit(MouseEvent e) {
				lblNewLabel_2.setText("");
			}
		});
		text_6.setBounds(843, 275, 170, 21);
		text_6.setVisible(false);

		btnAlimentare = new Button(shell, SWT.RADIO);
		btnAlimentare.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblNewLabel_2.setText("");
				lblNewLabel_2.setText("Prodotto alimentare");
			}
			@Override
			public void mouseExit(MouseEvent e) {
				lblNewLabel_2.setText("");
			}
		});
		btnAlimentare.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
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
					lblMateriale.setVisible(false);
				}
			}
		});
		btnAlimentare.setBounds(745, 66, 90, 16);
		btnAlimentare.setText("Alimentare");

		btnNonAlimentare = new Button(shell, SWT.RADIO);
		btnNonAlimentare.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblNewLabel_2.setText("");
				lblNewLabel_2.setText("Prodotto non alimentare");
			}
			@Override
			public void mouseExit(MouseEvent e) {
				lblNewLabel_2.setText("");
			}
		});
		btnNonAlimentare.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
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
					lblScadenza.setVisible(false);
				}
			}
		});
		btnNonAlimentare.setText("Non Alimentare");
		btnNonAlimentare.setBounds(867, 66, 107, 16);

		btnProdotto = new Button(shell, SWT.NONE);
		btnProdotto.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnProdotto.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				if (isExtended == true) {
					lblNewLabel.setText("");
					lblNewLabel.setText("Nascondi inserimento");
				} else {
					lblNewLabel.setText("");
					lblNewLabel.setText("Inserisci nuovo prodotto nella lista");
				}
			}

			@Override
			public void mouseExit(MouseEvent e) {
				lblNewLabel.setText("");
			}
		});
		btnProdotto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				btnProdotto.setText("NASCONDI");
				if (isExtended == false) {
					isExtended = true;
					shell.setSize(1100, 550);
					btnAlimentare.setVisible(true);
					btnNonAlimentare.setVisible(true);
					text.setText("");
					text_1.setText("");
					text_2.setText("");
					text_6.setText("");
					lblNewLabel_2.setVisible(true);
				} else if (btnProdotto.getText().equals("NASCONDI")) {
					btnProdotto.setText("NUOVO PRODOTTO");
					shell.setSize(750, 550);
					isExtended = false;
				}
			}
		});
		btnProdotto.setBounds(555, 17, 130, 25);
		btnProdotto.setText("NUOVO PRODOTTO");

		btnRistampa = new Button(shell, SWT.NONE);
		btnRistampa.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblNewLabel.setText("");
				lblNewLabel.setText("Ristampa le liste");
			}

			@Override
			public void mouseExit(MouseEvent e) {
				lblNewLabel.setText("");
			}
		});
		btnRistampa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ristampa();
			}
		});
		btnRistampa.setBounds(30, 17, 75, 25);
		btnRistampa.setText("RISTAMPA");

		btnInserisciProdotto.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				try {
					if (j < 100) {
						if (isAlimentare == true) {
							try {
								cod = text.getText();
								descr = text_2.getText();
								g = dateTime.getDay();
								m = dateTime.getMonth();
								y = dateTime.getYear();
								scadenza = new Data(g, m, y);
								prezzo = Double.parseDouble(text_1.getText());
								n.inventario[j] = new Alimentare(cod, descr, prezzo, scadenza);
								j++;
								shell.setSize(750,550);
								btnProdotto.setText("NUOVO PRODOTTO");
								ristampa();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								MessageDialog.openInformation(shell, "ERRORE", "Prezzo = Numero!!! (es. 2.0)");
							}
						} else {
							try {
								cod = text.getText();
								descr = text_2.getText();
								materiale = text_6.getText();
								prezzo = Double.parseDouble(text_1.getText());
								n.inventario[j] = new NonAlimentare(cod, descr, prezzo, materiale);
								j++;
								shell.setSize(750,550);
								btnProdotto.setText("NUOVO PRODOTTO");
								ristampa();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								MessageDialog.openInformation(shell, "ERRORE", "Prezzo = Numero!!! (es. 2.0)");
							}
						}
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					MessageDialog.openInformation(shell, "ERRORE", "Completa tutti i campi");
				}

			}

		});
		btnInserisciProdotto.setBounds(787, 378, 128, 25);
		btnInserisciProdotto.setText("NUOVO PRODOTTO");
		btnInserisciProdotto.setVisible(false);

		Button btnScontrino_1 = new Button(shell, SWT.NONE);
		btnScontrino_1.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblNewLabel.setText("");
				lblNewLabel.setText("Ristampa Scontrino");
			}

			@Override
			public void mouseExit(MouseEvent e) {
				lblNewLabel.setText("");
			}
		});
		btnScontrino_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.setSize(750, 550);
				isExtended = false;
				list_1.setVisible(true);
				btnElimina.setVisible(true);
				btnScontrino.setVisible(true);
				btnAlimentare.setVisible(false);
				btnNonAlimentare.setVisible(false);
				text.setVisible(false);
				text_1.setVisible(false);
				text_2.setVisible(false);
				text_6.setVisible(false);
				lblCod.setVisible(false);
				lblDescrizione.setVisible(false);
				lblMateriale.setVisible(false);
				lblPrezzo.setVisible(false);
				lblScadenza.setVisible(false);
				dateTime.setVisible(false);
				btnInserisciProdotto.setVisible(false);
				btnProdotto.setText("NUOVO PRODOTTO");
			}
		});
		btnScontrino_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnScontrino_1.setBounds(443, 17, 80, 25);
		btnScontrino_1.setText("SCONTRINO");

		Button btnSalva = new Button(shell, SWT.NONE);
		btnSalva.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblNewLabel.setText("");
				lblNewLabel.setText("Salva scontrino");
			}
		});
		btnSalva.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				n.ls.salvaFile();

			}
		});
		btnSalva.setBounds(112, 17, 75, 25);
		btnSalva.setText("SALVA");

		Button btnCarica = new Button(shell, SWT.NONE);
		btnCarica.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblNewLabel.setText("");
				lblNewLabel.setText("Carica ultimo scontrino");
			}
		});
		btnCarica.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				n.ls.caricaFile();
				stampa1();
			}
		});
		btnCarica.setBounds(193, 17, 75, 25);
		btnCarica.setText("CARICA");


		lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setAlignment(SWT.CENTER);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel_2.setBounds(768, 419, 191, 78);

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
