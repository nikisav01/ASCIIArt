package exporters.text

import java.io.OutputStream

class StreamTextExporter(outputStream: OutputStream) extends TextExporters {

  private var closed = false

  protected def exportToStream(text: String): Unit = {
    if (closed)
      throw new Exception("The stream is already closed")

    outputStream.write(text.getBytes("UTF-8"))
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
  override def export(item: String): Unit = exportToStream(item)
}
