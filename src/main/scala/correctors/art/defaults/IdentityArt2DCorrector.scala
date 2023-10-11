package correctors.art.defaults

import asciiArtApp.models.arts.GreyArt
import correctors.art.ArtCorrector
import correctors.defaults.IdentityCorrector

class IdentityArt2DCorrector extends IdentityCorrector[GreyArt] with ArtCorrector {
}
