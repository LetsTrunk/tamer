package com.tamerofficial.place.infra.dao


import com.tamerofficial.common.Location
import com.tamerofficial.place.infra.entity.PlacesListView
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlacesListViewRepository : ReactiveCrudRepository<PlacesListView,Long>{

    @Query("SELECT place_id, place_name, place_desc, latitude, longitude, address1, address2," +
            "            a.area_id as area_id, a.area_name as area_name," +
            "            a2.area_id as subarea_id, a2.area_name as subarea_name," +
            "            createdAt, updatedAt," +
            "            (6371 * acos(cos(radians(:#{#location.lat})) * cos(radians(latitude)) * cos(radians(longitude) - radians(:#{#location.lon})) + sin(radians(:#{#location.lat})) * sin(radians(latitude)))) " +
            "            AS distance " +
            "FROM places p " +
            "INNER JOIN areas a ON p.area_id = a.area_id " +
            "INNER JOIN areas a2 ON p.subarea_id = a2.area_id " +
            "HAVING distance <= :distance " +
            "ORDER BY distance " +
            "LIMIT :start,:end")
    fun findByDistanceIn(distance: Long, start: Int, end :Int, location: Location) : Flow<PlacesListView>

    @Query("SELECT place_id, place_name, place_desc, latitude, longitude, address1, address2," +
                "            a.area_id as area_id, a.area_name as area_name," +
                "            a2.area_id as subarea_id, a2.area_name as subarea_name," +
                "            createdAt, updatedAt," +
                "            (6371 * acos(cos(radians(:#{#location.lat})) * cos(radians(latitude)) * cos(radians(longitude) - radians(:#{#location.lon})) + sin(radians(:#{#location.lat})) * sin(radians(latitude)))) " +
                "            AS distance " +
                " FROM places p " +
                " INNER JOIN areas a ON p.area_id = a.area_id " +
                " INNER JOIN areas a2 ON p.subarea_id = a2.area_id " +
                " WHERE a.area_code = :areaCode"+
                " LIMIT :start,:end")
    fun findByArea(areaCode: String, start: Int, end: Int, location: Location) : Flow<PlacesListView>
}