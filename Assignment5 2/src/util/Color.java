package util;

/**
 * Represents a color, which consists of a red, green, and blue value.
 */
public class Color {
  private int r;
  private int g;
  private int b;

  /**
   * Constructor for Color class.
   * @param r     int representation of color's red value between 0 and 255
   * @param g     int representation of color's green value between 0 and 255
   * @param b     int representation of color's blue value between 0 and 255
   */
  public Color(int r, int g, int b) {
    checkValidColorValue(r);
    checkValidColorValue(g);
    checkValidColorValue(b);
    this.r = r;
    this.g = g;
    this.b = b;
  }

  private void checkValidColorValue(int c) {
    if (c < 0 || c > 255) {
      throw new IllegalArgumentException("Invalid rgb value");
    }
  }

  /**
   * Sets the color's red value.
   * @param r     int representation of color's red value
   */
  public void setR(int r) {
    checkValidColorValue(r);
    this.r = r;
  }

  /**
   * Sets the color's green value.
   * @param g     int representation of color's green value
   */
  public void setG(int g) {
    checkValidColorValue(g);
    this.g = g;
  }

  /**
   * Sets the color's blue value.
   * @param b     int representation of color's blue value
   */
  public void setB(int b) {
    checkValidColorValue(b);
    this.b = b;
  }

  /**
   * Retrieves the color's red value.
   * @return     int representation of color's red value
   */
  public int getR() {
    return r;
  }

  /**
   * Retrieves the color's green value.
   * @return     int representation of color's green value
   */
  public int getG(){
    return g;
  }

  /**
   * Retrieves the color's blue value.
   * @return     int representation of color's blue value
   */
  public int getB() {
    return b;
  }

}
