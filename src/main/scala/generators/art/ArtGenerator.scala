package generators.art

import asciiArtApp.models.arts.Art
import generators.Generator

trait ArtGenerator[T <: Art] extends Generator[T] {
}
