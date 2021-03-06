package spotifylikeclone.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Artist (
        @Id
        val id: ObjectId = ObjectId.get(),
        val name: String,
        val Albums: List<Album>)
