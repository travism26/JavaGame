package javagame;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {

	String mess;
	public Play(int state){
	}
	public String intro = "Welcome to the play state";
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException{
		g.drawString(intro, 250, 100);
		g.drawString(mess, 10, 30);
		g.drawString("Go back to menu", 250, 250);
		g.drawString("Go to level 1", 258, 338);
		g.drawRect(245, 245, 150, 30);
		g.drawOval(245, 320, 150, 50);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException{
		Input input = gc.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		mess ="x postion: "+ xpos + " y Postion: " + ypos;
		if((xpos>250 && xpos<425) && (ypos<455 && ypos>425)){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(0);
			}
		}
		
		if((xpos>245 && xpos<400) && (ypos<380 && ypos>320 )){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(2);
			}
		}
		
	}
	
	public int getID() {
		return 1;
	}
}
