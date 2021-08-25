package com.tamerofficial.infra.entity

import com.tamerofficial.place.query.dto.ScoreAttribute
import javax.persistence.*

@Entity
@Table(name="place_score_attributes")
class ScoreAttributeEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val scoreAttrId : Long? = null,

    @Column(name="place_id")
    val placeId: Long? = null,

    @Column(name="is_trunk")
    val isTrunk : Boolean = false,

    @Column(name="level_score")
    val levelScore: Long = 0,

    @Column(name="facilities_score")
    val facilitiesScore : Long = 0,

    @Column(name="view_score")
    val viewScore : Long = 0,

    @Column(name="accessibility_score")
    val accessibilityScore: Long = 0,

    @Column(name="roughness_score")
    val roughnessScore : Long = 0,

    @Column(name="crowding_score")
    val crowdingScore : Long = 0
){
    fun toDto() = ScoreAttribute(
        this.isTrunk,
        this.levelScore,
        this.facilitiesScore,
        this.viewScore,
        this.accessibilityScore,
        this.roughnessScore,
        this.crowdingScore
    )
}