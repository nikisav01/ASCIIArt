package exporters.art

import java.io.{File, FileOutputStream}

class FileOutputExporter(file: File) extends StreamArtExporter(new FileOutputStream(file)) {
}
