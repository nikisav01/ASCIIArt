package asciiArtApp.console.views.pages.concrete

import org.scalatest.FunSuite

class HelpPageTest extends FunSuite {
  test("Help page") {
    val page = new HelpPage
    val reference: String = "-----COMMANDS-----\nstop | exit\n-----IMAGE SOURCE-----\n--image \"./pathToImage/image.jpg\" ...\n--image-random ...\n-----OUTPUTS-----\n--output-file \"./path/to/output/file.txt\" ...\n--output-console ...\n-----TABLES-----\n--custom-table \"*custom table*\" ...\n--table \"table name\" ...\n-----FILTERS-----\n--brightness value\n--rotate degrees\n--invert\n"
    assert(page.render() == reference)
  }
}
