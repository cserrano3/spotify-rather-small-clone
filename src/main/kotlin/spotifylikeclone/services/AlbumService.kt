package spotifylikeclone.services


import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import spotifylikeclone.models.Album
import spotifylikeclone.util.BasicCrud
import java.util.Optional

@Service
class AlbumService(val albumDAO: AlbumDAO, private val artistDAO: ArtistDAO): BasicCrud<String, Album> {
    override fun getAll(pageable: Pageable) {

    }

    override fun getById(id: String): Optional<Album> = albumDAO.findById(id)

    override fun insert(document: Album): Album = albumDAO.insert(document.apply {
        this.artist = document.artist.id.let { artistDAO.findById(it).get() }
    })


    @Throws(Exception::class)
    override fun update(document: Album): Album {
        return if(document.id?.let { albumDAO.existsById(it) }!!) {
            albumDAO.save(document.apply {
                this.artist = document.artist.id.let {
                    artistDAO.findById(it).get()
                }
            })
        } else {
            throw object : Exception("Track not found"){}
        }
    }

    override fun deleteById(id: String): Optional<Album> {
        return albumDAO.findById(id).apply {
            this.ifPresent {
                albumDAO.delete(it)
            }
        }
    }
}
