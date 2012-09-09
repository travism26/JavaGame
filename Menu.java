package javagame;
import javax.swing.JButton;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {
	
	JButton button1 = new JButton("Level 2");
	Image fb;
	Image playNow;
	Image exitGame;
	Image bg;
	int facex = 200;
	int facey = 200;
	public String Message = "Not avaiable!";
	public String image = " ";
	int mousex, mousey;
	public int speed = 1;
	public int gravity;
	public int x,y;
	Thread t1 = new Thread();
	
	/*
	 * just testing to see is i can make pic objects instead of always
	 * making Images then assigning their location i want to have their 
	 * locations and image in the same spot make it easier.
	 */
	pic play = new pic(250,300,playNow);
	pic end = new pic(250, 400, exitGame);
	
	
	
	
	
	
	
	
	public Menu(int state){
	}
	
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		gravity = -3;
		
		
		play.setPic("res/playNow.png");
		end.setPic("res/exitGame.png");
		fb = new Image("res/facebook.png");
		bg = new Image("res/background.jpg");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException{
		g.drawImage(bg,0,0);
		g.drawString(Message, 10, 30);
		g.drawString(image, 10, 45);
		g.drawImage(play.getPic(), play.getx(), play.gety());
		g.drawImage(end.getPic(), end.getx(), end.gety());
		g.drawImage(fb, facex, facey);
		
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException{
		Input input = gc.getInput();
		mouseInput(input, sbg, play, 1);
		mouseInput(input, sbg, end, 2);
		try {
			keyInput(input, sbg, fb);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mousex = Mouse.getX();
		mousey = Mouse.getY();
		Message = "x postion: "+ mousex + " y Postion: " + mousey;
		image = "Image X: " + facex +" Image y: "+ facey;
		
			
		
	}
	
	/*
	 * Create a damn get y axis for images 
	 * since this AIP has a weird way of 
	 * setting up the x and y axis GRRR -.-
	 */
	private int getImageY(Image input, int y){
		int bound = Game.yBound;
		int pos = bound - y;
		
		return pos;
	}
	
	/*
	 * This will keep track of the keyboard input.
	 */
	private void keyInput(Input input, StateBasedGame sbg, Image picture) throws InterruptedException {
		int boundX = Game.xBound;
		int boundY = Game.yBound;
		int yVelo = 4;
		
		if(input.isKeyPressed(input.KEY_SPACE)){
			
			
			
		}
		
		if(input.isKeyDown(input.KEY_UP)){
			if(facey>0){
				facey-=speed;
			}
			else
				;
			 
		}
		if(input.isKeyDown(input.KEY_DOWN)){
			if(facey+picture.getHeight()<boundY){
				facey+=speed;
			}
			else
				;
			
		}
		if(input.isKeyDown(input.KEY_LEFT)){
			if(facex>=0){
				facex-=speed;
			}
			else
				;
			
		}
		if(input.isKeyDown(input.KEY_RIGHT)){
			if(boundX > facex+picture.getWidth()){
				facex+=speed;
			}
			else
				;
		}
	}

	/**
	 * I would like this method to keep track of all the mouse input
	 * @param input
	 * @return this will be dependent on what the input will be
	 * should i make this a separate class? abstract type? hmm...
	 */
	public void mouseInput(Input input, StateBasedGame sbg, pic play, int button){
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		int positionY = getImageY(play.getPic(), play.gety());
		
		if((xpos>play.getx() && xpos<play.getx()+ play.getPic().getWidth())
				&& (ypos < positionY && ypos > positionY - play.getPic().getHeight())){
			if(Mouse.isButtonDown(0)){
				if(button == 1){
					sbg.enterState(1);
				}
				if(button ==2){
					System.exit(-1);
				}
				
			}
		}
		
	}
	
	/*
	 * Should i make a method to check is zone is clicked?...
	 * ill try
	 */
	
	//public boolean clicked(){
		
	//}
	
	public int getfacex(){
		return facex;
	}
	public int getfacey(){
		return facey;
	}
	public int getID() {
		return 0;
	}
	
	//---------------------NEW INNER CLASS-----------------------//
	
	/*
	 * This inner class is made just to associate every picture with its location;
	 */
	public class pic{
		public int x;
		public int y;
		public Image pic;
		
		public pic(int x, int y, Image pic){
			this.x = x;
			this.y = y;
			this.pic = pic;
		}
		//These are really not needed because ill have everything set to public
		public int getx(){
			return x;
		}
		public int gety(){
			return y;
		}
		public Image getPic(){
			return pic;
		}
		public void setPic(String local){
			Image pic = null;
			try {
				pic = new Image(local);
			} catch (SlickException e) {
				System.out.println("explosion here");
				e.printStackTrace();
			}
			this.pic = pic;
			
		}
	}

}
