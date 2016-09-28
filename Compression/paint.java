package Compression;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

import javax.imageio.ImageIO;
 
 
public class paint{
    
    public static void main(String[] args){
        
        
        
        Icon iconB = new ImageIcon("blue.gif");
        Icon iconM = new ImageIcon("magenta.gif");
        Icon iconR = new ImageIcon("red.gif");
        Icon iconBl = new ImageIcon("black.gif");
        Icon iconW = new ImageIcon("white.gif");
        Icon iconGr = new ImageIcon("grey.gif");
        Icon iconY = new ImageIcon("yellow.gif");
        Icon iconG = new ImageIcon("green.gif");
        Icon iconO = new ImageIcon("orange.gif");
        Icon iconC = new ImageIcon("cyan.gif");
        Icon iconP = new ImageIcon("pink.gif");
        //image icons for different colors.
        Icon iconCl = new ImageIcon("close.gif");
        //image icons for close button
        
        
        JFrame frame = new JFrame("Paint It");
        //Creates a frame with a title of "Paint it"
        Container content = frame.getContentPane();
        //Creates a new container
        content.setLayout(new BorderLayout());
        //sets the layout
        final PadDraw drawPad= new PadDraw();
        //creates a new padDraw, which is pretty much the paint program
        content.add(drawPad, BorderLayout.CENTER);
        //sets the padDraw in the center
        
        JPanel panel = new JPanel();
        //creates a JPanel
        panel.setPreferredSize(new Dimension(150,300));
        panel.setMinimumSize(new Dimension(150,300));
        panel.setMaximumSize(new Dimension(150,300));
        
        JPanel panel2 =new JPanel();
        panel2.setPreferredSize(new Dimension(300, 30));
        panel2.setMinimumSize(new Dimension(300, 30));
        panel2.setMaximumSize(new Dimension(300, 30));
    
        JPanel panel3 = new JPanel();
        panel3.setPreferredSize(new Dimension(40,40 ));
        panel3.setMinimumSize(new Dimension(40, 40));
        panel3.setMaximumSize(new Dimension(40, 40));
            
        //This sets the size of the panels
        
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu file = new JMenu("File");
        menuBar.add(file);
        JMenuItem save = new JMenuItem("Save");
    file.add(save);
        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drawPad.save();
            }
        });
        
        JMenuItem open = new JMenuItem("Open");
        file.add(open);
        open.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drawPad.open();
 
            }
        });
        
        
        JButton clearButton = new JButton("Clear");
        //creates the clear button and sets the text as "Clear"
        clearButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drawPad.clear();
            }
        });
        //this is the clear button, which clears the screen.  This pretty
        //much attaches an action listener to the button and when the
        //button is pressed it calls the clear() method
        
        JButton eraseButton = new JButton("Eraser");
        //creates the eraser button and sets the text as "Eraser"
        eraseButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
        drawPad.erase();
            }
        });
          
        
        
