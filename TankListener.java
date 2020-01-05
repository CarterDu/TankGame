package com.du.wot;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Control the action performing according to the direction of the tank 
 * @author Carter Du
 *
 */
public class TankListener extends KeyAdapter{
	public GameInterface game;
	
	public TankListener(GameInterface game){
		this.game = game;
	}
	
	/**
	 * When press the direction button, make the tank move 
	 */
	@Override
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP){
			this.game.tank.up = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			this.game.tank.down = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			this.game.tank.left = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			this.game.tank.right = true;
		}
		//when press the space -- > fire
				else if(e.getKeyCode() == KeyEvent.VK_SPACE){
					this.game.tank.fire();
				}
	}
	
	
	/**
	 * When leave the direction button, stop all movements of the tank
	 */
	@Override
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP){
			this.game.tank.up = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			this.game.tank.down = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			this.game.tank.left = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			this.game.tank.right = false;
		}
		
	}

}
