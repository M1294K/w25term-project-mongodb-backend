package kr.ac.kumoh.s20220830.w25term_project_mongodb_backend.repository

import kr.ac.kumoh.s20220830.w25term_project_mongodb_backend.model.Player
import org.springframework.data.mongodb.repository.MongoRepository


interface PlayerRepository : MongoRepository<Player, String> {
    fun findByOrganizationIgnoreCase(organization: String): List<Player>

}