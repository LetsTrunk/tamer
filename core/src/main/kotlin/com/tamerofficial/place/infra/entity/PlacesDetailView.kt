package com.tamerofficial.place.infra.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("places")
data class PlacesDetailView(
    @Id
    @Column("place_id")
    val placeId: Long? = null,

    @Column("place_name")
    val name : String,

    @Column("place_desc")
    val desc : String
)