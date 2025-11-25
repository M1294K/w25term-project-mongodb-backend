package kr.ac.kumoh.s20220830.w25term_project_mongodb_backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "players")
data class Player(
    @Id val id: String? = null,
    val name: String,
    val nation: String,
    val age: Int?,
    val rating: Int,
    val win: Int,
    val lose: Int,
    val draw: Int,
    val height: Int,
    val reach: Int,
    val weight: Int,
    val division: String,
    val imageSrc: String? = null,
    val saying: String? = null,
    val organization: String,
)
