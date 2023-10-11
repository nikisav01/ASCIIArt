package correctors.defaults

import org.scalatest.FunSuite

import scala.util.Random

class IdentityCorrectorTest extends FunSuite {
  test("Identity corrector Int") {
    val corrector = new IdentityCorrector[Int]
    val rand = Random

    for (i <- 0 until 10) {
      val item = rand.nextInt()
      assert(item == corrector.correct(item))
    }
  }

  test("Identity corrector String") {
    val corrector = new IdentityCorrector[String]
    val rand = Random

    for (i <- 0 until 10) {
      val item = rand.nextInt().toString
      assert(item == corrector.correct(item))
    }
  }
}
