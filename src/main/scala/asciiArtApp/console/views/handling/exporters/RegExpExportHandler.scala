package asciiArtApp.console.views.handling.exporters

import asciiArtApp.console.views.handling.RegExpCommandHandler

import scala.util.matching.Regex

abstract class RegExpExportHandler(regExp: Regex) extends RegExpCommandHandler(regExp){
}
