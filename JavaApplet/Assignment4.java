package JavaApplet;

import javax.swing.JApplet;
import java.awt.*;

public class Assignment4 extends JApplet {

	public void paint (Graphics g) {
	
		super.paint (g);
		Graphics2D g2D = (Graphics2D)g;
		
		//Print your name using drawstring
		g.setFont(new Font ("Consolas",Font.BOLD,20));
		g.drawString("Khizar",10,20);
		
		//Draw a rectangle around your name
		g2D.setStroke(new BasicStroke(3F));
		g.setColor(Color.gray);
		g.drawRect(30,30,225,100);
		
		//Set color and stroke for your name
		g.setColor(Color.blue);
		g2D.setStroke(new BasicStroke (5F));
		
		//K	
		g.drawLine(75,50,75,100);
		g.drawLine(75,75,100,100);
		g.drawLine(75,75,100,50);
		
		//h		
		g.drawLine(115,100,115,50);
		g.drawLine(135,75,116,75);
		g.drawLine(135,100,135,75);
		
		//i
		g.drawLine(148,100,148,73);
		g.drawOval(148,60,5,5);
		
		//z
		g.drawLine(160,75,170,75);
		g.drawLine(170,75,160,100);
		g.drawLine(160,100,170,100);
		
		//a	
		g.drawArc(182,75,35,25,90,180);
		g.drawLine(200,102,200,73);
		
		//r
		g.drawLine(210,100,210,73);
		g.drawLine(210,73,222,73);
		
		//Draw and fill circles
		g2D.setStroke(new BasicStroke(1.5F));
		g.setColor(Color.black);
		g.drawOval(205,9,20,20);
		g.drawOval(225,0,30,30);
		g.fillOval(225,0,30,30);
		g.setColor(Color.blue);
		g.drawOval(255,9,20,20);
		g.fillOval(255,9,20,20);
		g.setColor(Color.black);
		g.drawOval(257,30,30,30);
		g.fillOval(257,30,30,30);
		g.drawOval(257,60,20,20);
		g2D.setStroke(new BasicStroke(2.4F));
		
		//Draw A parallelopid
		
		
		Polygon parallelopid = new Polygon ();
		parallelopid.addPoint(100,200);
		parallelopid.addPoint(200,200);
		parallelopid.addPoint(225,325);
		parallelopid.addPoint(125,325);
		g.drawPolygon(parallelopid);
		
		g.setColor(Color.gray);
		Polygon parallelopida = new Polygon ();
		parallelopida.addPoint(150,250);
		parallelopida.addPoint(250,250);
		parallelopida.addPoint(275,375);
		parallelopida.addPoint(175,375);
		g.drawPolygon(parallelopida);
		
		g.setColor(Color.blue);
		g.drawLine(100,200,150,250);
		g.drawLine(200,200,250,250);
		g.drawLine(225,325,275,375);
		g.drawLine(125,325,175,375);
	}
	
	public void init () {
		setSize(900,900);
	}
}
