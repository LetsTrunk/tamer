package com.tamerofficial.place.query

import com.tamerofficial.infra.dao.FilterAttributesRepository
import com.tamerofficial.place.query.dto.FilterAttributeDto
import org.springframework.stereotype.Service

interface FilterQueryService {
    fun listFilterAttributes(): List<FilterAttributeDto>
}

@Service
class FilterQueryServiceImpl(
    private val filterAttributesRepository: FilterAttributesRepository
) : FilterQueryService {
    override fun listFilterAttributes(): List<FilterAttributeDto> {
        return filterAttributesRepository.findAll().map { it.toDto() }
    }
}