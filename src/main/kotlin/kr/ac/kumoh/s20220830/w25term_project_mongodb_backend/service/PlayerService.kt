package kr.ac.kumoh.s20220830.w25term_project_mongodb_backend.service

import kr.ac.kumoh.s20220830.w25term_project_mongodb_backend.dto.PlayerDto
import kr.ac.kumoh.s20220830.w25term_project_mongodb_backend.model.Player
import kr.ac.kumoh.s20220830.w25term_project_mongodb_backend.repository.PlayerRepository
import org.springframework.stereotype.Service

@Service
class PlayerService(private val playerRepository: PlayerRepository) {
    fun getAllPlayers(): List<PlayerDto> = playerRepository.findAll().map {
        PlayerDto(
            id = it.id ?: "",
            name = it.name,
            division = it.division,
            rating = it.rating,
            imageSrc = it.imageSrc ?: "",
            organization = it.organization,
        )
    }
    fun getPlayerById(playerId: String): Player = playerRepository.findById(playerId).orElseThrow { RuntimeException("Player not found: $playerId") }
}