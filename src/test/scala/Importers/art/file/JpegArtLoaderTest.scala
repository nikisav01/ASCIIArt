package Importers.art.file

import org.scalatest.FunSuite

class JpegArtLoaderTest extends FunSuite {

  test("import jpg image") {
    val importer = new JpegArtLoader("src/test/resource/images/img4.jpg")
    val art = importer.load()
    assert(art.width == 800)
    assert(art.height == 534)
  }

  test("passing null in class") {
    val importer = new FileArtLoaderFromPath(null)
    assertThrows[IllegalArgumentException](importer.load())
  }

  test("import a non-existing file") {
    val importer = new FileArtLoaderFromPath("non-existing/file")
    assertThrows[IllegalArgumentException](importer.load())
  }

}