JRadioButton thinButton = new JRadioButton("Thin Line");
    thinButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drawPad.thin();
            }
        });
    JRadioButton mediumButton = new JRadioButton("Medium Line");
    mediumButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drawPad.medium();
            }
        });
    JRadioButton thickButton = new JRadioButton("Thick Line");
    thickButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drawPad.thick();
            }
        });
        
        //the above three buttons are for the thickness
        
        
        
        JButton rectButton = new JButton("Hollow Rectange");
        rectButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
               drawPad.rect();
              }
          });
          
          JButton rect2Button = new JButton("Filled Rectange");
        rect2Button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               drawPad.rect2();
              }
          });
          
          JButton ovalButton = new JButton("Hollow Oval");
          ovalButton.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e){
                  drawPad.oval();
                  
              }
          });
          
          JButton oval2Button = new JButton("Filled Oval");
          oval2Button.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e){
                  drawPad.oval2();
                
              }
          });
            
          JButton penButton = new JButton("Pencil");
        penButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drawPad.pen();
            }
        });
          JButton lineButton = new JButton("Line");
        lineButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drawPad.line();
            }
        });
        
        JButton polygonButton = new JButton("Polygon");
        polygonButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drawPad.polygon();
            }
        });
        
        //the above buttons are for various operations in paint
        
        JButton closeButton = new JButton(iconCl);
        //creates the  close button
        closeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
              
        
        
        
        // the buttons below are for various colors
        
        JButton redButton = new JButton(iconR);
        //creates the red button and sets the icon we created for red
        redButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drawPad.red();
            }
 
        });
        //when pressed it will call the red() method.  So on and so forth =]
        
        JButton blackButton = new JButton(iconBl);
        //same thing except this is the black button
        blackButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drawPad.black();
            }
        });
        
        JButton magentaButton = new JButton(iconM);
        //magenta button
        magentaButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drawPad.magenta();
            }
        });
        
        JButton blueButton = new JButton(iconB);
        //blue button
        blueButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drawPad.blue();
            }
        });
        
        JButton greenButton = new JButton(iconG);
        //green button
        greenButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drawPad.green();
            }
        });
        
        JButton greyButton = new JButton(iconGr);
        //grey button
        greyButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drawPad.grey();
            }
        });
        
        JButton whiteButton = new JButton(iconW);
        //white button
        whiteButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drawPad.white();
            }
        });
        
        JButton yellowButton = new JButton(iconY);
        //yellow button
        yellowButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drawPad.yellow();
            }
        });
        
    
        
        JButton orangeButton = new JButton(iconO);
        //orange button
        orangeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drawPad.orange();
            }
        });
        
        
        JButton cyanButton = new JButton(iconC);
        //cyan button
        cyanButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drawPad.cyan();
            }
        });
        
        JButton pinkButton = new JButton(iconP);
        //pink button
        pinkButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drawPad.pink();
            }
        });
    
        
        blackButton.setPreferredSize(new Dimension(16,16));
        magentaButton.setPreferredSize(new Dimension(16, 16));
        redButton.setPreferredSize(new Dimension(16, 16));
        blueButton.setPreferredSize(new Dimension(16, 16));
        greenButton.setPreferredSize(new Dimension(16,16));
        greyButton.setPreferredSize(new Dimension(16,16));
        whiteButton.setPreferredSize(new Dimension(16,16));
        yellowButton.setPreferredSize(new Dimension(16,16));
        orangeButton.setPreferredSize(new Dimension(16,16));
        cyanButton.setPreferredSize(new Dimension(16,16));
        pinkButton.setPreferredSize(new Dimension(16,16));
        clearButton.setPreferredSize(new Dimension(140,25));
        eraseButton.setPreferredSize(new Dimension(140,25));
        lineButton.setPreferredSize(new Dimension(140,25));
        rectButton.setPreferredSize(new Dimension(140,25));
        rect2Button.setPreferredSize(new Dimension(140,25));
        penButton.setPreferredSize(new Dimension(140,25));
        ovalButton.setPreferredSize(new Dimension(140,25));
        oval2Button.setPreferredSize(new Dimension(140,25));
        polygonButton.setPreferredSize(new Dimension(140,25));
        
        closeButton.setPreferredSize(new Dimension(19,19));
        
        
        //sets the sizes of the buttons
        
    
    ButtonGroup lineOption = new ButtonGroup( );
    lineOption.add(thinButton);
    lineOption.add(mediumButton);
    lineOption.add(thickButton);
    
    panel2.add(blackButton);
    panel2.add(greyButton);
    panel2.add(whiteButton);
    panel2.add(redButton);
    panel2.add(greenButton);
    panel2.add(blueButton);
    panel2.add(cyanButton);
    panel2.add(magentaButton);
    panel2.add(pinkButton);
    panel2.add(orangeButton);
    panel2.add(yellowButton);
    
    
        panel.add(clearButton);
        panel.add(eraseButton);
        panel.add(penButton);
        panel.add(lineButton);
        panel.add(rectButton);
        panel.add(rect2Button);
        panel.add(ovalButton);
        panel.add(oval2Button);
         panel.add(polygonButton);
        panel.add(thickButton);
        panel.add(mediumButton);
        panel.add(thinButton);
        
        panel3.add(closeButton);
        
        //adds the buttons to the panels
        
        
        content.add(panel, BorderLayout.WEST);
        //sets the panel to the left
        content.add(panel2, BorderLayout.NORTH);
        
        content.add(panel3, BorderLayout.EAST);
        
        frame.setSize(1030, 735);
        //sets the size of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //makes it so you can close
        frame.setVisible(true);
        //makes it so you can see it
    }
}
 
 
class PadDraw extends JComponent{
    Image image;
    //this is gonna be your image that you draw on
    Graphics2D graphics2D;
    //this is what we'll be using to draw on
    public int currentX, currentY, oldX, oldY,x1,y1,x2,y2,w,h,a1,a2,b1,b2,c1,d1,c2,d2,e1,f1,e2,f2,r1,s1,ch,m1,n1,fl,k1,k2=1,cc1,dd1,cc2,dd2,aa1,aa2,bb1,bb2;
    //these are gonna hold our mouse coordinates
//Now for the constructors
 
public void pen()
    {
        k1=1;
        setDoubleBuffered(false);
        cursorchange();
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                oldX = e.getX();
                oldY = e.getY();
            }
        });
        //if the mouse is pressed it sets the oldX & oldY
        //coordinates as the mouses x & y coordinates
        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                currentX = e.getX();
                currentY = e.getY();
                if(graphics2D != null && k1==1)
                    graphics2D.drawLine(oldX, oldY, currentX,currentY);
                    repaint();
                oldX = currentX;
                oldY = currentY;
                repaint();
            }
 
        });
}
        
