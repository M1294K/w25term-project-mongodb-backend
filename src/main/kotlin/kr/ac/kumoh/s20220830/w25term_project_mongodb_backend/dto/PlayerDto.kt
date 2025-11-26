package kr.ac.kumoh.s20220830.w25term_project_mongodb_backend.dto

data class PlayerDto(
    val id: String,
    val name: String,
    val division: String,
    val rating: Int,
    val imageSrc: String? = null,
    val organization: String,
)
