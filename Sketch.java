import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
  // initializes images
  PImage imgBackground;
  PImage imgFirework;
  PImage imgDvd;
  // initializes screen size variables
  int intScreenW = 600;
  int intScreenH = 600;
  // initializes firework variables
  float fltFireworkX;
  float fltFireworkY;
  float fltFireworkSpeedX = 2;
  float fltFireworkSpeedY = 2;
  int intFireworkSize = 200;
  // initializes DVD variables
  float fltDvdX;
  float fltDvdY;
  float fltDvdSpeed = 1;
  int intDvdWidth = 80;
  int intDvdHeight = 40;
  // initializes circle variables
  float fltCircleX;
  float fltCircleY;
  float fltCircleSpeedX = 3;
  float fltCircleSpeedY = 3;
  int intCircleDia = 50;

  /**
   * initializes background size
   * 
   * @author NJudd
   */
  public void settings() {
    size(intScreenW, intScreenH);
  }

  /**
   * initializes the background image and objects position
   * 
   * @author NJudd
   */
  public void setup() {
    // background image
    imgBackground = loadImage("rain.jpg");
    imgBackground.resize(intScreenW, intScreenH);
    // firework image
    imgFirework = loadImage("firework.png");
    imgFirework.resize(intFireworkSize, intFireworkSize);
    // firework position
    fltFireworkX = 200;
    fltFireworkY = 300;
    // dvd image
    imgDvd = loadImage("DVD_logo.png");
    imgDvd.resize(intDvdWidth, intDvdHeight);
    // dvd position
    fltDvdX = 10;
    fltDvdY = 200;
    // circle position
    fltCircleX = 25;
    fltCircleY = 100;
  }

  /**
   * top level method to execute the program
   * 
   * @author Njudd
   */
  public void draw() {
    // prints background image
    image(imgBackground, 0, 0);
    // prints firework image
    image(imgFirework, fltFireworkX, fltFireworkY);
    // modifies firework position
    fltFireworkX = fltFireworkX + fltFireworkSpeedX;
    fltFireworkY = fltFireworkY - fltFireworkSpeedY;
    // collision
    if ((fltFireworkX + intFireworkSize - 35 >= width) || (fltFireworkX + 45 <= 0)) {
      fltFireworkSpeedX = fltFireworkSpeedX * -1;
    } 
    if ((fltFireworkY + intFireworkSize - 12 >= height) || (fltFireworkY + 16 <= 0)) {
      fltFireworkSpeedY = fltFireworkSpeedY * -1;
    }
    // prints dvd image
    image(imgDvd, fltDvdX, fltDvdY);
    // modifies dvd position
    fltDvdX = fltDvdX + fltDvdSpeed;
    fltDvdY = fltDvdY + 8 * (float) Math.sin(0.05 * fltDvdX);
    // horizontal collision
    if ((fltDvdX <= 0) || (fltDvdX + intDvdWidth >= width)){
      fltDvdSpeed = fltDvdSpeed * -1;
    }
    // vertical collision
    if (fltDvdY <= 0) {
      fltDvdY = 1;
    } 
    if (fltDvdY + intDvdHeight >= height) {
      fltDvdY = height - 1 - intDvdHeight;
    }
    // sets circle colour
    stroke(255);
    fill(255);
    // draws circle
    ellipse(fltCircleX, fltCircleY, intCircleDia, intCircleDia);
    // modifies circle position
    fltCircleX = fltCircleX + fltCircleSpeedX;
    fltCircleY = fltCircleY + fltCircleSpeedY;
    // collision
    if ((fltCircleX + 25 >= width) || (fltCircleX - 25 <= 0)) {
      fltCircleSpeedX = fltCircleSpeedX * -1;
    }
    if ((fltCircleY + 25 >= height) || (fltCircleY - 25 <= 0)) {
      fltCircleSpeedY = fltCircleSpeedY * -1;
    }
  }
}