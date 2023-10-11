package asciiArtApp.repositories.arts

import asciiArtApp.models.arts.GreyArt
import asciiArtApp.models.pixels.GreyPixel
import org.scalatest.FunSuite

class InMemoryGreyArtRepositoryTest extends FunSuite {
  test("Getting non-existing art") {
    val repository = new InMemoryGreyArtRepository
    assertThrows[IllegalStateException](repository.get())
  }
  test("Save get and delete art") {
    val repository = new InMemoryGreyArtRepository
    val art = GreyArt(Seq(
      Seq(GreyPixel(10), GreyPixel(20)),
      Seq(GreyPixel(30), GreyPixel(40)),
      Seq(GreyPixel(50), GreyPixel(60))
    ))
    repository.save(art)
    val artFromRepo = repository.get()
    for (i <- art.getGrid.indices) {
      for (j <- art.getRaw(i).indices) {
        assert(art.getPixel(i, j).greyVal == artFromRepo.getPixel(i, j).greyVal)
      }
    }
    repository.delete()
    assertThrows[IllegalStateException](repository.get())
  }
}
