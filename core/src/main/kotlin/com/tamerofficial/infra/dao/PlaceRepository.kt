package com.tamerofficial.infra.dao

import com.tamerofficial.infra.entity.PlaceEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlaceRepository : CrudRepository<PlaceEntity,Long>{
//    @Query("SELECT place_id, place_name, place_desc, latitude, longitude, address1, address2," +
//            "            a.area_id as area_id, a.area_name as area_name," +
//            "            a2.area_id as subarea_id, a2.area_name as subarea_name," +
//            "            createdAt, updatedAt," +
//            "            (6371 * acos(cos(radians(:#{#location.lat})) * cos(radians(latitude)) * cos(radians(longitude) - radians(:#{#location.lon})) + sin(radians(:#{#location.lat})) * sin(radians(latitude)))) " +
//            "            AS distance " +
//            "FROM places p " +
//            "INNER JOIN areas a ON p.area_id = a.area_id " +
//            "INNER JOIN areas a2 ON p.subarea_id = a2.area_id " +
//            "HAVING distance <= :distance " +
//            "ORDER BY distance " +
//            "LIMIT :start,:end")
//    fun findByDistanceIn(distance: Long, start: Int, end :Int, location: Location) : Flow<PlaceEntity>
//
//    @Query("SELECT place_id, place_name, place_desc, latitude, longitude, address1, address2," +
//            "            a.area_id as area_id, a.area_name as area_name," +
//            "            a2.area_id as subarea_id, a2.area_name as subarea_name," +
//            "            createdAt, updatedAt," +
//            "            (6371 * acos(cos(radians(:#{#location.lat})) * cos(radians(latitude)) * cos(radians(longitude) - radians(:#{#location.lon})) + sin(radians(:#{#location.lat})) * sin(radians(latitude)))) " +
//            "            AS distance " +
//            " FROM places p " +
//            " INNER JOIN areas a ON p.area_id = a.area_id " +
//            " INNER JOIN areas a2 ON p.subarea_id = a2.area_id " +
//            " WHERE a.area_code = :areaCode"+
//            " LIMIT :start,:end")
//    fun findByArea(areaCode: String, start: Int, end: Int, location: Location) : Flow<PlaceEntity>
}