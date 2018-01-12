import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Etch_A_Sketch implements ActionListener, MouseListener, MouseMotionListener
{
	JFrame window;
	Container content;//panel on window to draw on
	int mouseX,mouseY,oldX,oldY;
	JButton changeColor;
	Color currentColor;
	int colorIndex;

	public Etch_A_Sketch()
	{
		JFrame window = new JFrame("Classic Etch a Sketch");
		changeColor = new JButton("Change color");
		content = window.getContentPane(); 
		content.setBackground(Color.WHITE);
		content.setLayout( new FlowLayout() );
		content.addMouseListener(this);       
		content.addMouseMotionListener(this);  
		changeColor.addActionListener(this);
		content.add(changeColor);
		window.setSize(640,480);
		window.setVisible(true);//makes the window pop up
		currentColor = Color.BLACK;
	}
	// ..............................................................
	// IMPLEMENTING MOUSELISTENER REQUIRES YOU TO WRITE (OVER-RIDE) THESE METHODS 

	//when you press & release with NO MOVEMENT while pressed
	public void mouseClicked( MouseEvent me)
	{
	
	}		
	// when you press
	public void mousePressed( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
	}
	public void mouseReleased( MouseEvent me)
	{
		oldX = 0;
		oldY = 0;
		//repaint();
	}
	// the mouse just moved off of the JFrame
	public void mouseExited( MouseEvent me){}
	// the mouse just moved onto the JFrame
	public void mouseEntered( MouseEvent me){}
	
	// ...............................................................

	// mouse is moving while pressed
	public void mouseDragged( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();

		if (oldX ==0 )
		{
			oldX = mouseX;
			oldY = mouseY;
			return;
		}
		
		Graphics g = content.getGraphics(); 
		g.setColor(currentColor);
		g.drawLine( oldX,oldY, mouseX, mouseY );
		oldX = mouseX;
		oldY = mouseY;
	}
	
	public void mouseMoved( MouseEvent me)
	{
		
	}
	public void actionPerformed( ActionEvent someEvent)
	{
		Color[] possibleColors = {Color.BLACK, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA};
		JButton testButton = (JButton) someEvent.getSource();
		if(testButton == changeColor)
		{
			colorIndex++;
			currentColor = possibleColors[colorIndex%7];
		}
	}
	
	// ..............................................................

	public static void main( String[] args)
	{
		new Etch_A_Sketch();
	}

}//EOF