-- 勤務区分テーブル作成
CREATE TABLE WORKCATEGORY (
    WORKTYPE   INT(10)      NOT NULL PRIMARY KEY, -- 勤務区分（主キー）
    WORKSTYLE  CHAR(50)     NOT NULL              -- 勤務形態
);


-- コメント付与（オプション、MySQL 8.0以降対応）
-- コメントは別途走らせる必要あり
ALTER TABLE WORKCATEGORY COMMENT = '勤務区分';
ALTER TABLE WORKCATEGORY MODIFY WORKTYPE INT(10) NOT NULL COMMENT '勤務区分：数値型・主キー';
ALTER TABLE WORKCATEGORY MODIFY WORKSTYLE CHAR(50) NOT NULL COMMENT '勤務形態：固定半角文字';