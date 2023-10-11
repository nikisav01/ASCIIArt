package exporters.art

import asciiArtApp.models.arts.AsciiArt
import asciiArtApp.models.pixels.AsciiPixel
import org.scalatest.FunSuite

import java.io.{ByteArrayOutputStream, File, FileOutputStream}
import scala.io.Source

class StreamArtExporterTest extends FunSuite {

  private val path = "src/test/resource/outputs/results/art-output.txt"
  private val refPath1 = "src/test/resource/outputs/reference/art1.txt"

  private val artToExport = AsciiArt(Seq[Seq[AsciiPixel]](
    Seq[AsciiPixel](AsciiPixel('1'), AsciiPixel('2'), AsciiPixel('3')),
    Seq[AsciiPixel](AsciiPixel('4'), AsciiPixel('5'), AsciiPixel('6')),
    Seq[AsciiPixel](AsciiPixel('7'), AsciiPixel('8'), AsciiPixel('9')),
  ))

  test("Export to file asciiArt") {
    val fileStream = new FileOutputStream(new File(path))
    val exporter = new StreamArtExporter(fileStream)

    exporter.`export`(artToExport)

    val testResult = Source.fromFile(path)
    val reference = Source.fromFile(refPath1)
    assert(reference.getLines().mkString == testResult.getLines().mkString)
  }

  test("Export to console asciiArt") {
    val outputStream = new ByteArrayOutputStream()
    val exporter = new StreamArtExporter(outputStream)

    exporter.`export`(artToExport)

    assert("123\n456\n789\n".equals(outputStream.toString()))
  }

}
