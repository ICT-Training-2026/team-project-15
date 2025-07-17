/*--★root で実行する-------------------------------------*/
DROP DATABASE IF EXISTS team15_db;
/* DB作成 */
CREATE DATABASE team15_db CHARACTER SET utf8 COLLATE utf8_general_ci;

/* DBユーザを作成 */
CREATE USER IF NOT EXISTS team15_user IDENTIFIED BY 'team15_user';

/* 権限付与 */
GRANT ALL PRIVILEGES ON team15_db.* TO team15_user;
