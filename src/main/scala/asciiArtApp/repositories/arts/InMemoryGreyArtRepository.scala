package asciiArtApp.repositories.arts

import asciiArtApp.models.arts.GreyArt

class InMemoryGreyArtRepository {

  private var art: Option[GreyArt] = None

  def get(): GreyArt = {
    if (art.isEmpty)
      throw new IllegalStateException("No art in repository is present")
    else
      art.get
  }

  def save(artToSave: GreyArt): Unit = {
    art = Some(artToSave)
  }

  def delete(): Unit = {
    art = None
  }
}
