import java.awt.Color;
import java.awt.Image;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/* super representation of Pacman */

// ghost player class

public class GhostPlayer extends CharacterObject {
  public GhostPlayer(int x, int y, Image theClyde) {
    super(x, y, theClyde);
  }
  
  @Override
  public String toString() { 
    return "GhostPlayer. X: " + this.x + "\tY: " + this.y;
  }
}
