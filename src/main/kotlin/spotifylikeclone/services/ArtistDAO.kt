package spotifylikeclone.services

import spotifylikeclone.models.Artist
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.Optional

interface ArtistDAO: MongoRepository<Artist, String>{
    fun findById(id: ObjectId): Optional<Artist>
    fun findByName(name: String): Artist
    override fun findAll(): List<Artist>
}