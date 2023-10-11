package responsibilityChain

import org.scalatest.FunSuite

class SimpleHandlerTest extends FunSuite {
  test("Test setNext") {
    val simpleHandler = new SimpleHandler[Int]
    val nextHandler = new SimpleHandler[Int]

    assert(simpleHandler.nextHandler.isEmpty)
    assert(nextHandler.nextHandler.isEmpty)

    simpleHandler.setNext(nextHandler)
    assert(simpleHandler.nextHandler.get == nextHandler)
    assert(nextHandler.nextHandler.isEmpty)
  }

  test("Test empty()") {
    assert(SimpleHandler.empty().isInstanceOf[SimpleHandler[Nothing]])
  }
}
