package asciiArtApp.models.tables.linear

class CustomLinearTable(table: String) extends LinearTable {
  if (table.isEmpty)
    throw new IllegalArgumentException("Conversion table can't be empty.")

  /**
   * Converts greyscale value into a char
   *
   * @param greyValue The greyscale value
   * @return
   */
  override def convert(greyValue: Int): Char = {
    if (greyValue < 0 || greyValue > 255)
      throw new IllegalArgumentException("Grey value must be a positive number that less than 256.")
    else {
      table(table.length - (greyValue/(256.0/table.length)).toInt - 1)
    }
  }
}
