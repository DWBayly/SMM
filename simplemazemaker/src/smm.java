
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class smm extends JPanel implements ActionListener{
	public static smm panel;
	public static JFrame frame;
	public static tile seed;
	public static double us,ds,ls,rs;
	public static HashMap<String,tile>l;
	//public static JTextField txt;
	public void actionPerformed(ActionEvent e){
		try{
			PrintWriter w = new PrintWriter("map", "UTF-8");
			for(int i=0;i<100;i++){
				for(int j=0;j<100;j++){
					int result=0;
					if(l.containsKey(i+""+j)){
						if(l.get(i+""+j).u!=null){
							result++;
						}
						if(l.get(i+""+j).d!=null){
							result+=2;
						}
						if(l.get(i+""+j).l!=null){
							result+=4;
						}
						if(l.get(i+""+j).r!=null){
							result+=8;
						}
					}
					w.print(result+",");
				}
				w.println();
			}
			w.close();
		}catch(Exception q){
			System.out.println("No file");
		}
	}
	public static void main(String args[]){
		panel=new smm();
		frame=new JFrame();
		frame.setSize(800, 800);
		frame.setVisible(true);
		panel.setBackground(Color.black);
		panel.setSize(400, 400);
		panel.setVisible(true);
		panel.setLayout(new GridLayout(2,1));
		frame.add(panel);
		/*JButton b= new JButton("SAVE");
		
		panel.add(b);
		b.setSize(40,20);
		b.setLocation(90,90);
		b.addActionListener(panel);
		*/
	
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//l= new HashMap<String,tile>();
		/*us=ds=ls=rs=0.5;
		seed=new tile(50,50);
		l.put("5050",seed);
		seed.gen();*/
	
	}
	public void paint(Graphics g){
		super.paint(g);
		l= new HashMap<String,tile>();
		us=ds=ls=rs=0.5;
		/*us=0.3;
		ds=0.3;
		ls=0.7;
		rs=0.7;*/
		seed=new tile(10,10);
		l.put("5050",seed);
		g.setColor(Color.blue);
		g.drawRect(0, 0, 800, 800);
		for(int i=0;i<81;i++){
				g.drawLine(0, 10*i, 800,10*i);
				g.drawLine(10*i,0, 10*i, 800);
		}
		g.setColor(Color.black);
		seed.gen(g);
		if(l.size()<300){
			paint(g);
		}
	}

}
