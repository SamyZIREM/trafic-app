package engine.process;

import java.util.ArrayList;
import java.util.List;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Batiment;
import engine.mobile.Car;
import engine.mobile.Feu;

import engine.mobile.Route;
import engine.mobile.Sol;
import engine.mobile.Stop;


/**
 * 
 * 
 * @author Samy et mélissa et billel
 * Cette classe permet de gérer le fonctionnement général de l'application 
 * Gérer les feux les véhicules et le circuit ainsi que leurs positions
  
 */
public class MobileElementManager {
	private Map map;

	
	private List<Sol> sol = new ArrayList<Sol>();
	private List<Route> route = new ArrayList<Route>();
	private List<Car> car = new ArrayList<Car>();
	private List<Feu> feu = new ArrayList<Feu>();
	private List<Stop> stop = new ArrayList<Stop>();
	
	private List<Batiment> batiment = new ArrayList<Batiment>();
	private int tour = 0;
	private int solId =0;
	private boolean accident = true;
	public MobileElementManager(Map map) {
		this.map = map;
	}
	
	public void generateCar() {
			
		
		
		if(sol !=null) {
			for(int i=0;i<sol.size();i++) {
				if(sol.get(i).isEtat()) {
					
					if(sol.get(i).getDirection()==0){
						Car c= new Car(sol.get(i).getPosition(),sol.get(i).getDirection(),comptRoute(sol.get(i)),sol.get(i).getId());
						
						car.add(c);
					}
					else if(sol.get(i).getDirection()==1){
						Car c= new Car(sol.get(i).getPosition(),sol.get(i).getDirection(),comptRoute(sol.get(i)),sol.get(i).getId());
						car.add(c);
					}
					else if(sol.get(i).getDirection()==2){
						Car c= new Car(sol.get(i).getPosition(),sol.get(i).getDirection(),comptRoute(sol.get(i)),sol.get(i).getId());
						car.add(c);
					}
					else if(sol.get(i).getDirection()==3){
						Car c= new Car(sol.get(i).getPosition(),sol.get(i).getDirection(),comptRoute(sol.get(i)),sol.get(i).getId());
						car.add(c);
					}
					
				}
			}
		
			
		}
		
	}
	public Sol searchSol(Block position) {
		Sol s = new Sol(new Block(0,0));
		for(int i=0;i<sol.size();i++) {
			if(sol.get(i).getPosition() ==position) {
				s=sol.get(i);
			}
			
		}
		return s;
	}
	public Feu searchFeu(Block position) {
		
		Feu s = new Feu(new Block(0,0));
		
		for(int i=0;i<feu.size();i++) {
			if(feu.get(i).getPosition() ==position) {
				s=feu.get(i);
			}
			
		}
		return s;
	}
	
	public void pivoter(Block position) {
		
		for(int i=0;i<sol.size();i++) {
			if(sol.get(i).getPosition() ==position) {
				sol.get(i).incrementDirection();
			}			
		}
		}
	public Route searchRoute(Block position) {
		Route s = new Route(new Block(0,0));
		
		for(int i=0;i<route.size();i++) {
			if(route.get(i).getPosition() == position) {
				s=route.get(i);
			}			
		}
		return s;
		
	}
	
	public int comptRoute(Sol sol) {
		int compt=0;
		Block b =  sol.getPosition();
		int x = b.getLine();
		int y = b.getColumn();
		for(int i=0;i<route.size();i++) {
			
			if(sol.getDirection()==1) {
			y++;
			if(searchRoute(new Block(x,y)).getPosition() != new Block(0,0) ) {
				compt++;
			}
			}
			else if(sol.getDirection()==0) {
				x--;
				if(searchRoute(new Block(x,y)).getPosition() != new Block(0,0) ) {
					compt++;
				}
			}
			else if(sol.getDirection()==3) {
				y--;
				if(searchRoute(new Block(x,y)).getPosition() != new Block(0,0) ) {
					compt++;
				}
				}
			else if(sol.getDirection()==2) {
				x++;
				if(searchRoute(new Block(x,y)).getPosition() != new Block(0,0) ) {
					compt++;
				}
				}
			
		}
		return compt;
	}
	
	public void removeCar() {
		car.removeAll(car);
	}
	public void moveAllCar(){
		if(car!=null) {
			for(int i=0;i<car.size();i++) {
				moveCar(car.get(i));
			}
		}
		
	}
	public int verifRoute(Car c) {
			
			int flag=0;
			for(int i=0;i<route.size();i++) {
				
				if(c.getPosition()==route.get(i).getPosition()) {
					flag++;
				}
				
		}
			
			return flag;
			
	}
	public void rebootTour() {
		tour=0;
	}
	
