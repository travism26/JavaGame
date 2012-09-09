package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {

	public static int xBound = 700;
	public static int yBound = 700;
	public static final String gamename = "Dr. T-Rav 2.0";
	public static final int menu = 0;
	public static final int play = 1;
	public static final int levelone = 2;
	public static boolean fullScreen = false;
	
	
	
	/*
	 * This constructor will take all the game states 
	 * do not forget to add them when you create more
	 * ie: making a new level or an options panel. 
	 * the objects need to be added into the system or 
	 * it will crash on start up
	 */
	public Game(String gamename) {
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new levelOne(levelone));
		
	}
	/*
	 * i created this to help me get the bounds of the game so
	 * i dont need to change all the parameters in each of the 
	 * icons so they dont run off the screen.
	 */
	public int getXBound(){
		return xBound;
	}
	
	public int getYBound(){
		return yBound;
	}
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(levelone).init(gc, this);
		this.enterState(menu);
	}
	public static void main(String[] args) {
		AppGameContainer appgc;
		
		try{
			appgc = new AppGameContainer(new Game(gamename));
			appgc.setDisplayMode(xBound, yBound, fullScreen);
			appgc.start();
			
		}catch(SlickException e){
			System.out.printf("%s", "error 1");
		}
		

	}

	

}
