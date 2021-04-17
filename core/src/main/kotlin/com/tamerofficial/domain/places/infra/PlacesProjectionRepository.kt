package com.tamerofficial.domain.places.infra

import com.tamerofficial.domain.places.infra.entity.ScoreAttributeEntity
import kotlinx.coroutines.flow.Flow
import org.springframework.data.annotation.Id
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import java.time.LocalDateTime

@Repository
interface PlacesProjectionRepository : ReactiveCrudRepository<PlacesView,Long>{
    @Query("SELECT place_id, place_name, place_desc, latitude, longitude, address1, address2, " +
            "a.area_id as area_id, a.area_name as area_name, " +
            "a2.area_id as subarea_id, a2.area_name as subarea_name, " +
            "createdAt, updatedAt" +
            " FROM places p INNER JOIN areas a ON p.area_id = a.area_id INNER JOIN areas a2 ON p.subarea_id = a2.area_id")
    override fun findAll(): Flux<PlacesView>

    @Query("SELECT place_id, place_name, place_desc, latitude, longitude, address1, address2," +
            "            a.area_id as area_id, a.area_name as area_name," +
            "            a2.area_id as subarea_id, a2.area_name as subarea_name," +
            "            createdAt, updatedAt," +
            "            (6371 * acos(cos(radians(37.4685225)) * cos(radians(latitude)) * cos(radians(longitude) - radians(126.8943311)) + sin(radians(37.4685225)) * sin(radians(latitude)))) " +
            "            AS distance " +
            "FROM places p " +
            "INNER JOIN areas a ON p.area_id = a.area_id " +
            "INNER JOIN areas a2 ON p.subarea_id = a2.area_id " +
            "HAVING distance <= :distance " +
            "ORDER BY distance " +
            "LIMIT :start,:end")
    fun findByDistanceIn(distance: Long, start: Int, end :Int) : Flow<PlacesView>
}


data class PlacesView(
    @Id
    @Column("place_id")
    val placeId: Long? = null,

    @Column("place_name")
    val name : String,
    @Column("place_desc")
    val desc : String,

    @Column("latitude")
    val lat : Long,

    @Column("longitude")
    val lon : Long,

    @Column("address1")
    val address1: String,
    @Column("address2")
    val address2: String,

    @Column("area_id")
    val areaId : Long = 0,

    @Column("area_name")
    val areaName : String,

    @Column("subarea_id")
    val subareaId : Long = 0,

    @Column("subarea_name")
    val subareaName : String,

    @Transient
    var scores : List<ScoreAttributeEntity> = mutableListOf(),

    @Column("createdAt")
    val createdAt : LocalDateTime?,
    @Column("updatedAt")
    val updatedAt : LocalDateTime?
)