	public boolean verifFeu(Car c) {
		boolean a=true;
		for(int i = 0;i<feu.size();i++) {
			if(c.getPosition().getColumn() == feu.get(i).getPosition().getColumn() && c.getPosition().getLine() == feu.get(i).getPosition().getLine()) {
				if(feu.get(i).getEtat()==1) {
					c.arret();
					
					for(int k= 0;k<sol.size();k++) {
						if(c.getSolId()==sol.get(k).getId()) {
							sol.get(k).setEtat(false);
							
						}
						
											
					}
					for(int j= 0;j<car.size();j++) {
						if(c.getDirection() == 0) {
							if(c.getPosition().getColumn() == car.get(j).getPosition().getColumn() && c.getPosition().getLine() <= car.get(j).getPosition().getLine()) {
								car.get(j).arret();
							}
						
						}
						else if(c.getDirection()==1) {
							if(c.getPosition().getColumn() >= car.get(j).getPosition().getColumn() && c.getPosition().getLine() == car.get(j).getPosition().getLine()) {
								car.get(j).arret();
							}						
						}
						else if(c.getDirection()==2) {
							if(c.getPosition().getColumn() == car.get(j).getPosition().getColumn() && c.getPosition().getLine() >= car.get(j).getPosition().getLine()) {
								car.get(j).arret();
							}
						
						}
						else if(c.getDirection()==3) {
							if(c.getPosition().getColumn() <= car.get(j).getPosition().getColumn() && c.getPosition().getLine() == car.get(j).getPosition().getLine()) {
								car.get(j).arret();
							}						
						}
					
					}
				}
				else {
					c.marche();
					for(int k= 0;k<sol.size();k++) {
						if(c.getSolId()==sol.get(k).getId()) {
							sol.get(k).setEtat(true);
						}
						
					}
					for(int j= 0;j<car.size();j++) {
						if(c.getDirection() == 0) {
							if(c.getPosition().getColumn() == car.get(j).getPosition().getColumn() && c.getPosition().getLine() <= car.get(j).getPosition().getLine()) {
								car.get(j).marche();
							}
						
						}
						else if(c.getDirection()==1) {
							if(c.getPosition().getColumn() >= car.get(j).getPosition().getColumn() && c.getPosition().getLine() == car.get(j).getPosition().getLine()) {
								car.get(j).marche();
							}						
						}
						else if(c.getDirection()==2) {
							if(c.getPosition().getColumn() == car.get(j).getPosition().getColumn() && c.getPosition().getLine() >= car.get(j).getPosition().getLine()) {
								car.get(j).marche();
							}
						
						}
						else if(c.getDirection()==3) {
							if(c.getPosition().getColumn() <= car.get(j).getPosition().getColumn() && c.getPosition().getLine() == car.get(j).getPosition().getLine()) {
								car.get(j).marche();
							}						
						}
					
					}
				
				}
			}
			a=c.isEtat();
			
					}
		return a;
		
	}
	public boolean verifAccident(Car c) {
		boolean a=true;
		int compt=0;
		for(int i = 0;i<car.size();i++) {
			if(c.getPosition().getColumn() == car.get(i).getPosition().getColumn() && c.getPosition().getLine() == car.get(i).getPosition().getLine()) {
				compt++;
				
			}
		}
		if(compt>1) {
			a=false;
			accident=false;
		}
		return a;
	}
	
	public boolean verifStop(Car c) {
		boolean a=true;
		for(int i = 0;i<stop.size();i++) {
			if(c.getPosition().getColumn() == stop.get(i).getPosition().getColumn() && c.getPosition().getLine() == stop.get(i).getPosition().getLine()) {
				if(c.getCompt()!=GameConfiguration.TIME) {
					c.arret();
					for(int k= 0;k<sol.size();k++) {
						if(c.getSolId()==sol.get(k).getId()) {
							sol.get(k).setEtat(false);
						
						}
					}
					for(int j= 0;j<car.size();j++) {
						if(c.getDirection() == 0) {
							if(c.getPosition().getColumn() == car.get(j).getPosition().getColumn() && c.getPosition().getLine() <= car.get(j).getPosition().getLine()) {
								car.get(j).arret();
							}
						
						}
						else if(c.getDirection()==1) {
							if(c.getPosition().getColumn() >= car.get(j).getPosition().getColumn() && c.getPosition().getLine() == car.get(j).getPosition().getLine()) {
								car.get(j).arret();
							}						
						}
						else if(c.getDirection()==2) {
							if(c.getPosition().getColumn() == car.get(j).getPosition().getColumn() && c.getPosition().getLine() >= car.get(j).getPosition().getLine()) {
								car.get(j).arret();
							}
						
						}
						else if(c.getDirection()==3) {
							if(c.getPosition().getColumn() <= car.get(j).getPosition().getColumn() && c.getPosition().getLine() == car.get(j).getPosition().getLine()) {
								car.get(j).arret();
							}						
						}
					
					}
				}
				else {
					c.marche();
					for(int k= 0;k<sol.size();k++) {
						if(c.getSolId()==sol.get(k).getId()) {
							sol.get(k).setEtat(true);
							
						}
					}
					for(int j= 0;j<car.size();j++) {
						if(c.getDirection() == 0) {
							if(c.getPosition().getColumn() == car.get(j).getPosition().getColumn() && c.getPosition().getLine() <= car.get(j).getPosition().getLine()) {
								car.get(j).marche();
							}
						
						}
						else if(c.getDirection()==1) {
							if(c.getPosition().getColumn() >= car.get(j).getPosition().getColumn() && c.getPosition().getLine() == car.get(j).getPosition().getLine()) {
								car.get(j).marche();
							}						
						}
						else if(c.getDirection()==2) {
							if(c.getPosition().getColumn() == car.get(j).getPosition().getColumn() && c.getPosition().getLine() >= car.get(j).getPosition().getLine()) {
								car.get(j).marche();
							}
						
						}
						else if(c.getDirection()==3) {
							if(c.getPosition().getColumn() <= car.get(j).getPosition().getColumn() && c.getPosition().getLine() == car.get(j).getPosition().getLine()) {
								car.get(j).marche();
							}						
						}
					
					}
				
				}
				c.incrementCompt();
			}
			a=c.isEtat();
			
					}
		return a;
		
	}
	
