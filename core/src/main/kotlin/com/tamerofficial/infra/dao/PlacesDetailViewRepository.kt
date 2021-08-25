package com.tamerofficial.infra.dao


import com.tamerofficial.infra.entity.PlaceEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlacesDetailViewRepository : CrudRepository<PlaceEntity,Long>{

    /***
     * 조건이 될수 있는 조합들은..?
     * 조회 조건을 명시하는 Class가 필요하다
     * 정렬 조건 : SCORE(어느점수?), 거리순, 조회순, 스크랩순
     *
     * 조회 조건 WHERE AND OR
     * AreaCode, SubAreaCode 하나, 둘다
     * Distance In
     */

//    fun findByAreaCodeOrderByScoreDesc(): Flow<PlacesView>

//    @Query("SELECT place_id, place_name, place_desc, latitude, longitude, address1, address2," +
//            "            a.area_id as area_id, a.area_name as area_name," +
//            "            a2.area_id as subarea_id, a2.area_name as subarea_name," +
//            "            createdAt, updatedAt," +
//            "            (6371 * acos(cos(radians(37.4685225)) * cos(radians(latitude)) * cos(radians(longitude) - radians(126.8943311)) + sin(radians(37.4685225)) * sin(radians(latitude)))) " +
//            "            AS distance " +
//            "FROM places p " +
//            "INNER JOIN areas a ON p.area_id = a.area_id " +
//            "INNER JOIN areas a2 ON p.subarea_id = a2.area_id " +
//            "WHERE a.area_code = :areaCode "+
//            "HAVING distance <= :distance " +
//            "ORDER BY distance DESC " +
//            "LIMIT :start,:end")
//    fun findByAreaCodeOrderByDistanceDesc(): Flow<PlaceEntity>
//
//    @Query("SELECT place_id, place_name, place_desc, latitude, longitude, address1, address2," +
//            "     a.area_id as area_id, a.area_name as area_name," +
//            "     a2.area_id as subarea_id, a2.area_name as subarea_name," +
//            "     createdAt, updatedAt" +
//            " FROM places p " +
//            " INNER JOIN areas a ON p.area_id = a.area_id " +
//            " INNER JOIN areas a2 ON p.subarea_id = a2.area_id " +
//            " WHERE a.area_code = :areaCode "+
//            " ORDER BY view_cnt DESC"+
//            " LIMIT :start,:end")
//    fun findByAreaCodeOrderByViewCntDesc(): Flow<PlaceEntity>
//
//    @Query("SELECT place_id, place_name, place_desc, latitude, longitude, address1, address2," +
//            "     a.area_id as area_id, a.area_name as area_name," +
//            "     a2.area_id as subarea_id, a2.area_name as subarea_name," +
//            "     createdAt, updatedAt" +
//            " FROM places p " +
//            " INNER JOIN areas a ON p.area_id = a.area_id " +
//            " INNER JOIN areas a2 ON p.subarea_id = a2.area_id " +
//            " WHERE a.area_code = :areaCode "+
//            " ORDER BY scrap_cnt DESC"+
//            " LIMIT :start,:end")
//    fun findByAreaCodeOrderByScrapCntDesc(): Flow<PlaceEntity>
//
////    fun findByAreaCodeAndSubAreaCodeOrderByScoreDesc(): Flow<PlacesView>
//
//    @Query("SELECT place_id, place_name, place_desc, latitude, longitude, address1, address2," +
//            "            a.area_id as area_id, a.area_name as area_name," +
//            "            a2.area_id as subarea_id, a2.area_name as subarea_name," +
//            "            createdAt, updatedAt," +
//            "            (6371 * acos(cos(radians(37.4685225)) * cos(radians(latitude)) * cos(radians(longitude) - radians(126.8943311)) + sin(radians(37.4685225)) * sin(radians(latitude)))) " +
//            "            AS distance " +
//            "FROM places p " +
//            "INNER JOIN areas a ON p.area_id = a.area_id " +
//            "INNER JOIN areas a2 ON p.subarea_id = a2.area_id " +
//            "WHERE a.area_code = :areaCode AND a.subarea_code = :subareaCode"+
//            "HAVING distance <= :distance " +
//            "ORDER BY distance DESC " +
//            "LIMIT :start,:end")
//    fun findByAreaCodeAndSubAreaCodeOrderByDistanceDesc(): Flow<PlaceEntity>
//
//    @Query("SELECT place_id, place_name, place_desc, latitude, longitude, address1, address2," +
//            "     a.area_id as area_id, a.area_name as area_name," +
//            "     a2.area_id as subarea_id, a2.area_name as subarea_name," +
//            "     createdAt, updatedAt" +
//            " FROM places p " +
//            " INNER JOIN areas a ON p.area_id = a.area_id " +
//            " INNER JOIN areas a2 ON p.subarea_id = a2.area_id " +
//            " WHERE a.area_code = :areaCode AND a.subarea_code = :subareaCode"+
//            " ORDER BY view_cnt DESC"+
//            " LIMIT :start,:end")
//    fun findByAreaCodeAndSubAreaCodeOrderByViewCntDesc(): Flow<PlaceEntity>
//
//    @Query("SELECT place_id, place_name, place_desc, latitude, longitude, address1, address2," +
//            "     a.area_id as area_id, a.area_name as area_name," +
//            "     a2.area_id as subarea_id, a2.area_name as subarea_name," +
//            "     createdAt, updatedAt" +
//            " FROM places p " +
//            " INNER JOIN areas a ON p.area_id = a.area_id " +
//            " INNER JOIN areas a2 ON p.subarea_id = a2.area_id " +
//            " WHERE a.area_code = :areaCode AND a.subarea_code = :subareaCode"+
//            " ORDER BY scrap_cnt DESC"+
//            " LIMIT :start,:end")
//    fun findByAreaCodeAndSubAreaCodeOrderByScrapCntDesc(): Flow<PlaceEntity>
//
//
//    @Query("SELECT place_id, place_name, place_desc, latitude, longitude, address1, address2," +
//            "            a.area_id as area_id, a.area_name as area_name," +
//            "            a2.area_id as subarea_id, a2.area_name as subarea_name," +
//            "            createdAt, updatedAt," +
//            "            (6371 * acos(cos(radians(37.4685225)) * cos(radians(latitude)) * cos(radians(longitude) - radians(126.8943311)) + sin(radians(37.4685225)) * sin(radians(latitude)))) " +
//            "            AS distance " +
//            "FROM places p " +
//            "INNER JOIN areas a ON p.area_id = a.area_id " +
//            "INNER JOIN areas a2 ON p.subarea_id = a2.area_id " +
//            "HAVING distance <= :distance " +
//            "LIMIT :start,:end")
//    fun findByDistanceInOrderByScoreDesc(distance: Long, start: Int, end :Int): Flow<PlaceEntity>
//
//    @Query("SELECT place_id, place_name, place_desc, latitude, longitude, address1, address2," +
//            "            a.area_id as area_id, a.area_name as area_name," +
//            "            a2.area_id as subarea_id, a2.area_name as subarea_name," +
//            "            createdAt, updatedAt," +
//            "            (6371 * acos(cos(radians(37.4685225)) * cos(radians(latitude)) * cos(radians(longitude) - radians(126.8943311)) + sin(radians(37.4685225)) * sin(radians(latitude)))) " +
//            "            AS distance " +
//            "FROM places p " +
//            "INNER JOIN areas a ON p.area_id = a.area_id " +
//            "INNER JOIN areas a2 ON p.subarea_id = a2.area_id " +
//            "HAVING distance <= :distance " +
//            "ORDER BY distance DESC " +
//            "LIMIT :start,:end")
//    fun findByDistanceInOrderByDistanceDesc(distance: Long, start: Int, end :Int): Flow<PlaceEntity>
//
//    @Query("SELECT place_id, place_name, place_desc, latitude, longitude, address1, address2," +
//            "            a.area_id as area_id, a.area_name as area_name," +
//            "            a2.area_id as subarea_id, a2.area_name as subarea_name," +
//            "            createdAt, updatedAt," +
//            "            (6371 * acos(cos(radians(37.4685225)) * cos(radians(latitude)) * cos(radians(longitude) - radians(126.8943311)) + sin(radians(37.4685225)) * sin(radians(latitude)))) " +
//            "            AS distance " +
//            "FROM places p " +
//            "INNER JOIN areas a ON p.area_id = a.area_id " +
//            "INNER JOIN areas a2 ON p.subarea_id = a2.area_id " +
//            "HAVING distance <= :distance " +
//            "ORDER BY view_cnt DESC " +
//            "LIMIT :start,:end")
//    fun findByDistanceInOrderByViewCntDesc(distance: Long, start: Int, end :Int): Flow<PlaceEntity>
//
//    @Query("SELECT place_id, place_name, place_desc, latitude, longitude, address1, address2," +
//            "            a.area_id as area_id, a.area_name as area_name," +
//            "            a2.area_id as subarea_id, a2.area_name as subarea_name," +
//            "            createdAt, updatedAt," +
//            "            (6371 * acos(cos(radians(37.4685225)) * cos(radians(latitude)) * cos(radians(longitude) - radians(126.8943311)) + sin(radians(37.4685225)) * sin(radians(latitude)))) " +
//            "            AS distance " +
//            "FROM places p " +
//            "INNER JOIN areas a ON p.area_id = a.area_id " +
//            "INNER JOIN areas a2 ON p.subarea_id = a2.area_id " +
//            "HAVING distance <= :distance " +
//            "ORDER BY scrap_cnt DESC " +
//            "LIMIT :start,:end")
//    fun findByDistanceInOrderByScrapCntDesc(distance: Long, start: Int, end :Int): Flow<PlaceEntity>
//
//
//
//    @Query("SELECT place_id, place_name, place_desc, latitude, longitude, address1, address2, " +
//            "a.area_id as area_id, a.area_name as area_name, " +
//            "a2.area_id as subarea_id, a2.area_name as subarea_name, " +
//            "createdAt, updatedAt" +
//            " FROM places p INNER JOIN areas a ON p.area_id = a.area_id INNER JOIN areas a2 ON p.subarea_id = a2.area_id")
//    override fun findAll(): Flux<PlaceEntity>
//
//    @Query("SELECT place_id, place_name, place_desc, latitude, longitude, address1, address2," +
//            "            a.area_id as area_id, a.area_name as area_name," +
//            "            a2.area_id as subarea_id, a2.area_name as subarea_name," +
//            "            createdAt, updatedAt," +
//            "            (6371 * acos(cos(radians(37.4685225)) * cos(radians(latitude)) * cos(radians(longitude) - radians(126.8943311)) + sin(radians(37.4685225)) * sin(radians(latitude)))) " +
//            "            AS distance " +
//            "FROM places p " +
//            "INNER JOIN areas a ON p.area_id = a.area_id " +
//            "INNER JOIN areas a2 ON p.subarea_id = a2.area_id " +
//            "HAVING distance <= :distance " +
//            "ORDER BY distance " +
//            "LIMIT :start,:end")
//    fun findByDistanceIn(distance: Long, start: Int, end :Int) : Flow<PlaceEntity>
//
//    @Query("SELECT place_id, place_name, place_desc, latitude, longitude, address1, address2," +
//                "     a.area_id as area_id, a.area_name as area_name," +
//                "     a2.area_id as subarea_id, a2.area_name as subarea_name," +
//                "     createdAt, updatedAt" +
//                " FROM places p " +
//                " INNER JOIN areas a ON p.area_id = a.area_id " +
//                " INNER JOIN areas a2 ON p.subarea_id = a2.area_id " +
//                " WHERE a.area_code = :areaCode"+
//                " LIMIT :start,:end")
//    fun findByArea(areaCode: String, start: Int, end: Int) : Flow<PlaceEntity>
}