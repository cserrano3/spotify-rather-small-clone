package spotifylikeclone.services

import spotifylikeclone.models.Track
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.Optional

interface TrackDAO: MongoRepository<Track, String>{
    fun findById(id: ObjectId): Optional<TrackDAO>
    fun findBykName(name: String): Track
    fun findByAlbumId(album_id: ObjectId): List<Track>
    abstract fun existsById(id: ObjectId): Boolean
}