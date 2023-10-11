package correctors.art.specific

  import asciiArtApp.models.arts.GreyArt
  import asciiArtApp.models.pixels.GreyPixel
  import org.scalatest.FunSuite

  class RotateArtCorrectorTest extends FunSuite {
    val toRotateNonSquare: GreyArt = GreyArt(Seq(
      Seq(GreyPixel(1), GreyPixel(2)),
      Seq(GreyPixel(3), GreyPixel(4)),
      Seq(GreyPixel(5), GreyPixel(6))))

    test("Test rotating a \"non-square\" image by 90 and -270 degree") {
      val corrector1 = new RotateArtCorrector(90)
      val corrector2 = new RotateArtCorrector(-270)
      val rotatedArt1 = corrector1.correct(toRotateNonSquare)
      val rotatedArt2 = corrector2.correct(toRotateNonSquare)

      val resultNonSquareArt: GreyArt = GreyArt(Seq(
        Seq(GreyPixel(5), GreyPixel(3), GreyPixel(1)),
        Seq(GreyPixel(6), GreyPixel(4), GreyPixel(2))))

      assert(rotatedArt1.height == rotatedArt2.height && rotatedArt1.height == resultNonSquareArt.height)
      assert(rotatedArt1.width == rotatedArt2.width && rotatedArt1.width == resultNonSquareArt.width)
      for (i <- rotatedArt1.getGrid.indices) {
        assert(rotatedArt1.getRaw(i).length == rotatedArt2.getRaw(i).length
            && rotatedArt1.getRaw(i).length == resultNonSquareArt.getRaw(i).length)
      }
      for (i <- rotatedArt1.getGrid.indices) {
        for (j <- rotatedArt1.getRaw(i).indices) {
          assert(rotatedArt1.getPixel(i, j).greyVal == rotatedArt2.getPixel(i, j).greyVal
              && rotatedArt1.getPixel(i, j).greyVal == resultNonSquareArt.getPixel(i, j).greyVal)
        }
      }
    }

    test("Test rotating a \"non-square\" image by -90 and 270 degree") {
      val corrector1 = new RotateArtCorrector(-90)
      val corrector2 = new RotateArtCorrector(270)
      val rotatedArt1 = corrector1.correct(toRotateNonSquare)
      val rotatedArt2 = corrector2.correct(toRotateNonSquare)

      val resultNonSquareArt: GreyArt = GreyArt(Seq(
        Seq(GreyPixel(2), GreyPixel(4), GreyPixel(6)),
        Seq(GreyPixel(1), GreyPixel(3), GreyPixel(5))))

      assert(rotatedArt1.height == rotatedArt2.height && rotatedArt1.height == resultNonSquareArt.height)
      assert(rotatedArt1.width == rotatedArt2.width && rotatedArt1.width == resultNonSquareArt.width)
      for (i <- rotatedArt1.getGrid.indices) {
        assert(rotatedArt1.getRaw(i).length == rotatedArt2.getRaw(i).length
          && rotatedArt1.getRaw(i).length == resultNonSquareArt.getRaw(i).length)
      }
      for (i <- rotatedArt1.getGrid.indices) {
        for (j <- rotatedArt1.getRaw(i).indices) {
          assert(rotatedArt1.getPixel(i, j).greyVal == rotatedArt2.getPixel(i, j).greyVal
            && rotatedArt1.getPixel(i, j).greyVal == resultNonSquareArt.getPixel(i, j).greyVal)
        }
      }
    }

    test("Test rotating a \"non-square\" image by 180 and -180 degree") {
    val corrector1 = new RotateArtCorrector(180)
    val corrector2 = new RotateArtCorrector(-180)
    val rotatedArt1 = corrector1.correct(toRotateNonSquare)
    val rotatedArt2 = corrector2.correct(toRotateNonSquare)

    val resultNonSquareArt: GreyArt = GreyArt(Seq(
      Seq(GreyPixel(6), GreyPixel(5)),
      Seq(GreyPixel(4), GreyPixel(3)),
      Seq(GreyPixel(2), GreyPixel(1))))

    assert(rotatedArt1.height == rotatedArt2.height && rotatedArt1.height == resultNonSquareArt.height)
    assert(rotatedArt1.width == rotatedArt2.width && rotatedArt1.width == resultNonSquareArt.width)
    for (i <- rotatedArt1.getGrid.indices) {
      assert(rotatedArt1.getRaw(i).length == rotatedArt2.getRaw(i).length
        && rotatedArt1.getRaw(i).length == resultNonSquareArt.getRaw(i).length)
    }
    for (i <- rotatedArt1.getGrid.indices) {
      for (j <- rotatedArt1.getRaw(i).indices) {
        assert(rotatedArt1.getPixel(i, j).greyVal == rotatedArt2.getPixel(i, j).greyVal
          && rotatedArt1.getPixel(i, j).greyVal == resultNonSquareArt.getPixel(i, j).greyVal)
      }
    }
  }

  test("Test rotating a \"non-square\" image by 360 and 0 degree") {
    val corrector1 = new RotateArtCorrector(0)
    val corrector2 = new RotateArtCorrector(360)
    val rotatedArt1 = corrector1.correct(toRotateNonSquare)
    val rotatedArt2 = corrector2.correct(toRotateNonSquare)

    assert(rotatedArt1.height == rotatedArt2.height && rotatedArt1.height == toRotateNonSquare.height)
    assert(rotatedArt1.width == rotatedArt2.width && rotatedArt1.width == toRotateNonSquare.width)
    for (i <- rotatedArt1.getGrid.indices) {
      assert(rotatedArt1.getRaw(i).length == rotatedArt2.getRaw(i).length
        && rotatedArt1.getRaw(i).length == toRotateNonSquare.getRaw(i).length)
    }
    for (i <- rotatedArt1.getGrid.indices) {
      for (j <- rotatedArt1.getRaw(i).indices) {
        assert(rotatedArt1.getPixel(i, j).greyVal == rotatedArt2.getPixel(i, j).greyVal
          && rotatedArt1.getPixel(i, j).greyVal == toRotateNonSquare.getPixel(i, j).greyVal)
      }
    }
  }

  test("Rotate on 89 degree") {
    val corrector = new RotateArtCorrector(89)
    assertThrows[IllegalArgumentException](corrector.correct(GreyArt(Seq[Seq[GreyPixel]]())))
  }
}
