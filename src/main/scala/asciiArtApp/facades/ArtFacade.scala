package asciiArtApp.facades

import Importers.art.file.{JpegArtLoader, PngArtLoader}
import asciiArtApp.models.arts.{AsciiArt, GreyArt, RgbArt}
import asciiArtApp.models.tables.Table
import asciiArtApp.models.tables.linear.BourkesTable
import asciiArtApp.repositories.arts.InMemoryGreyArtRepository
import converters.arts.{GreyToAsciiArtConverter, RgbToGreyArtConverter}
import correctors.Corrector
import exporters.art.{FileOutputExporter, StdOutputExporter}
import generators.art.RandomGreyArtGenerator

import java.io.File

class ArtFacade(artRepository: InMemoryGreyArtRepository) {

  private var table: Table[Int, Char] = BourkesTable()
  private val toGreyArtConverter: RgbToGreyArtConverter = new RgbToGreyArtConverter
  private val consoleOutputExporter: StdOutputExporter = new StdOutputExporter
  private val artGenerator = new RandomGreyArtGenerator

  def setTable(table: Table[Int, Char]): Unit = {
    this.table = table
  }

  def save(pathToImage: String): Unit = {
    var rgbArt: Option[RgbArt] = None

    // loads image from file
    if (pathToImage.endsWith(".jpeg") || pathToImage.endsWith(".jpg")) {
      rgbArt = Some(new JpegArtLoader(pathToImage).load())
    } else if (pathToImage.endsWith(".png")) {
      rgbArt = Some(new PngArtLoader(pathToImage).load())
    } else {
      throw new IllegalArgumentException("Unsupported image format. Try jpeg/jpg or png instead.")
    }

    // all manipulations on the GreyArt are easier to carry out
    val greyArt: GreyArt = toGreyArtConverter.convert(rgbArt.get)

    // save current art for easy filtering later
    artRepository.save(greyArt)
  }

  def saveRandomImage(): Unit = {
    artRepository.save(artGenerator.generate())
  }

  def correct(corrector: Corrector[GreyArt]): Unit = {
    val greyArt = artRepository.get()
    val correctedArt = corrector.correct(greyArt)
    artRepository.save(correctedArt)
  }

  def exportToFile(pathToExport: String): Unit = {
    if (!pathToExport.endsWith(".txt"))
      throw new IllegalArgumentException("The export file must have the .txt extension.")

    val asciiArt = getAsciiArt(table)
    val fileOutputExporter: FileOutputExporter = new FileOutputExporter(new File(pathToExport))
    fileOutputExporter.export(asciiArt)
  }

  def exportToConsole(): Unit = {
    val asciiArt = getAsciiArt(table)
    consoleOutputExporter.export(asciiArt)
  }

  def cleanUp(): Unit = {
    artRepository.delete()
    table = BourkesTable()
  }

  protected def getAsciiArt(table: Table[Int, Char]): AsciiArt = {
    val toAsciiArtConverter = new GreyToAsciiArtConverter(table)
    toAsciiArtConverter.convert(artRepository.get())
  }
}
