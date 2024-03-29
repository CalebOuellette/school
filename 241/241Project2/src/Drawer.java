
/**
 * Drawer illustrates some basics of Java 2D.
 * This version is compliant with Java 1.2 Beta 3, Jun 1998.
 * Please refer to: <BR>
 * http://www.javaworld.com/javaworld/jw-07-1998/jw-07-media.html
 * <P>
 * @author Bill Day <bill.day@javaworld.com>
 * @version 1.0
 * @see java.awt.Graphics2D
 **/

/**
 Geoffrey Matthews modified this code to show how to make
 an image pixel by pixel.
 13 April 2017
 **/

import java.awt.*;
import java.awt.event.*;

public class Drawer extends Frame {


    private World world;

    /**
     * Our Drawer constructor sets the frame's size, adds the
     * visual components, and then makes them visible to the user.
     * It uses an adapter class to deal with the user closing
     * the frame.
     **/
    public Drawer(World w) {

        //Title our frame.
        super("Java 2D Drawer");

        this.world = w;
        //Set the size for the frame.
        setSize(Constants.WIDTH, Constants.HEIGHT);

        //We need to turn on the visibility of our frame
        //by setting the Visible parameter to true.
        setVisible(true);

        //Now, we want to be sure we properly dispose of resources
        //this frame is using when the window is closed.  We use
        //an anonymous inner class adapter for this.
        addWindowListener(new WindowAdapter()
                          {public void windowClosing(WindowEvent e)
                          {dispose(); System.exit(0);}
                          }
        );
    }

    /**
     * The paint method provides the real magic.  Here we
     * cast the Graphics object to Graphics2D to illustrate
     * that we may use the same old graphics capabilities with
     * Graphics2D that we are used to using with Graphics.
     **/
    public void paint(Graphics g) {
        for (int u = 0 ; u < Constants.WIDTH; u++) {
            for (int v = 0 ; v < Constants.HEIGHT; v++) {
                g.setColor(world.getColor(u,v));
		/* For some reason the designers of Java
		   graphics didn't include a primitive to
		   draw a single pixel.  So... */
                g.drawLine(u,v,u,v);
            }
        }
    }
}
