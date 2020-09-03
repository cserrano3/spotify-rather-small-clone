package spotifylikeclone.services

import spotifylikeclone.models.Album
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.Optional

interface AlbumDAO: MongoRepository<Album, String>{
    fun findById(id: ObjectId): Optional<Album>
    fun findByName(name: String): Album
    fun findByArtistName(name: String): Album
    fun findByArtistId(id: ObjectId): Album
    override fun findAll(): List<Album>
    abstract fun existsById(id: ObjectId): Boolean
}