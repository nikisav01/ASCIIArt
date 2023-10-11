package asciiArtApp.console.views.pages.concrete

import asciiArtApp.console.views.pages.TextPage

class HelpPage extends TextPage{
  /**
   * Renders the help page
   *
   * @return
   */
  override def render(): String = {
    var content: String = ""

    content += "-----COMMANDS-----\n"
    content += "stop | exit\n"
    content += "-----IMAGE SOURCE-----\n"
    content += "--image \"./pathToImage/image.jpg\" ...\n"
    content += "--image-random ...\n"
    content += "-----OUTPUTS-----\n"
    content += "--output-file \"./path/to/output/file.txt\" ...\n"
    content += "--output-console ...\n"
    content += "-----TABLES-----\n"
    content += "--custom-table \"*custom table*\" ...\n"
    content += "--table \"table name\" ...\n"
    content += "-----FILTERS-----\n"
    content += "--brightness value\n"
    content += "--rotate degrees\n"
    content += "--invert\n"

    content
  }
}
