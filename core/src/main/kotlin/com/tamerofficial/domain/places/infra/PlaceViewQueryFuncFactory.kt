package com.tamerofficial.domain.places.infra

import com.tamerofficial.domain.common.Location
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Component
import java.lang.RuntimeException

class PlaceSearchCriteria(
    val areaCode: String? = null,
    val subAreas: List<String> = emptyList(),
    val sortBy: SortBy = SortBy.SCORE,
    val distance: Long = 0,
    val currentLocation: Location? = null
){
    fun isAreaBase(): Boolean {
        return !areaCode.isNullOrEmpty()
    }

    fun isLocationBase(): Boolean {
        return areaCode.isNullOrEmpty() && distance > 0 && currentLocation != null
    }
}
enum class SearchBy{
    AREA,DISTANCE
}
enum class SortBy{
    SCORE,
    DISTANCE,
    VIEW_CNT,
    SCRAP_CNT
}
/***
 * 조건이 될수 있는 조합들은..?
 * 조회 조건을 명시하는 Class가 필요하다
 * 정렬 조건 : SCORE(어느점수?), 거리순, 조회순, 스크랩순
 *
 * 조회 조건 WHERE AND OR
 * AreaCode, SubAreaCode 하나, 둘다
 * Distance In
 */


@Component
class PlaceViewQueryFuncFactory(private val placesProjectionRepository: PlacesProjectionRepository) {
    fun <T> search(condition: T) : (start:Int, end:Int) -> Flow<PlacesView> =
        when(condition){
            is Long -> currying(condition, placesProjectionRepository::findByDistanceIn)
            is String -> currying(condition, placesProjectionRepository::findByArea)
            else -> throw RuntimeException("Not Supported")
        }

    private fun <T> currying(param : T ,fnc : (a:T,start:Int,end:Int)->Flow<PlacesView>) : (start:Int, end:Int) -> Flow<PlacesView> {
        return { start, end -> fnc.invoke(param,start,end) }
    }
}