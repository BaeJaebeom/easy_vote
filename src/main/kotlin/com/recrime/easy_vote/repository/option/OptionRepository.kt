package com.recrime.easy_vote.repository.option

import com.recrime.easy_vote.domain.Option
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface OptionRepository: JpaRepository<Option, Long>, QuerydslPredicateExecutor<Option>, OptionRepositoryCustom {

}