package com.tamerofficial.domain.places.infra.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("place_score_attributes")
class ScoreAttributeEntity (
    @Id
    @Column("score_filter_attr_id")
    val scoreAttrId : Long? = null,

    @Column("is_trunk")
    val isTrunk : Boolean = false,
    @Column("level_score")
    val levelScore: Long = 0,
    @Column("facilities_score")
    val facilitiesScore : Long = 0,
    @Column("view_score")
    val viewScore : Long = 0,
    @Column("accessibility_score")
    val accessibilityScore: Long = 0,
    @Column("roughness_score")
    val roughnessScore : Long = 0,
    @Column("crowding_score")
    val crowdingScore : Long = 0
){

}