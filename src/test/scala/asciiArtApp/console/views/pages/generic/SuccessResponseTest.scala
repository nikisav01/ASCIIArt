package asciiArtApp.console.views.pages.generic

import org.scalatest.FunSuite

class SuccessResponseTest extends FunSuite {
  test("Success response") {
    val response = new SuccessResponse
    assert("Success.\n" == response.render())
  }
}
