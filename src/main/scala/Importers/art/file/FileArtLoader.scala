package Importers.art.file

import Importers.art.ArtLoader
import asciiArtApp.models.arts.Art

trait FileArtLoader[T <: Art] extends ArtLoader[T] {
}
