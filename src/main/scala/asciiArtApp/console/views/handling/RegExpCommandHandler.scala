package asciiArtApp.console.views.handling

import responsibilityChain.Handler

import scala.util.matching.Regex

abstract class RegExpCommandHandler(regExp: Regex)
  extends CommandHandler {

  override def handle(command: String): Option[Handler[String]] = {
    // Example:
    // command = "run ... --image "first-image.jpg" ... --image "second-image.jpg" ..."
    // regExp = "--image\\s*\"(\\S*)\"".r
    // matchedValues == ("first-image.jpg", "second-image.jpg")
    var matchedValues = Seq[String]()
    regExp.findAllIn(command).matchData.foreach(matchedCommand => matchedValues = matchedValues :+ matchedCommand.group(1))

    if (matchedValues.nonEmpty)
      processCommand(matchedValues)

    nextHandler
  }

  def commandName: String
}
