package com.tamerofficial.place.query

import com.tamerofficial.infra.dao.FilterAttributesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.reactive.asFlow
import org.springframework.stereotype.Service

interface FilterQueryService {
    fun listFilterAttributes(): Flow<FilterAttributeDto>
}

@Service
class FilterQueryServiceImpl(
    private val filterAttributesRepository: FilterAttributesRepository
) : FilterQueryService {
    override fun listFilterAttributes(): Flow<FilterAttributeDto> {
        return filterAttributesRepository.findAll().asFlow().map { it.toDto() }
    }
}