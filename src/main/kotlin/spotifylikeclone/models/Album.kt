package spotifylikeclone.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
    data class Album (
        @Id
        val id: ObjectId = ObjectId.get(),
        val tracks: MutableList<Track>,
        val artists: List<Artist>,
        val name: String

)