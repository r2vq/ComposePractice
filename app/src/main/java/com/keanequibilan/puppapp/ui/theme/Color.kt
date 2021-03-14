package com.keanequibilan.puppapp.ui.theme

import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val MovieBlue = Color(0xFF000099)
val ONAGreen = Color(0xFF006699)
val OVAGreen = Color(0xFF00AA66)
val TVGreen = Color(0xFF009966)
val UnknownBlack = Color(0xFF000000)
val ErrorRed = Color(0xFFFF0000)

sealed class PokemonTypeColour(
    val normal: Color,
    val dark: Color,
    val light: Color
) {
    object Normal : PokemonTypeColour(Color(0xFFA8A878), Color(0xFF6D6D4E), Color(0xFFC6C6A7))
    object Fighting : PokemonTypeColour(Color(0xFFC03028), Color(0xFF7D1F1A), Color(0xFFD67873))
    object Flying : PokemonTypeColour(Color(0xFFA890F0), Color(0xFF6D5E9C), Color(0xFFC6B7F5))
    object Poison : PokemonTypeColour(Color(0xFFA040A0), Color(0xFF682A68), Color(0xFFC183C1))
    object Ground : PokemonTypeColour(Color(0xFFE0C068), Color(0xFF927D44), Color(0xFFEBD69D))
    object Rock : PokemonTypeColour(Color(0xFFB8A038), Color(0xFF786824), Color(0xFFD1C17D))
    object Bug : PokemonTypeColour(Color(0xFFA8B820), Color(0xFF6D7815), Color(0xFFC6D16E))
    object Ghost : PokemonTypeColour(Color(0xFF705898), Color(0xFF493963), Color(0xFFA292BC))
    object Steel : PokemonTypeColour(Color(0xFFB8B8D0), Color(0xFF787887), Color(0xFFD1D1E0))
    object Fire : PokemonTypeColour(Color(0xFFF08030), Color(0xFF9C531F), Color(0xFFF5AC78))
    object Water : PokemonTypeColour(Color(0xFF6890F0), Color(0xFF445E9C), Color(0xFF9DB7F5))
    object Grass : PokemonTypeColour(Color(0xFF78C850), Color(0xFF4E8234), Color(0xFFA7DB8D))
    object Electric : PokemonTypeColour(Color(0xFFF8D030), Color(0xFFA1871F), Color(0xFFFAE078))
    object Psychic : PokemonTypeColour(Color(0xFFF85888), Color(0xFFA13959), Color(0xFFFA92B2))
    object Ice : PokemonTypeColour(Color(0xFF98D8D8), Color(0xFF638D8D), Color(0xFFBCE6E6))
    object Dragon : PokemonTypeColour(Color(0xFF7038F8), Color(0xFF4924A1), Color(0xFFA27DFA))
    object Dark : PokemonTypeColour(Color(0xFF705848), Color(0xFF49392F), Color(0xFFA29288))
    object Fairy : PokemonTypeColour(Color(0xFFEE99AC), Color(0xFF9B6470), Color(0xFFF4BDC9))
    object Unknown : PokemonTypeColour(Color(0xFF68A090), Color(0xFF44685E), Color(0xFF9DC1B7))
    object Shadow : PokemonTypeColour(Color(0xFF2C2E2B), Color(0xFF1D1E1C), Color(0xFF767775))
}
