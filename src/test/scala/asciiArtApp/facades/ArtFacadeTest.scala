package asciiArtApp.facades

import asciiArtApp.repositories.arts.InMemoryGreyArtRepository
import org.scalatest.FunSuite

class ArtFacadeTest extends FunSuite {

  private val repository = new InMemoryGreyArtRepository
  private val facade = new ArtFacade(repository)

  test("Save unsupported image") {
    assertThrows[IllegalArgumentException](facade.save("images/art.txt"))
  }

}
