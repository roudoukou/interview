package icu.xiamu.interceptor; // 或者 icu.xiamu.interceptor.visitor;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.SimpleNode;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.StatementVisitorAdapter;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.SelectVisitorAdapter;
import net.sf.jsqlparser.statement.select.FromItemVisitorAdapter;
import net.sf.jsqlparser.statement.delete.Delete; // 确保导入 Delete 类
import net.sf.jsqlparser.statement.update.Update;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.merge.Merge;

/**
 * 一个 JSQLParser 访问者
 * 已实现, 将表名添加双引号, 用于遍历 SQL AST 并为所有 Table 节点添加双引号。
 */
public class TableQuotingVisitor extends StatementVisitorAdapter {

    // 辅助方法：为表名添加双引号
    private void applyTableQuoting(Table table) {
        // 检查表名是否已经有双引号（防止重复添加）
        if (table != null && table.getName() != null &&
                (!table.getName().startsWith("\"") || !table.getName().endsWith("\""))) {
            table.setName("\"" + table.getName() + "\"");
        }
        // 如果表有别名，且达梦也需要对别名进行处理（例如，如果别名是关键字），可以在这里添加逻辑
        // 例如：
        // if (table.getAlias() != null && !table.getAlias().getName().startsWith("\"")) {
        //     table.getAlias().setName("\"" + table.getAlias().getName() + "\"");
        // }
    }

    // --- 重写各种 Statement 类型的 visit 方法，以确保遍历到其中的 Table 节点 ---

    @Override
    public void visit(Select select) {
        if (select.getSelectBody() != null) {
            select.getSelectBody().accept(new SelectVisitorAdapter() {
                @Override
                public void visit(PlainSelect plainSelect) {
                    // 处理 FROM 子句中的表
                    if (plainSelect.getFromItem() != null) {
                        plainSelect.getFromItem().accept(new FromItemVisitorAdapter() {
                            @Override
                            public void visit(Table table) {
                                applyTableQuoting(table);
                            }
                        });
                    }
                    // 处理 JOIN 子句中的表
                    if (plainSelect.getJoins() != null) {
                        plainSelect.getJoins().forEach(join -> {
                            if (join.getRightItem() != null) {
                                join.getRightItem().accept(new FromItemVisitorAdapter() {
                                    @Override
                                    public void visit(Table table) {
                                        applyTableQuoting(table);
                                    }
                                });
                            }
                        });
                    }
                    // TODO: 如果表可能出现在 WHERE、HAVING 或其他表达式中（例如子查询），
                    // 需要进一步实现 ExpressionVisitorAdapter 来遍历这些表达式
                    // 例如：plainSelect.getWhere().accept(new ExpressionVisitorAdapter() { ... });
                }
            });
        }

        // 处理 WITH 子句中的 CTE (Common Table Expression)
        if (select.getWithItemsList() != null) {
            for (net.sf.jsqlparser.statement.select.WithItem withItem : select.getWithItemsList()) {
                if (withItem.getSelectBody() != null) {
                    withItem.getSelectBody().accept(new SelectVisitorAdapter() {
                        @Override
                        public void visit(PlainSelect plainSelect) {
                            if (plainSelect.getFromItem() != null) {
                                plainSelect.getFromItem().accept(new FromItemVisitorAdapter() {
                                    @Override
                                    public void visit(Table table) {
                                        applyTableQuoting(table);
                                    }
                                });
                            }
                        }
                    });
                }
            }
        }
    }

    @Override
    public void visit(Delete delete) {
        // 要删除的主表
        if (delete.getTable() != null) {
            applyTableQuoting(delete.getTable());
        }

        // 处理多表删除语句中的 JOIN 部分
        // 例如：DELETE t1 FROM t1 JOIN t2 ON t1.id = t2.id WHERE ...
        if (delete.getJoins() != null) {
            delete.getJoins().forEach(join -> {
                if (join.getRightItem() != null) {
                    join.getRightItem().accept(new FromItemVisitorAdapter() {
                        @Override
                        public void visit(Table table) {
                            applyTableQuoting(table);
                        }
                    });
                }
            });
        }
        // TODO: 如果 DELETE 语句的 WHERE 子句中包含子查询，且子查询中包含表，
        // 则需要进一步通过 ExpressionVisitorAdapter 来处理 delete.getWhere()。
        // 例如：delete.getWhere().accept(new ExpressionVisitorAdapter() { ... });
    }

    @Override
    public void visit(Update update) {
        // 主表
        if (update.getTable() != null) {
            applyTableQuoting(update.getTable());
        }
        // 处理 UPDATE ... FROM ... 语法中的表
        if (update.getFromItem() != null) {
            update.getFromItem().accept(new FromItemVisitorAdapter() {
                @Override
                public void visit(Table table) {
                    applyTableQuoting(table);
                }
            });
        }
        // 处理 UPDATE ... JOIN ... 语法中的表
        if (update.getJoins() != null) {
            update.getJoins().forEach(join -> {
                if (join.getRightItem() != null) {
                    join.getRightItem().accept(new FromItemVisitorAdapter() {
                        @Override
                        public void visit(Table table) {
                            applyTableQuoting(table);
                        }
                    });
                }
            });
        }
    }

    @Override
    public void visit(Insert insert) {
        if (insert.getTable() != null) {
            applyTableQuoting(insert.getTable());
        }
        // 处理 INSERT INTO ... SELECT FROM ... 语句中的 SELECT 部分
        if (insert.getSelect() != null) {
            insert.getSelect().accept(new SelectVisitorAdapter() {
                @Override
                public void visit(PlainSelect plainSelect) {
                    if (plainSelect.getFromItem() != null) {
                        plainSelect.getFromItem().accept(new FromItemVisitorAdapter() {
                            @Override
                            public void visit(Table table) {
                                applyTableQuoting(table);
                            }
                        });
                    }
                    if (plainSelect.getJoins() != null) {
                        plainSelect.getJoins().forEach(join -> {
                            if (join.getRightItem() != null) {
                                join.getRightItem().accept(new FromItemVisitorAdapter() {
                                    @Override
                                    public void visit(Table table) {
                                        applyTableQuoting(table);
                                    }
                                });
                            }
                        });
                    }
                }
            });
        }
    }

    @Override
    public void visit(Merge merge) {
        if (merge.getTable() != null) {
            applyTableQuoting(merge.getTable());
        }
        if (merge.getUsingTable() != null) {
            // MERGE INTO target USING source
            // source 也可以是一个表或者一个子查询
            merge.getUsingTable().accept(new FromItemVisitorAdapter() {
                @Override
                public void visit(Table table) {
                    applyTableQuoting(table);
                }
            });
        }
    }

    // TODO: 如果需要处理其他类型的 Statement 或表达式中的表，可以在这里添加相应的 visit 方法
    // 例如：
    // @Override
    // public void visit(SubSelect subSelect) { ... }
    // @Override
    // public void visit(Expression expr) {
    //     SimpleNode astNode = expr.getASTNode();
    // }
}