
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class game extends JPanel implements KeyListener{
	public static game panel;
	public static JFrame frame;
	public static JTextField txt; 
	public static clock c;
	public static int code;
	public static player p1;
	public static void main(String args[]){
		panel=new game();
		txt=new JTextField();
		frame=new JFrame();
		frame.setSize(800, 800);
		frame.setVisible(true);
		frame.setLayout(new GridLayout(2,1));
		panel.setBackground(Color.black);
		panel.setSize(400, 400);
		panel.setVisible(true);
		frame.add(panel);
		txt.addKeyListener(panel);
		frame.add(txt);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c=new clock();
		code=0;
		c.start();
	}
	public void keyTyped(KeyEvent e){
		
		
	}
	public void keyReleased(KeyEvent e){
			
	}
	public void keyPressed(KeyEvent e){
		code=e.getKeyCode();
		txt.setText("");
		
			//case
		
	}
	public void update(){
		panel.repaint();
	}
	public void paint(Graphics g){
		super.paint(g);
		g.drawString(Integer.toString(c.getTicks())+" Last key Pressed:"+ code, 0, 200);
		switch(code){
			case 37: p1.x--;
			break;
			case 38: p1.y=p1.y-8;
			break;
			case 39: p1.x++;
			break;
		}
		g.setColor(Color.BLUE);
		g.drawOval(400, 200, 5,5);
		for(int i = 0; i < 101 ; i ++ ){
			for(int j= 0; j < 101 ; j ++ ){
				
			}
			
		}
	}

}
