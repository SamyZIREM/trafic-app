package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import config.GameConfiguration;
import engine.map.Block;

import engine.map.Map;
import engine.process.GameBuilder;
import engine.process.MobileElementManager;


/**
 * 
 * 
 * @author Samy, Mélissa, Billel
 * Cette classe hérite de JFrame et permet de mettre en place les fenêtres, les boutons ainsi que leurs actions...etc 
 */
public class MainGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	private Map map;

	private static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);

	private final static Dimension radioButtonSize = new Dimension(300,100);
	
	private MobileElementManager manager;
	

	
	private GameDisplay dashboard;
	
	private JPanel radioButton;
	
	private MainGUI instance = this;
	
	private boolean stop = false;
	

	
	private String creation = "";
	
	private JButton startButton = new JButton(" En construction ");
	
	private JButton rebootButton = new JButton(" Réinisialiser");
	
	private JLabel message = new JLabel();
	
	private ButtonGroup bouttonGoup1 = new ButtonGroup();
	private JRadioButton route = new JRadioButton("route");
	private JRadioButton route_entree = new JRadioButton("route_entree");
	private JRadioButton feu_vert = new JRadioButton("feu vert");

	private JRadioButton stopp = new JRadioButton("stop");
	
	private JRadioButton batiment = new JRadioButton("batiment");

	public MainGUI(String title) {
		super(title);
		init();
	}
	
	public MainGUI(String title,int min, int max) {
		super(title);
		preferredSize = new Dimension(min, max);
		init();
	}

	private void init() { 

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		KeyControls keyControls = new KeyControls();
		JTextField textField = new JTextField();
		textField.addKeyListener(keyControls);
		contentPane.add(textField, BorderLayout.NORTH);

		map = GameBuilder.buildMap();
		manager = GameBuilder.buildInitMobile(map);
		dashboard = new GameDisplay(map, manager);
		radioButton = new JPanel();
		radioButton.setPreferredSize(radioButtonSize);
	
		route.setSelected(false);
		route_entree.setSelected(false);	
		feu_vert.setSelected(false);
		stopp.setSelected(false);
		batiment.setSelected(false);
	
		
		
		route.setBounds(10, 160, 200, 30);
		route_entree.setBounds(10, 190, 200, 30);
		feu_vert.setBounds(10, 220, 200, 30);
		stopp.setBounds(20, 160, 200, 30);
		batiment.setBounds(20, 190, 200, 30);
		
		bouttonGoup1.add(route);
		bouttonGoup1.add(route_entree);
		bouttonGoup1.add(feu_vert);
		bouttonGoup1.add(stopp);
		bouttonGoup1.add(batiment);
		radioButton.add(route);
		radioButton.add(route_entree);
		radioButton.add(feu_vert);
		radioButton.add(stopp);
		radioButton.add(batiment);
		//Button
		rebootButton.setBounds(30, 190, 200, 30);
		radioButton.add(rebootButton);
		//message
		message.setBounds(60, 160, 200, 30);
		message.setForeground(Color.red);
		
		radioButton.add(message);
		contentPane.add(radioButton,BorderLayout.EAST);
		
		startButton.addActionListener(new StartStopAction());
		contentPane.add(startButton,BorderLayout.SOUTH);

		MouseControls mouseControls = new MouseControls();
		MMouse_PBE mouseControl = new MMouse_PBE();
		dashboard.addMouseWheelListener (mouseControl);
		dashboard.addMouseListener(mouseControls);

		dashboard.setPreferredSize(preferredSize);
		dashboard.setBackground(new Color(255,255,255));
		
		contentPane.add(dashboard, BorderLayout.CENTER);
		
		route.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRadioButton source = (JRadioButton)e.getSource();
				if (source.isSelected()) {
					creation="route";
				
				}
				
			}
		});
		
		route_entree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRadioButton source = (JRadioButton)e.getSource();
				if (source.isSelected()) {
					creation="route_entree";
				
				}
				
			}
		});
		
		feu_vert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRadioButton source = (JRadioButton)e.getSource();
				if (source.isSelected()) {
					creation="feu_vert";
				
				}
				
			}
		});
		
		stopp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRadioButton source = (JRadioButton)e.getSource();
				if (source.isSelected()) {
					creation="stopp";
				
				}
				
			}
		});
		batiment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRadioButton source = (JRadioButton)e.getSource();
				if (source.isSelected()) {
					creation="batiment";
				
				}
				
			}
		});
		
		rebootButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!stop) {
					manager.removeAll();
				}
				
			}
		});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
	}

	@Override
	public void run() {
		
		while (!stop) {
			
			manager.removeCar();
			dashboard.repaint();
			
			
			
		}
		while (stop) {
			
						try {
				Thread.sleep(GameConfiguration.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
						manager.nextRound();
						if(!manager.isAccident()) {						
							stop = false;
							
							startButton.setText(" En construction ");
							message.setText("<html>Oups!!!<br> Problème de circulation,<br>veuillez corriger votre circuit.<html>");
							if(manager.getCar()!=null) {
								manager.removeCar();
							}
							dashboard.repaint();
							Thread sourisThread = new Thread(instance);
							sourisThread.start();
						}
						dashboard.repaint();
						
			
			
			
			
		}
			
		}
	
	private class StartStopAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!stop) {
				manager.rebootTour();
				stop = true;
				manager.setAccident(true);
				message.setText("");
				startButton.setText(" Simulation ");
				
			} 
				else {
				stop = false;
				
				startButton.setText(" En construction ");
				if(manager.getCar()!=null) {
					manager.removeCar();
				}
				dashboard.repaint();
				Thread sourisThread = new Thread(instance);
				sourisThread.start();
				
			}
			
		}
	}
	private class KeyControls implements KeyListener {

		@Override
		public void keyPressed(KeyEvent event) {
			char keyChar = event.getKeyChar();
			switch (keyChar) {

			case 'q':
			
				
				break;
			case 'd':
		
				break;
			case 'm':
				
				break;
			default:
				break;
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {

		}
	}
	private class MMouse_PBE extends MouseMotionAdapter implements MouseWheelListener{
		   
		   public void mouseWheelMoved(MouseWheelEvent e){
			  if(manager.getBatiment().size() >0) {
		      int notches = e.getWheelRotation();
		      if(creation == "batiment") {
		    	  
		      if (notches < 0) {
		         manager.agrandir();
		      } else {
		    	  manager.retrecir();
		      }   
		      
		      }
			  }
		   }
		}  

	private class MouseControls implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			
			int x = e.getX() ;
			int y = e.getY();

			Block b = dashboard.getFeuPosition(x, y);
			
			
				if(!stop && SwingUtilities.isRightMouseButton(e) && creation == "feu_vert") {
					manager.deleteFeu(b);
				}
				else if(!stop && SwingUtilities.isLeftMouseButton(e) && creation == "feu_vert") {
					Block block = manager.searchFeu(b).getPosition();
					
					if(block.Null()) {
						manager.generateFeu(b);
					}
					else {
						manager.findLight(b);
						dashboard.repaint();
					
						
					}
					
					
				}
				else if(stop && SwingUtilities.isLeftMouseButton(e)){
					
					manager.findLight(b);
					dashboard.repaint();
				}
								
				else if(!stop && SwingUtilities.isLeftMouseButton(e) && creation == "route_entree") {
					Block block = manager.searchSol(b).getPosition();
					
					if(block.Null()) {
						manager.generateSol(b,0);
					
					}
					else {
						manager.pivoter(b);
						dashboard.repaint();
					
						
					}
					
				}
				
				else if(!stop && SwingUtilities.isRightMouseButton(e) && creation == "route_entree") {
					
					manager.deleteSol(b,1);
				}
				else if(!stop && SwingUtilities.isLeftMouseButton(e) && creation == "route") {
				
					manager.generateRoute(b);
				}
				
				else if(!stop && SwingUtilities.isRightMouseButton(e) && creation == "route") {
					
					manager.deleteRoute(b);
				}
				else if(!stop && SwingUtilities.isLeftMouseButton(e) && creation == "stopp") {
					
					manager.generateStop(b);
				}
				
				else if(!stop && SwingUtilities.isRightMouseButton(e) && creation == "stopp") {
					
					manager.deleteStop(b);
				}
				else if(!stop && SwingUtilities.isLeftMouseButton(e) && creation == "batiment") {
					
					manager.generateBatiment(b);
				}
				
				else if(!stop && SwingUtilities.isRightMouseButton(e) && creation == "batiment") {
					
					manager.deleteBatiment(b);
				}
			
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}

}
