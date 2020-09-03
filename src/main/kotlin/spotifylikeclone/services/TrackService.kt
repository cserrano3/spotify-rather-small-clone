package spotifylikeclone.services

import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import spotifylikeclone.models.Track
import spotifylikeclone.util.BasicCrud
import java.util.Optional

@Service
class TrackService(val trackDAO: TrackDAO, private val albumDAO: AlbumDAO): BasicCrud<String, Track> {
    override fun getAll(pageable: Pageable) {

    }

    override fun getById(id: String): Optional<Track> = trackDAO.findById(id)

    override fun insert(document: Track): Track = trackDAO.insert(document.apply {
        this.album = document.album?.id?.let {
            albumDAO.findById(it).get()
        }
    })

    @Throws(Exception::class)
    override fun update(document: Track): Track {
        return if(trackDAO.existsById(document.id)) {
            trackDAO.save(document.apply {
                this.album = document.album?.id?.let { albumDAO.findById(it).get() }
                // the let() function allows an object to be accessed in a well-defined scope, it's like a closure in JS.
            })
        } else {
            throw object : Exception("Track not found"){}
        }
    }

    override fun deleteById(id: String): Optional<Track> {
        return trackDAO.findById(id).apply {
           this.ifPresent {
               trackDAO.delete(it)
           }
        }
    }
}
