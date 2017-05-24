public class LocationPoint {
	//class for mapping all directionality to U/D/L/R directional system
	
  private int x;
  private int y;
  
  //constructor
  public LocationPoint(final int x, final int y) { 
    this.x = x;
    this.y = y;
  }
  
  //constructor
  public LocationPoint() { 
    this.x = 0;
    this.y = 0;
  }
  
  
  //getX coord
  public int getX() { 
    return this.x;
  }
  
  //getY coord
  public int getY() {
    return this.y;
  }
  
  //setX coord
  public void setX(final int newX) { 
    this.x = newX;
  }
  
  //setY coord
  public void setY(final int newY) { 
    this.y = newY;
  }
  
  //toString method
  public String toString() { 
    return "X: " + this.x + "\tY: " + y;
  }
  
  //boolean for checking for matches on grid spots
  public boolean equals(final LocationPoint theOtherPoint) { 
    return (this.x == theOtherPoint.getX() && this.y == theOtherPoint.getY());
  }
}