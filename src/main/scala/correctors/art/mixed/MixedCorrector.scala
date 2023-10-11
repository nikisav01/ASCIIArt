package correctors.art.mixed

import asciiArtApp.models.arts.GreyArt
import correctors.art.ArtCorrector

class MixedCorrector(filters: Seq[ArtCorrector]) extends ArtCorrector{
  /**
   * Iterate over correctors and correct an item using all of them
   *
   * @param item The item to correct
   * @return The corrected item
   */
  override def correct(item: GreyArt): GreyArt = {
    filters.foldLeft(item)((accumulator, filter) => filter.correct(accumulator))
  }
}
