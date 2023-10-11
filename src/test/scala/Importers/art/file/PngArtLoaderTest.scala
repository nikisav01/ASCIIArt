package Importers.art.file

import org.scalatest.FunSuite

class PngArtLoaderTest extends FunSuite {
  test("passing null in class") {
    val importer = new FileArtLoaderFromPath(null)
    assertThrows[IllegalArgumentException](importer.load())
  }

  test("import a non-existing file") {
    val importer = new FileArtLoaderFromPath("non-existing/file")
    assertThrows[IllegalArgumentException](importer.load())
  }

  test("import png image") {
    val importer = new PngArtLoader("src/test/resource/images/img.png")
    val art = importer.load()
    assert(art.width == 99)
    assert(art.height == 55)
  }
}
