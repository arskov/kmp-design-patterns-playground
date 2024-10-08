/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package design

class Library {
    fun someLibraryMethod(): Boolean {
        return true
    }
}

interface ChessPiece {
    var file: Char
    var rank: Char
}

data class Pawn(
    override var file: Char, override var rank: Char
) : ChessPiece