public void line()
{
    k1=2;
setDoubleBuffered(false);
cursorchange();
        addMouseListener(new MouseAdapter()
        
          {
               public void mousePressed(MouseEvent m)
               {
               x1=m.getX();
               y1=m.getY();
               }
               public void mouseReleased(MouseEvent m)
               {
               x2=m.getX();
               y2=m.getY();               
                if(graphics2D != null && k1==2)
                graphics2D.drawLine(x1,y1, x2,y2);
                repaint();
             
            }
          });
}
 
public void rect()
        {
            k1=3;
            setDoubleBuffered(false);
            cursorchange();
                  addMouseListener(new MouseAdapter()
          {
             
               public void mousePressed(MouseEvent m)
               {
               a1=m.getX();
               b1=m.getY();
               repaint();
               }
        
               public void mouseReleased(MouseEvent m)
               {
               a2=m.getX();
               b2=m.getY();
                 if (a1>a2)
                 {
                int z=a1;
                 a1=a2;
                 a2=z;
                }
                if (b1>b2)
                 {
                int z=b1;
                 b1=b2;
                 b2=z;
                }
                w=a2-a1;
                h=b2-b1;
                if(graphics2D != null && k1==3)
                graphics2D.drawRect(a1,b1, w,h);
                    repaint();
                
}
          });
        
      }
 
      
      public void rect2()
        {
            k1=4;
            setDoubleBuffered(false);
            cursorchange();
                  addMouseListener(new MouseAdapter()
          {
               public void mousePressed(MouseEvent m)
               {
               aa1=m.getX();
               bb1=m.getY();
               repaint();
               }
               public void mouseReleased(MouseEvent m)
               {
               aa2=m.getX();
               bb2=m.getY();
                 if (aa1>aa2)
                 {
                int z=aa1;
                 aa1=aa2;
                 aa2=z;
                }
                if (bb1>bb2)
                 {
                int z=bb1;
                 bb1=bb2;
                 bb2=z;
                }
                w=aa2-aa1;
                h=bb2-bb1;
                if(graphics2D != null && k1==4)
                graphics2D.fillRect(aa1,bb1, w,h);
                    repaint();
                
}
          });
        
      }
 
      
      public void oval()
      {
          k1=5;
        setDoubleBuffered(false);
        cursorchange();
                  addMouseListener(new MouseAdapter()
          {
               public void mousePressed(MouseEvent e)
               {
               c1=e.getX();
               d1=e.getY();
               repaint();
               }
               public void mouseReleased(MouseEvent e)
               {
               c2=e.getX();
               d2=e.getY();
                 if (c1>c2)
                 {
                int z=c1;
                 c1=c2;
                 c2=z;
                }
                if (d1>d2)
                 {
                int z=d1;
                 d1=d2;
                 d2=z;
                }
                w=c2-c1;
                h=d2-d1;
                if(graphics2D != null && k1==5)
                    graphics2D.drawOval(c1,d1,w,h);
                repaint();
                }
          });
        }
        
        
        public void oval2()
      {
          k1=6;
        setDoubleBuffered(false);
        cursorchange();
                  addMouseListener(new MouseAdapter()
          {
               public void mousePressed(MouseEvent m)
               {
               cc1=m.getX();
               dd1=m.getY();
               repaint();
               }
               public void mouseReleased(MouseEvent m)
               {
               cc2=m.getX();
               dd2=m.getY();
                 if (cc1>cc2)
                 {
                int z=cc1;
                 cc1=cc2;
                 cc2=z;
                }
                if (dd1>dd2)
                 {
                int z=dd1;
                 dd1=dd2;
                 dd2=z;
                }
                w=cc2-cc1;
                h=dd2-dd1;
                if(graphics2D != null && k1==6)
                    graphics2D.fillOval(cc1,dd1, w,h);
                    repaint();
                }
          });
        }
        
        
        
        
        public void polygon()
{
    k1=8;
    k2=1;
setDoubleBuffered(false);
cursorchange();
        addMouseListener(new MouseAdapter()
        
          {
               public void mousePressed(MouseEvent m)
               {
               x1=m.getX();
               y1=m.getY();
               }
         final int r1=x1;
         final int s1=y1;
               public void mouseReleased(MouseEvent m)
               {
               x2=m.getX();
               y2=m.getY();
               if (x2==r1 && y2==s1)
               { graphics2D.drawLine(m1,n1, r1,s1);
               return;
            }
               else
               {
                   if(graphics2D != null && k1==8 && k2==1)
                    graphics2D.drawLine(x1,y1, x2,y2);
               
                if(graphics2D != null && k1==8 && k2!=1)
                graphics2D.drawLine(m1,n1, x2,y2);
                repaint();
                m1=x2;
                n1=y2;
                k2++;
                
            }
            
            }
          });
}
 
 
        //while the mouse is dragged it sets currentX & currentY as the mouses x and y
        //then it draws a line at the coordinates
        //it repaints it and sets oldX and oldY as currentX and currentY
        
    public void paintComponent(Graphics g){
        if(image == null){
            image = createImage(getSize().width, getSize().height);
            graphics2D = (Graphics2D)image.getGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
 
        }
        g.drawImage(image, 0, 0, null);
    }
    //this is the painting bit
    //if it has nothing on it then
    //it creates an image the size of the window
    //sets the value of Graphics as the image
    //sets the rendering
    //runs the clear() method
    //then it draws the image
 
 
    public void clear()
    {
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        repaint();
    }
    //this is the clear
    //it sets the colors as white
    //then it fills the window with white
    //thin it sets the color back to black
    
	public void save() { 
		JFileChooser fileChooser = new JFileChooser();
		
		if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) { 
			String path = fileChooser.getSelectedFile().getAbsolutePath(); 
			BufferedImage imageToSave = createImage(); 
			try { 
				//ImageIO.write(imageToSave, "myImage.jpg", new File(path));
				ImageIO.write(imageToSave, "png", new File("/tmp/image.png")); 
			} catch (IOException e) { 
					e.printStackTrace(); 
			}
		} 
	} 

	public BufferedImage createImage() { 
		BufferedImage returnImage = new BufferedImage(getSize().width, getSize().height, BufferedImage.TYPE_INT_RGB); 
		Graphics2D g = returnImage.createGraphics(); 
		g.drawImage(image, 0, 0, null);
		g.dispose();
		return returnImage; 
	}
    public void erase()
    {
        k1=7;
        
        cursorchange();
        graphics2D.setPaint(Color.white);
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                e1 = e.getX();
                f1 = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                e2 = e.getX();
                f2 = e.getY();
                if(graphics2D != null && k1==7)
                graphics2D.fillRect(e1, f1, 27, 27);
                repaint();
                e1 = e2;
                f1 = f2;
            }
        });
 
}
 
 
public void cursorchange()
{
  if (k1==7)
        {
            
            Toolkit toolkit = Toolkit.getDefaultToolkit();  
        Image image = toolkit.getImage("eraser.gif"); 
        Point hotSpot = new Point(0,0);  
        Cursor cursor = toolkit.createCustomCursor(image, hotSpot, "Eraser");  
        setCursor(cursor);  
}
        
else 
setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
 
}
 