	public void moveCar(Car c) {
		
		if(verifFeu(c) && verifStop(c) && verifAccident(c)) {
			if(c.isEtat()) {
					if(c.getDirection()==0) {
						
						c.haut();
					}
					else if(c.getDirection()==1) {
						c.droite();	
					}
					else if(c.getDirection()==2) {
						c.bas();
						
					}
					else if(c.getDirection()==3){
						c.gauche();
					}
					
				
			}
			}
		}
		
	
	
	

	public void generateFeu(Block position) {
		Feu f= new Feu(position);
		feu.add(f);
	}
	public void deleteFeu(Block position) {
		
		if(feu != null) {
			for(int i=0;i<feu.size();i++) {
				if(feu.get(i).getPosition() ==position) {
					feu.remove(i);
				}
		}
		
	}
	}
	
	public void generateStop(Block position) {
		Stop s= new Stop(position);
		stop.add(s);
	}
	public void deleteStop(Block position) {
		
		if(stop != null) {
			for(int i=0;i<stop.size();i++) {
				if(stop.get(i).getPosition() == position) {
					stop.remove(i);
				}
		}
		
	}
	}
	

	public void generateSol(Block position,int direction) {
		Sol s= new Sol(solId,position,direction);
		solId++;
		
		sol.add(s);
		
	}
	
	public void generateRoute(Block position) {
		Route r= new Route(position);
		route.add(r);
	}
	
	public void deleteSol(Block position,int entree) {
		for(int i=0;i<sol.size();i++) {
			if(sol.get(i).getPosition() ==position) {
				sol.remove(i);
			}
			
		}
	}
	public void deleteRoute(Block position) {
		for(int i=0;i<route.size();i++) {
			if(route.get(i).getPosition() ==position ) {
				route.remove(i);
			}
			
		}
	}
	
	public void generateBatiment(Block position) {
		Batiment b= new Batiment(position);
		batiment.add(b);
	}
	
	public void deleteBatiment(Block position) {
		for(int i=0;i<batiment.size();i++) {
			if(batiment.get(i).getPosition() ==position) {
				batiment.remove(i);
			}
			
		}
	}
	
	public void agrandir(){
		batiment.get(batiment.size()-1).agrandir();
		
	}
	
	public void retrecir() {
		batiment.get(batiment.size()-1).retrecir();
	}
	
	
	
	
	
	public void findLight(Block position) {
		if(feu != null) {
			for(int i=0;i<feu.size();i++) {
				if(feu.get(i).getPosition()==position) {
					switchLight(feu.get(i));
				}
			}
		}
		
	}
	
	public void switchLight(Feu feu) {
		if(feu.getEtat()==0) {
			feu.setEtat(1);
		}
		else {
			feu.setEtat(0);
		}
		
	}
	
	public void increment() {
		tour++;
	}
	
	public void removeAll() {
		car.removeAll(car);
		feu.removeAll(feu);
		sol.removeAll(sol);
		route.removeAll(route);
		stop.removeAll(stop);
		batiment.removeAll(batiment);
		
		
		
	}
	public void nextRound() {
		
		increment();
		if(tour%2==0) {
			generateCar();
		}
		moveAllCar();
			
	
		}
	
	
	
	
	public List<Batiment> getBatiment() {
		return batiment;
	}
	public void setBatiment(List<Batiment> batiment) {
		this.batiment = batiment;
	}
	public boolean isAccident() {
		return accident;
	}
	public void setAccident(boolean accident) {
		this.accident = accident;
	}
	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public List<Sol> getSol() {
		return sol;
	}

	public void setSol(List<Sol> sol) {
		this.sol = sol;
	}

	public List<Car> getCar() {
		return car;
	}

	public void setCar(List<Car> car) {
		this.car = car;
	}
	
	

	public List<Route> getRoute() {
		return route;
	}

	public void setRoute(List<Route> route) {
		this.route = route;
	}

	public List<Feu> getFeu() {
		return feu;
	}

	public void setFeu(List<Feu> feu) {
		this.feu = feu;
	}
	
	

	public List<Stop> getStop() {
		return stop;
	}
	public void setStop(List<Stop> stop) {
		this.stop = stop;
	}
	
	

	
	@Override
	public String toString() {
		return "MobileElementManager [map=" + map + "]";
	}
	
}
