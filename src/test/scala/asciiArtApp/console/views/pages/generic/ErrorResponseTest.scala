package asciiArtApp.console.views.pages.generic

import org.scalatest.FunSuite

class ErrorResponseTest extends FunSuite {
  test("Error response") {
    val errorMessage = "error message"
    val response = new ErrorResponse(errorMessage)
    assert("Error: " + errorMessage + "\n" == response.render())
  }
}
