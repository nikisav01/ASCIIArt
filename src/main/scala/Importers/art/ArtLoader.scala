package Importers.art

import Importers.Loader
import asciiArtApp.models.arts.Art

trait ArtLoader[T <: Art] extends Loader[T] {
}
