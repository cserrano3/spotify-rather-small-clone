package spotifylikeclone.services

import spotifylikeclone.models.Album
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.Optional

interface AlbumDAO: MongoRepository<Album, String>{
    fun findById(id: ObjectId): Optional<Album>
    fun findByName(name: String): Album
    override fun findAll(): List<Album>
}