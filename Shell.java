package com.du.wot;

import java.awt.Color;
import java.awt.Graphics;

public class Shell {
	
	private int shell_x, shell_y, shell_radius;
	private int shell_speed = 1;
	private String shell_dir; //the direction 
	
	public Shell(String shell_dir, int shell_x, int shell_y, int shell_radius){
		this.shell_dir = shell_dir;
		this.shell_x = shell_x;
		this.shell_y = shell_y;
		this.shell_radius = shell_radius;
	}
	
	/**
	 * Paint the shell according to different directions
	 * Depending on the direction(str) as the condition to draw shells
	 * @param g
	 */
	public void drawShell(Graphics g){
		g.setColor(Color.RED);
		if(shell_dir.equals("UP")){
			g.drawOval(shell_x, shell_y-=shell_speed, shell_radius*2, shell_radius*2);
			g.fillOval(shell_x, shell_y-=shell_speed, shell_radius*2, shell_radius*2);
		}
		else if(shell_dir.equals("DOWN")){
			g.drawOval(shell_x, shell_y+=shell_speed, shell_radius*2, shell_radius*2);
			g.fillOval(shell_x, shell_y+=shell_speed, shell_radius*2, shell_radius*2);
		}
		else if(shell_dir.equals("LEFT")){
			g.drawOval(shell_x-=shell_speed, shell_y, shell_radius*2, shell_radius*2);
			g.fillOval(shell_x-=shell_speed, shell_y, shell_radius*2, shell_radius*2);
		}
		else if(shell_dir.equals("RIGHT")){
			g.drawOval(shell_x+=shell_speed, shell_y, shell_radius*2, shell_radius*2);
			g.fillOval(shell_x+=shell_speed, shell_y, shell_radius*2, shell_radius*2);
		}
		
	}
}
