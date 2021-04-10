package com.tamerofficial.app.places

import com.tamerofficial.app.places.dto.PlaceSearchCriteria
import com.tamerofficial.domain.common.Location
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PlaceSearchCriteriaTest : StringSpec({

    "Area 조건이 있으면 AreaBase 검색 조건이다."(){
        val target = PlaceSearchCriteria(
            areaCode = "SEOUL",
            subAreas = emptyList()
        )
        target.isAreaBase() shouldBe true
    }

    "Area 조건이 있고, Location 검색 조건도 있으며 Area 검색 조건이다"() {
        val target = PlaceSearchCriteria(
            areaCode = "SEOUL",
            subAreas = emptyList(),
            distance = 100,
            currentLocation = Location(1,2)
        )
        target.isAreaBase() shouldBe true
    }

    "Area 조건이 없고, Location 검색 조건만 있으면 Location 검색 조건이다."() {
        val target = PlaceSearchCriteria(
            distance = 100,
            currentLocation = Location(1,2)
        )
        target.isLocationBase() shouldBe true
    }
})