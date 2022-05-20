package gui;





import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;


import config.GameConfiguration;

/**
 * @author Samy, Mélissa, Billel
 * Cette classe hérite de JFrame et permet de gérer l'accueil ainsi que ses boutons 
 */






public class AcceuilGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;



	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH_ACCUEIL,GameConfiguration.WINDOW_HEIGHT_ACCUEIL);


	Container contentPane = getContentPane();
	
	
	private GameDisplayAcceuil control = new GameDisplayAcceuil();
	
	private JLabel titre = new JLabel("Trafic");
	
	private static Font font = new Font(Font.SERIF, Font.PLAIN, 20);

	private JButton createDH = new JButton("Start");
	
	private JButton help = new JButton("help");
	
	private static Color buttonColor = new Color(250, 250, 230);
	
	private static Color controlColor = new Color(250, 250, 200);
	
	
	
	private int  longueur;
	
	private int largeur;

	public AcceuilGUI(String title) {
		super(title);
		init();
			
	}

	private void init() {
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		control.setLayout(new FlowLayout(FlowLayout.CENTER));
		control.setLayout(null);
		control.setPreferredSize(preferredSize);
	
		
		
		contentPane.add(control);
		
		
		
	    
	    
	  
	     
	      
		titre.setFont(font);
		
		titre.setBounds(250, 20, 200, 80);
		control.add(titre);
		
		
		JLabel dim = new JLabel("choisir une dimension");
		dim.setBackground(controlColor);
		dim.setBounds(500, 80, 200, 30);
		control.add(dim);
		
		
		
		JTextField min = new JTextField();
		min.setText("0");
		min.setBounds(480, 120, 96, 19);
		control.add(min);
		
		
		JTextField max = new JTextField();
		max.setText("0");
		max.setBounds(580, 120, 96, 19);
		control.add(max);
		
		
		
		
		createDH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				longueur = Integer.valueOf(min.getText());
				largeur = Integer.valueOf(min.getText());
			
				if(100 < longueur && longueur < 3000  && 100 < largeur && largeur < 3000 ) {
					MainGUI gameMainGUI = new MainGUI("Trafic",longueur,largeur);

					Thread gameThread = new Thread(gameMainGUI);
					gameThread.start();
				}
				else {
				MainGUI gameMainGUI = new MainGUI("Trafic");

				Thread gameThread = new Thread(gameMainGUI);
				gameThread.start();
				}
			}
		});
		
		createDH.setBounds(250, 105, 200, 50);
		createDH.setBackground(buttonColor);
		control.add(createDH);
		
	
		
		
	
		
		
		
		
		
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url_open ="src/images/help.txt";
				try
		        {
		            File file = new File(url_open);
		            if(!Desktop.isDesktopSupported())
		            {
		                System.out.println("not supported");
		                return;
		            }
		            Desktop desktop = Desktop.getDesktop();
		            if(file.exists())
		                desktop.open(file);
		        }
		        catch(Exception e1)
		        {
		            e1.printStackTrace();
		        }
		    }
			
		});
		help.setBounds(250, 205, 200, 50);
		help.setBackground(buttonColor);
		control.add(help);
	
	
	
		

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(GameConfiguration.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

			
		
		
		}
	}
	


	
	

}



