package com.du.wot;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Construct the tank
 * @author Carter Du
 *
 */
public class Tank {
	
	private int x, y, radius;
	private int speed = 5;
	public boolean up, down , left, right;
	public GameInterface game;
	
	public Tank(GameInterface game, int x, int y, int radius){
		this.game = game;
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	/**
	 * Draw the tank
	 * @param g
	 */
	public void drawTank(Graphics g){
		g.setColor(Color.GREEN);
		g.drawRect(x, y, radius*2, radius*2);
		g.fillRect(x, y, radius*2, radius*2);
		
		if(up){
			g.drawRect(x + radius -2, y - radius, 4, 50);
			g.fillRect(x + radius -2, y - radius, 4, 50);
		}
		else if(down){
			g.drawRect(x + radius -2, y + radius, 4, 50);
			g.fillRect(x + radius -2, y + radius, 4, 50);
		}
		else if(left){
			g.drawRect(x - radius, y + radius - 2, 50, 4);
			g.fillRect(x - radius, y + radius - 2, 50, 4);
		}
		else if(right){
			g.drawRect(x + radius, y + radius - 2, 50, 4);
			g.fillRect(x + radius, y + radius - 2, 50, 4);
		}
		else{
			g.drawRect(x + radius -2, y - radius, 4, 50);
			g.fillRect(x + radius -2, y - radius, 4, 50);
		}
	}
	
	
	/**
	 * The movement of the tank
	 * In 4 direction related to the coordinate
	 */
	public void move(){
		if(up){
			this.y = y - speed;
		}
		else if(down){
			this.y = y + speed;
		}
		else if(left){
			this.x = x - speed;
		}
		else if(right){
			this.x = x + speed;
		}
	}
	
	/**
	 * Tank fires the shell according to 4 directions 
	 */
	public void fire(){
		if(up){
			addShell("UP");
		}
		else if(down){
			addShell("DOWN");
		}
		else if(left){
			addShell("LEFT");
		}
		else if(right){
			addShell("RIGHT");
		}
		else{
			addShell("UP");  //default direction is up: so fire up
		}
	}
	
	
	/**
	 * Increase the shells according to 4 directions 
	 */
	public void addShell(String dir){
		if(dir.equals("UP")){
			Shell shell = new Shell(dir, x + radius - 5/2, y, 5);
			this.game.shell_list.add(shell);
		}
		else if(dir.equals("DOWN")){
			Shell shell = new Shell(dir, x + radius - 5/2, y, 5);
			this.game.shell_list.add(shell);
		}
		else if(dir.equals("LEFT")){
			Shell shell = new Shell(dir, x, y + radius - 5/2, 5);
			this.game.shell_list.add(shell);
		}
		else if(dir.equals("RIGHT")){
			Shell shell = new Shell(dir, x, y + radius - 5/2, 5);
			this.game.shell_list.add(shell);
		}
		
	}
	
}
