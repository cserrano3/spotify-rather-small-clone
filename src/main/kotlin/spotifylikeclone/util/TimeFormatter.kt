package spotifylikeclone.util

class TimeFormatter(val minutes: Int, val seconds: Int) {
    override fun toString(): String {
        return String.format("%02: %02", minutes, seconds)
    }
}