// changing the cursor icons
 
 
public void open()
{
 
 
                
        
}
 



     
    
 
 
 
 
public void thick(){
        graphics2D.setStroke(new BasicStroke (7));
}
public void thin(){
        graphics2D.setStroke(new BasicStroke (1));
}
public void medium(){
        graphics2D.setStroke(new BasicStroke (4));
}
//thickness
 
 
// various colors
    public void red(){
        graphics2D.setPaint(Color.red);
        repaint();
    }
    //this is the red paint
    public void black(){
        graphics2D.setPaint(Color.black);
        repaint();
    }
    //black paint
    public void magenta(){
        graphics2D.setPaint(Color.magenta);
        repaint();
    }
    //magenta paint
    public void blue(){
        graphics2D.setPaint(Color.blue);
        repaint();
    }
    //blue paint
    public void green(){
        graphics2D.setPaint(Color.green);
        repaint();
    }
     //green paint
    
    public void yellow(){
        graphics2D.setPaint(Color.yellow);
        repaint();
    }
     //yellow paint
    public void grey(){
        graphics2D.setPaint(Color.gray);
        repaint();
         //grey paint
    }
    public void white(){
        graphics2D.setPaint(Color.white);
        repaint();
    }
     //white paint
    public void orange(){
        graphics2D.setPaint(Color.orange);
        repaint();
    }
     //orange paint
    public void cyan(){
        graphics2D.setPaint(Color.cyan);
        repaint();
    }
     //cyan paint
    public void pink(){
        graphics2D.setPaint(Color.pink);
        repaint();
    }
     //pink paint
     
     
}
//end of program............!!

