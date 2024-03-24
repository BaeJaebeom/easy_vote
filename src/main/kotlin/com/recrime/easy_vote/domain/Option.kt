package com.recrime.easy_vote.domain

import java.time.LocalDateTime
import jakarta.persistence.*

@Entity
@Table(name = "option")
class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_index", insertable = false, updatable = false)
    val optionIndex: Long? = null

    @Column(name = "vote_index", nullable = false)
    var voteIndex: Long = 0

    @Column(name = "name", nullable = false, length = 30)
    lateinit var name: String

    @Column(name = "create_time", nullable = false)
    var createTime: LocalDateTime = LocalDateTime.now()

    @OneToMany
    @JoinColumn(name = "answer_index", nullable = false)
    lateinit var answer: MutableList<Answer>
}