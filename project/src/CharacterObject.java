import java.awt.Color;
import java.awt.Image;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

//This class represents both ghost and pacmen sprites */

public abstract class CharacterObject {
  
  protected static final Direction[] theDirections = {Direction.UP, Direction.DOWN, Direction.LEFT, Direction.RIGHT};
  
  
  protected static final Random theGenerator = new Random();
  
  protected static final int leftTransferX = 0;
  protected static final int rightTransferX = 22;
  protected static final int transferY = 11;
  
  protected final LocationPoint thePoint = new LocationPoint();
  
  protected final int startX;
  protected final int startY;
  
  protected Direction desiredDirection;
  protected Direction facingDirection;
  
  protected int x;
  protected int y;
  
  protected Color theColor;
  protected String name = "";
  protected ImageIcon icon;
  protected Image characterImage;
  
  //Constructor
  public CharacterObject(final int x, final int y, final Image characterImage){
    this.x = x;
    this.y = y;
    this.theColor = theColor;
    this.characterImage = characterImage;
    
    this.name = getName();
    
    this.startX = x;
    this.startY = y;
    
    facingDirection = Direction.UP;
  }
  
  // enumeration for potential directions of movement
  public enum Direction {
    UP, DOWN, LEFT, RIGHT; 
  }
  
  // Updates the direction and either the X or Y coordinate of the object
  // depending on the direction it is moving in 
  // param direction to move in
    public void move(Direction theD){
      
      if(theD == null) { 
        return;
      }   
      switch(theD) {
        case UP:
          this.y--;
          facingDirection = Direction.UP;
          break;
          
        case DOWN:
          this.y++;
          facingDirection = Direction.DOWN;
          break;
          
        case LEFT:
          this.x--;
          facingDirection = Direction.LEFT;
          break;
          
        case RIGHT:
          this.x++;
          facingDirection = Direction.RIGHT;
          break;
          
        default:
          break;
      }
      
      
      if(y == transferY) { 
        if(x == leftTransferX) { 
          x = rightTransferX;
        }
        else if(x == rightTransferX) { 
          x = leftTransferX;
        }
      }
    }
    
    // return ProspectivePoint if the item were to move in that direction
    public LocationPoint getProspectivePoint(final Direction theDirection) {
      switch(theDirection) {
        case UP:
          return new LocationPoint(x, y - 1);
        case DOWN:
          return new LocationPoint(x, y + 1);
        case LEFT:
          return new LocationPoint(x - 1, y);
        case RIGHT:
          return new LocationPoint(x + 1, y);
        default:
          return null;
      }
    }
    
    // return ProspectivePoint if the item were to move in that direction a certain distance
    public LocationPoint getProspectivePoint(final LocationPoint currentLoc, final Direction theDirection, final int units) {
      final int x = currentLoc.getX();
      final int y = currentLoc.getY();
      switch(theDirection) {
        case UP:
          return new LocationPoint(x, y - units);
        case DOWN:
          return new LocationPoint(x, y + units);
        case LEFT:
          return new LocationPoint(x - units, y);
        case RIGHT:
          return new LocationPoint(x + units, y);
        default:
          return null;
      }
    }
    
    // Returns a new LocationPoint from the given point and the direction
    public static LocationPoint getNewPoint(final LocationPoint theOriginal, final Direction theDirection) { 
      if(theOriginal == null || theDirection == null) { 
        return null;
      }
      
      switch(theDirection) { 
        case UP:
          return new LocationPoint(theOriginal.getX(), theOriginal.getY() - 1);
        case DOWN:
          return new LocationPoint(theOriginal.getX(), theOriginal.getY() + 1);
        case LEFT:
          return new LocationPoint(theOriginal.getX() - 1, theOriginal.getY());
        case RIGHT:
          return new LocationPoint(theOriginal.getX() + 1, theOriginal.getY());
        default:
          return null;
      }
    }
    
    // Return the opposite direction
    public static Direction getOppositeDirection(final Direction theDirection) { 
      if(theDirection == Direction.RIGHT) { 
        return Direction.LEFT;
      }
      else if(theDirection == Direction.LEFT) { 
        return Direction.RIGHT; 
      }
      else if(theDirection == Direction.UP) { 
        return Direction.DOWN;
      }
      else if(theDirection == Direction.DOWN) { 
        return Direction.UP;
      }
      else
        return null;
    }
    
    // Returns random direction
    public static Direction getRandomDirection() { 
      return theDirections[theGenerator.nextInt(theDirections.length)];
    }
    
    // param new point
    public void setPoint(final LocationPoint thePoint) {
      this.x = (int) thePoint.getX();
      this.y = (int) thePoint.getY();
    }
    
    // return item color  
    public Color getColor() { 
      return this.theColor;
    }
    
    // set item color
    public void setColor(Color tC) { 
      this.theColor = tC; 
    }
    
    // return starting X coord
    public int getStartX() {
      return this.startX; 
    }
    
    // return starting Y coord
    public int getStartY() { 
      return this.startY;
    }
    
    // Returns the item to initial position by
    // setting X and Y coordinates to the ones first given in the constructor
    public void returnToStartPosition() {
      this.x = this.startX;
      this.y = this.startY;
      this.facingDirection = Direction.UP;
    }
    
    // return Direction item is facing
    public Direction getFacingDirection() {
      return facingDirection;
    }
    
    // set current facing Direction
    public void setFacingDirection(Direction facing) {
      this.facingDirection = facing;
    }
    
    // set desired facing Direction
    public void setDesiredDirection(Direction desired) { 
      this.desiredDirection = desired;
    }
    
    // get desired Direction
    public Direction getDesiredDirection() { 
      return this.desiredDirection;
    }
   
    // get current X coord
    public int getX() {
      return this.x;
    }
    
    // get current Y coord
    public int getY() {
      return this.y;
    }
    
    // set current X coord
    public void setX(int x) {
      this.x = x;
    }
    
    // set current Y coord
    public void setY(int y) {
      this.y = y;
    }
    
    // get current LocationPoint
    public LocationPoint getPoint() {
      return new LocationPoint(x, y);
    }
    
    // name getter based on color
    private String getName() {
      if(theColor == Color.WHITE)
        return "White";
      else if(theColor == Color.RED)
        return "Red";
      else if(theColor == Color.BLUE)
        return "Blue";
      else if(theColor == Color.YELLOW)
        return "Yellow";
      else if(theColor == Color.GREEN)
        return "Green";
      return "Error";
    }
}