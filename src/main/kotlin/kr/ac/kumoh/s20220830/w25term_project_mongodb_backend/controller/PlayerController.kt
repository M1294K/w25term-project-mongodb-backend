package kr.ac.kumoh.s20220830.w25term_project_mongodb_backend.controller

import kr.ac.kumoh.s20220830.w25term_project_mongodb_backend.dto.PlayerDto
import kr.ac.kumoh.s20220830.w25term_project_mongodb_backend.model.Player
import kr.ac.kumoh.s20220830.w25term_project_mongodb_backend.service.PlayerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = ["https://m1294k.github.io"])
class PlayerController(private val playerService: PlayerService) {
    @GetMapping("/player")
    fun getAllPlayers(): ResponseEntity<List<PlayerDto>>{
        val result = playerService.getAllPlayers()
        return ResponseEntity.ok(result)
    }

    @GetMapping("/player/{playerId}")
    fun getPlayer(@PathVariable playerId: String):  ResponseEntity<Player> {
        val player = playerService.getPlayerById(playerId)
        return ResponseEntity.ok(player)
    }
}