-- 创建模式(相当于MySQL的database)
CREATE SCHEMA "AST-SQL";

-- 切换到AST-SQL模式
SET SCHEMA "AST-SQL";

-- 创建USER表(保持大写)
CREATE TABLE "USER"
(
    "ID"   BIGINT IDENTITY(1,1) PRIMARY KEY,
    "NAME" VARCHAR2(255) NOT NULL,
    "AGE"  INTEGER
);

