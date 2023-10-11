package asciiArtApp.console.views.handling.loaders

import asciiArtApp.console.views.handling.RegExpCommandHandler

import scala.util.matching.Regex

abstract class RegExpLoadHandler(regExp: Regex) extends RegExpCommandHandler(regExp) {
}
