package asciiArtApp.console.controllers

import asciiArtApp.models.arts.GreyArt
import asciiArtApp.models.tables.Table
import correctors.Corrector

trait Controller {

  /**
   * Shows a help on how to use the UI.
   */
  def showHelp(): Unit

  /**
   * Shows an error.
   */
  def showError(errorMessage: String): Unit

  /**
   * Shows success message after every conversion.
   */
  def showSuccess(): Unit

  /**
   * Load an image from file.
   * @param pathToImage The path to image.
   */
  def loadFromFile(pathToImage: String): Unit

  /**
   * Generates random art.
   */
  def loadRandomArt(): Unit

  /**
   * Applies corrector to the art.
   * @param corrector The corrector to apply.
   */
  def applyCorrector(corrector: Corrector[GreyArt]): Unit

  /**
   * Sets linear table for conversion.
   * @param table The conversion table.
   */
  def setTable(table: Table[Int, Char]): Unit

  /**
   * Forces the use of a non-linear conversion table.
   */
  def useNonLinearTable(): Unit

  /**
   * Convert an image into ASCIIArt and print it in console.
   */
  def convertImageToConsole(): Unit

  /**
   * Convert an image into ASCIIArt and save it in file.
   * @param pathToOutputFile The path to output file.
   */
  def convertImageToFile(pathToOutputFile: String): Unit

  /**
   * Cleans up the application after converting an image.
   */
  def cleanUp(): Unit
}
