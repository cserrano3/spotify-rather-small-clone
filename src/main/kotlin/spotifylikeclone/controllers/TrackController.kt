package spotifylikeclone.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import spotifylikeclone.dto.TrackDTO
import spotifylikeclone.models.Track
import spotifylikeclone.services.TrackService
import java.util.Optional

@RestController
@RequestMapping("/track")
public class TrackController(private val trackService: TrackService) {
    @GetMapping("{id}")
    fun getById(@PathVariable id: String): Optional<Track> = trackService.getById(id)

    @PostMapping
    fun create(@RequestBody request: TrackDTO): ResponseEntity<Track> {
        println("post message................. $request")
        val track = trackService.insert(Track(
                name = request.name,
                length = request.length,
                album = null
        ))

        return ResponseEntity(track, HttpStatus.CREATED)

    }
}