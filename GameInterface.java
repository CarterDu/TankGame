package com.du.wot;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Building the main frame
 * Component: Panel, Frame
 * Displaying the tank 
 * @author Carter Du
 *
 */
public class GameInterface extends JPanel{
	
	JFrame jf;
	Tank tank;
	ArrayList<Shell> shell_list;   //store shells from different directions 
	
	public GameInterface(){
		tank = new Tank(this, 100, 100, 25);
		shell_list = new ArrayList<>();
		jf = new JFrame("World of Tank");
		jf.setSize(800, 600);
		jf.setResizable(false);
		jf.setLayout(null);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		TankListener tankListener = new TankListener(this);
		jf.addKeyListener(tankListener);
	
		this.setSize(800, 600);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		
		jf.add(this);
		jf.setVisible(true);
		
		new Thread(){
			public void run(){
				while(true){
					tank.move();
					try {
						sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}.start();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		tank.drawTank(g);
		for(int i = 0; i < shell_list.size();i++){
			Shell shell = shell_list.get(i);
			shell.drawShell(g);
		}
		repaint();
	}
}
