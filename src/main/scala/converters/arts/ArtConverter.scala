package converters.arts

import asciiArtApp.models.arts.Art
import converters.Converter

trait ArtConverter[T <: Art, R <: Art] extends Converter[T, R] {
}
