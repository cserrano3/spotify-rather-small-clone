package spotifylikeclone.services

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import spotifylikeclone.models.Track
import spotifylikeclone.util.BasicCrud
import java.util.Optional

@Service//declare this class as a Service "Component specialization"

class TrackService(val trackDAO: TrackDAO, private val albumDAO: AlbumDAO): BasicCrud<String, Track> {
    override fun getAll(pageable: Pageable) {

    }

    override fun getById(id: String): Optional<Track> = trackDAO.findById(id)

    override fun insert(document: Track): Track = trackDAO.insert(document.apply {
        this.album = document.album?.id?.let {
            albumDAO.findById(it).get()
        }
    })

    override fun update(document: Track): Track {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String): String {
        TODO("Not yet implemented")
    }


}