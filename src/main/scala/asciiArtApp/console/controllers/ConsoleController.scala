package asciiArtApp.console.controllers
import asciiArtApp.console.views.pages.concrete.HelpPage
import asciiArtApp.console.views.pages.generic.{ErrorResponse, SuccessResponse}
import asciiArtApp.facades.ArtFacade
import asciiArtApp.models.arts.GreyArt
import asciiArtApp.models.tables.Table
import asciiArtApp.models.tables.nonlinear.MyNonLinearTable
import asciiArtApp.repositories.arts.InMemoryGreyArtRepository
import correctors.Corrector
import exporters.text.StdOutputExporter

class ConsoleController extends Controller {

  private val textExporter = new StdOutputExporter
  private val helpPage = new HelpPage
  private val successResponse = new SuccessResponse
  private val artFacade = new ArtFacade(new InMemoryGreyArtRepository)

  /**
   * Shows a help on show to use the UI.
   */
  override def showHelp(): Unit = {
    textExporter.`export`(helpPage.render())
  }

  /**
   * Shows an error.
   */
  override def showError(errorMessage: String): Unit = {
    textExporter.`export`(new ErrorResponse(errorMessage).render())
  }

  /**
   * Shows success message after every conversion.
   */
  override def showSuccess(): Unit = {
    textExporter.`export`(successResponse.render())
  }

  /**
   * Loads an image from file.
   * @param pathToImage The path to image.
   */
  override def loadFromFile(pathToImage: String): Unit = {
    artFacade.save(pathToImage)
  }

  /**
   * Convert an random image into ASCIIArt and print it in console.
   */
  override def loadRandomArt(): Unit = {
    artFacade.saveRandomImage()
  }

  override def applyCorrector(corrector: Corrector[GreyArt]): Unit = {
    artFacade.correct(corrector)
  }

  /**
   * Sets linear table for conversion.
   *
   * @param table The conversion table.
   */
  override def setTable(table: Table[Int, Char]): Unit = {
    artFacade.setTable(table)
  }

  /**
   * Forces the use of a non-linear conversion table.
   */
  override def useNonLinearTable(): Unit = {
    artFacade.setTable(MyNonLinearTable())
  }

  /**
   * Convert an image into ASCIIArt and print it in console.
   */
  override def convertImageToConsole(): Unit = {
    artFacade.exportToConsole()
  }

  /**
   * Convert an image into ASCIIArt and save it in file.
   * @param pathToOutputFile The path to output file.
   */
  override def convertImageToFile(pathToOutputFile: String): Unit = {
    artFacade.exportToFile(pathToOutputFile)
  }

  /**
   * Cleans up the application after converting an image.
   */
  override def cleanUp(): Unit = {
    artFacade.cleanUp()
    textExporter.`export`(successResponse.render())
  }
}
