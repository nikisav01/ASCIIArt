package exporters.art

import asciiArtApp.models.arts.AsciiArt

import java.io.OutputStream

class StreamArtExporter(outputStream: OutputStream) extends ArtExporters {

  private var closed = false

  protected def exportToStream(art: AsciiArt): Unit = {
    if (closed)
      throw new Exception("The stream is already closed")

    var content = ""

    for (i <- art.getGrid.indices) {
      var raw = ""
      for (j <- art.getRaw(i).indices) {
        raw += art.getPixel(i, j).char
      }
      content += raw + "\n"
    }

    outputStream.write(content.getBytes("UTF-8"))
    outputStream.flush()
  }

  def close(): Unit = {
    if (closed)
      return

    outputStream.close()
    closed = true
  }

  /**
   * Exports item somewhere
   *
   * @param item The item to export
   */
  override def export(item: AsciiArt): Unit = exportToStream(item)
}
