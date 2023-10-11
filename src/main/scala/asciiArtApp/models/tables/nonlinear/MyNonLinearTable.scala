package asciiArtApp.models.tables.nonlinear

case class MyNonLinearTable(table: String = " :*@") extends NonLinearTable {
  /**
   * Converts greyscale value into a char
   *
   * @param greyValue The greyscale value
   * @return
   */
  override def convert(greyValue: Int): Char = {
    if (greyValue < 0 || greyValue > 255)
      throw new IllegalArgumentException("Grey value must be a positive number.")
    else if (greyValue < 150)
      table(3)
    else if (greyValue < 200)
      table(2)
    else if (greyValue < 230)
      table(1)
    else
      table(0)
  }
}
