package com.example.composeschedule.network.dto
@kotlinx.serialization.Serializable
data class UserDto(
    val id: Int,
    val name: String,
    val email: String,
    val email_verified_at: String? = "",
    val created_at: String,
    val updated_at: String,
    val two_factor_secret: String? = "",
    val two_factor_recovery_codes: String? = "",
    val is_admin: Boolean,
    val group_id: Int? = null,
    val teacher_id: Int? = null
)
/*"user": {
    "id": 2,
    "name": "admin",
    "email": "admin@gmail.com",
    "email_verified_at": null,
    "created_at": "2023-03-10T18:20:34.000000Z",
    "updated_at": "2023-03-10T18:20:34.000000Z",
    "two_factor_secret": null,
    "two_factor_recovery_codes": null,
    "is_admin": true,
    "group_id": null,
    "teacher_id": null
}*/