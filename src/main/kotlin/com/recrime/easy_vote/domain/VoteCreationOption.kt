package com.recrime.easy_vote.domain

import java.time.LocalDateTime
import jakarta.persistence.*

@Entity
@Table(name = "vote_creation_option")
class VoteCreationOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_creation_option_index", insertable = false, updatable = false)
    val voteCreationOptionIndex: Long? = null

    @Column(name = "vote_index", nullable = false)
    var voteIndex: Long = 0

    @Column(name = "use_period", columnDefinition = "ENUM('Y', 'N')")
    var usePeriod: String = "N"

    @Column(name = "start_time")
    var startTime: LocalDateTime? = null

    @Column(name = "end_time")
    var endTime: LocalDateTime? = null

    @Column(name = "use_multiple_selection", columnDefinition = "ENUM('Y', 'N')")
    var useMultipleSelection: String = "N"

    @Column(name = "use_anonymous", columnDefinition = "ENUM('Y', 'N')")
    var useAnonymous: String = "N"

    @Column(name = "use_password", columnDefinition = "ENUM('Y', 'N')")
    var usePassword: String = "N"

    @Column(name = "password", length = 30)
    var password: String? = null
}