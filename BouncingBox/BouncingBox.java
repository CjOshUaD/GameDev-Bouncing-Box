
package BouncingBox;


/** Dadia, Christian Joshua P.  - BSIT -2A 
 * IT152 - Double Buffering Activity
 * submitted: 12/28/22
 */

//------------------------------------------------

import java.awt.*;
import javax.swing.*;

public class BouncingBox extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private long rstart;
	private long rend;

int width;
int height;


//box 1
float radius = 40; 
float diameter = radius * 2;
float X = radius + 50;
float Y = radius + 20;
float dy = 1;
float dx = 1;

//added two more boxes (box2 and box3)
//box2
float radius1 = 40; 
float diameter1 = radius * 2;
float X1 = radius + 50;
float Y1 = radius + 20;
float dy1 = 4;
float dx1 = 4;

//box3
float radius2 = 40; 
float diameter2 = radius * 2;
float X2 = radius + 50;
float Y2 = radius + 20;
float dy2 = 9;
float dx2 = 9;

public BouncingBox() {

  Thread thread = new Thread() {
    public void run() {
      while (true) {

        width = getWidth();
        height = getHeight();

        X = X + dx;
        Y = Y + dy;

        X1 = X1 + dx1;
        Y1 = Y1 + dy1;

        X2 = X2 + dx2;
        Y2 = Y2 + dy2;
        if (X - radius < 0) {
          dx = -dx; 
          X = radius; 
        } else if (X + radius > width) {
          dx = -dx;
          X = width - radius;
        }

        if (Y - radius < 0) {
          dy = -dy;
          Y = radius;
        } else if (Y + radius > height) {
          dy = -dy;
          Y = height - radius;
        }
        
        if (X1 - radius1 < 0) {
            dx1 = -dx1; 
            X1 = radius1; 
          } else if (X1 + radius1 > width) {
            dx1 = -dx1;
            X1 = width - radius1;
          }

          if (Y1 - radius1 < 0) {
            dy1 = -dy1;
            Y1 = radius1;
          } else if (Y1 + radius1 > height) {
            dy1 = -dy1;
            Y1 = height - radius1;
          }

          if (X2 - radius2 < 0) {
            dx2 = -dx2; 
            X2 = radius2; 
          } else if (X2 + radius2 > width) {
            dx2 = -dx2;
            X2 = width - radius2;
          }

          if (Y2 - radius2 < 0) {
            dy2 = -dy2;
            Y2 = radius2;
          } else if (Y2 + radius2 > height) {
            dy2 = -dy2;
            Y2 = height - radius2;
          }
          
        repaint();

        try {
          Thread.sleep(7-(rend-rstart));
        } catch (InterruptedException ex) {
        }

      }
    }
  };
  thread.start();
}

public void paintComponent(Graphics g) {
	  super.paintComponent(g);
	  setBackground(Color.DARK_GRAY); //added to set the background color to black (my eyes hurt)
	  g.setColor(Color.green); //box1 color
	  g.fillRect((int)(X-radius), (int)(Y-radius), (int)diameter, (int)diameter);
	  g.setColor(Color.blue); //box2 color
	  g.fillRect((int)(X1-radius1), (int)(Y1-radius1), (int)diameter1, (int)diameter1);
	  g.setColor(Color.magenta); //box3 color
	  g.fillRect((int)(X2-radius2), (int)(Y2-radius2), (int)diameter2, (int)diameter2);
	}

public static void main(String[] args) {
	  
	  BouncingBox fr = new BouncingBox();

	  JFrame frame = new JFrame("Bouncing Box");
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setSize(500, 500);
	  frame.setContentPane(new BouncingBox());
	  frame.setVisible(true);
	}
}