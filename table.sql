CREATE TABLE `vote`
(
    `vote_index`  BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '투표 번호',
    `code`        VARCHAR(10)         NOT NULL COMMENT '코드',
    `title`       VARCHAR(30)         NOT NULL COMMENT '제목',
    `description` TEXT COMMENT '설명',
    `create_time` DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성 시간',
    PRIMARY KEY(`vote_index`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_520_ci COMMENT ='투표';
CREATE INDEX vote_code_index ON vote (`code`);

CREATE TABLE `vote_select_option`
(
    `vote_select_option_index` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '투표 선택 옵션 번호',
    `vote_index`               BIGINT(20) UNSIGNED NOT NULL COMMENT '투표 번호',
    `use_period`               ENUM ('Y','N') DEFAULT 'N' COMMENT '기간 사용',
    `start_time`               DATETIME COMMENT '시작 시간',
    `end_time`                 DATETIME COMMENT '종료 시간',
    `use_multiple_selection`   ENUM ('Y','N') DEFAULT 'N' COMMENT '복수 응답 허용',
    `use_anonymous`            ENUM ('Y','N') DEFAULT 'N' COMMENT '익명 응답 사용',
    `use_password`             ENUM ('Y','N') DEFAULT 'N' COMMENT '비밀번호 사용',
    `password`                 VARCHAR(30) COMMENT '비밀번호',
    PRIMARY KEY(`vote_select_option_index`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_520_ci COMMENT ='투표 선택 옵션';

CREATE TABLE `option`
(
    `option_index` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '선택지 번호',
    `vote_index`   BIGINT(20) UNSIGNED NOT NULL COMMENT '투표 번호',
    `name`         VARCHAR(30)         NOT NULL COMMENT '선택지 이름',
    `create_time`  DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성 시간'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_520_ci COMMENT ='투표 선택지';

CREATE TABLE `answer`
(
    `answer_index` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '답변 번호',
    `vote_index`   BIGINT(20) UNSIGNED NOT NULL COMMENT '투표 번호',
    `option_index` BIGINT(20) UNSIGNED NOT NULL COMMENT '선택지 번호',
    `answerer`     VARCHAR(30)         NOT NULL COMMENT '선택자 이름',
    `vote_time`    DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '투표 시간',
    PRIMARY KEY(`answer_index`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_520_ci COMMENT ='투표 선택지';