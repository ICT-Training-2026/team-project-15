-- 先にworkcategory_dbを作成する必要あり
-- 勤怠情報テーブル作成
CREATE TABLE WORKINFO (
    ID         CHAR(9)      NOT NULL,             -- 社員番号
    DATE       DATE         NOT NULL,             -- 日付
    WORKSTYLE  INT(10)      NOT NULL,             -- 勤務区分
    STARTTIME  TIME         NULL,                 -- 始業時刻
    ENDTIME    TIME         NULL,                 -- 終業時刻
    BREAKTIME  FLOAT(4,2)   NULL,                 -- 休憩時間（最大99.99時間まで対応）
    WORKTIME   FLOAT(4,2)   NULL,                 -- 実労働時間
    OVERTIME   FLOAT(4,2)   NULL,                 -- 累積超過時間
    PRIMARY KEY (ID, DATE)
);

-- コメント付与（MySQL 8.0以降対応）
-- コメントは別途走らせる必要あり
ALTER TABLE WORKINFO COMMENT = '勤怠情報';
ALTER TABLE WORKINFO MODIFY ID CHAR(9) NOT NULL COMMENT '社員番号：固定半角文字';
ALTER TABLE WORKINFO MODIFY DATE DATE NOT NULL COMMENT '日付';
ALTER TABLE WORKINFO MODIFY WORKSTYLE INT(10) NOT NULL COMMENT '勤務区分：数値';
ALTER TABLE WORKINFO MODIFY STARTTIME TIME NULL COMMENT '始業時刻';
ALTER TABLE WORKINFO MODIFY ENDTIME TIME NULL COMMENT '終業時刻';
ALTER TABLE WORKINFO MODIFY BREAKTIME FLOAT(4,2) NULL COMMENT '休憩時間：小数点可';
ALTER TABLE WORKINFO MODIFY WORKTIME FLOAT(4,2) NULL COMMENT '実労働時間：小数点可';
ALTER TABLE WORKINFO MODIFY OVERTIME FLOAT(4,2) NULL COMMENT '累積超過時間：小数点可';