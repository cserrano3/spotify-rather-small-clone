package spotifylikeclone.models

import org.bson.types.ObjectId
import org.bson.types.ObjectId.get
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Track(@Id
                 val id: String = ObjectId.get().toHexString() , var album: Album?, val name: String, val length: String)