package exporters.text

import org.scalatest.FunSuite

import java.io.{ByteArrayOutputStream, File, FileOutputStream}
import scala.io.Source

class StreamTextExporterTest extends FunSuite {

  private val path = "src/test/resource/outputs/results/text-output.txt"
  val toExport = "Testing StreamTextExporter.export()"

  test("Export text to file") {
    val fileStream = new FileOutputStream(new File(path))
    val exporter = new StreamTextExporter(fileStream)

    exporter.`export`(toExport)

    val source = Source.fromFile(path)
    assert(toExport == source.getLines().mkString)
  }

  test("Export text to stream") {
    val stream = new ByteArrayOutputStream()
    val exporter = new StreamTextExporter(stream)

    exporter.`export`(toExport)
    assert(toExport.equals(stream.toString()))
  }
}
