package kr.ac.kumoh.s20220830.w25term_project_mongodb_backend.controller

import kr.ac.kumoh.s20220830.w25term_project_mongodb_backend.dto.PlayerDto
import kr.ac.kumoh.s20220830.w25term_project_mongodb_backend.model.Player
import kr.ac.kumoh.s20220830.w25term_project_mongodb_backend.service.PlayerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PlayerController(private val playerService: PlayerService) {
    @GetMapping("/{org}")
    fun getPlayers(@PathVariable org: String): ResponseEntity<List<PlayerDto>>{
        val result = playerService.getPlayersByOrg(org)
        return ResponseEntity.ok(result)
    }

    @GetMapping("/player/{playerId}")
    fun getPlayer(@PathVariable playerId: String):  ResponseEntity<Player> {
        val player = playerService.getPlayerById(playerId)
        return ResponseEntity.ok(player)
    }
}