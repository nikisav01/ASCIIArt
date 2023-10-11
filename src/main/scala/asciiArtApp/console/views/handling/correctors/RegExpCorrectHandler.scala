package asciiArtApp.console.views.handling.correctors

import asciiArtApp.console.views.handling.RegExpCommandHandler

import scala.util.matching.Regex

abstract class RegExpCorrectHandler(regExp: Regex) extends RegExpCommandHandler(regExp){
}
