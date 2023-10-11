package asciiArtApp.console.views.rendering

import asciiArtApp.console.controllers.Controller
import asciiArtApp.models.arts.GreyArt
import asciiArtApp.models.tables.Table
import asciiArtApp.models.tables.linear.BourkesTable
import asciiArtApp.models.tables.nonlinear.MyNonLinearTable
import correctors.Corrector
import correctors.art.specific.{InvertArtCorrector, RotateArtCorrector}
import org.mockito.MockitoSugar.{mock, verify}
import org.mockito.captor.ArgCaptor
import org.scalatest.FunSuite

class ConsoleViewTest extends FunSuite {
  def makeView(controller: Controller): ConsoleView =
    new ConsoleView(controller)

  test("Process command without --image") {
    val mockController = mock[Controller]
    val view = makeView(mockController)
    val command = "--rotate 90 --output-console"

    val idCapture = ArgCaptor[String]
    view.processCommand(command)

    verify(mockController).showError(idCapture)

    assert(idCapture.value == "Command must have one image source. Try \"--image \"path\\image.png\"\" or \"--image-random\".")
  }

  test("Process command with --image \"path\" --image-random") {
    val mockController = mock[Controller]
    val view = makeView(mockController)
    val command = "--image \"path.png\" --image-random --rotate 90 --output-console"

    val idCapture = ArgCaptor[String]

    view.processCommand(command)
    verify(mockController).showError(idCapture)
    assert(idCapture.value == "Command must have one image source.")
  }

  test("Process command with --image \"path\" --image \"path\"") {
    val mockController = mock[Controller]
    val view = makeView(mockController)
    val command = "--image \"path.png\" --image \"path12.png\" --rotate 90 --output-console"

    val idCapture = ArgCaptor[String]

    view.processCommand(command)
    verify(mockController).showError(idCapture)
    assert(idCapture.value == "Command must have one image source.")
  }

  test("Process command without --output") {
    val mockController = mock[Controller]
    val view = makeView(mockController)
    val command = "--image-random --rotate 90 "

    val idCapture = ArgCaptor[String]
    view.processCommand(command)

    verify(mockController).showError(idCapture)

    assert(idCapture.value == "Command must have at least one output. Try \"--output-console\" or \"--output-file \"path\"\".")
  }

  test("Process command with multiple tables") {
    val mockController = mock[Controller]
    val view = makeView(mockController)
    val command = "--image-random --rotate 90 --table \"non-linear\" --custom-table \"132312\" --output-file \"file.txt\""

    val idCapture = ArgCaptor[String]
    view.processCommand(command)

    verify(mockController).showError(idCapture)

    assert(idCapture.value == "Command can't contain more than one tables.")
  }

  test("Valid command 1") {
    val mockController = mock[Controller]
    val view = makeView(mockController)
    val command = "--image-random --invert --table \"non-linear\" --output-file \"file.txt\""

    val idCapture1 = ArgCaptor[Corrector[GreyArt]]
    val idCapture2 = ArgCaptor[Table[Int, Char]]
    val idCapture3 = ArgCaptor[String]

    view.processCommand(command)

    verify(mockController).loadRandomArt()
    verify(mockController).applyCorrector(idCapture1)
    verify(mockController).setTable(idCapture2)
    verify(mockController).convertImageToFile(idCapture3)
    verify(mockController).cleanUp()

    assert(idCapture1.value.isInstanceOf[InvertArtCorrector])
    assert(idCapture2.value.isInstanceOf[MyNonLinearTable])
    assert(idCapture3.value == "file.txt")
  }

  test("Valid command 2") {
    val mockController = mock[Controller]
    val view = makeView(mockController)
    val command = "--image \"image.png\" --rotate 90  --table \"bourke\" --output-console "

    val idCapture1 = ArgCaptor[String]
    val idCapture2 = ArgCaptor[Corrector[GreyArt]]
    val idCapture3 = ArgCaptor[Table[Int, Char]]

    view.processCommand(command)

    verify(mockController).loadFromFile(idCapture1)
    verify(mockController).applyCorrector(idCapture2)
    verify(mockController).setTable(idCapture3)
    verify(mockController).convertImageToConsole()
    verify(mockController).cleanUp()

    assert(idCapture1.value == "image.png")
    assert(idCapture2.value.isInstanceOf[RotateArtCorrector])
    assert(idCapture3.value.isInstanceOf[BourkesTable])
  }
}
