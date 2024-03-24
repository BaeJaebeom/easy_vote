package com.recrime.easy_vote.domain

import java.time.LocalDateTime
import jakarta.persistence.*

@Entity
@Table(name = "vote")
class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_index", insertable = false, updatable = false)
    val voteIndex: Long? = null

    @Column(name = "code", nullable = false, length = 10)
    lateinit var code: String

    @Column(name = "title", nullable = false, length = 30)
    lateinit var title: String

    @Column(name = "description", columnDefinition = "TEXT")
    var description: String? = null

    @Column(name = "create_time", nullable = false)
    var createTime: LocalDateTime = LocalDateTime.now()

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vote_index")
    lateinit var voteCreationOption: VoteCreationOption

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "vote_index")
    lateinit var option: MutableList<Option>
}