package icu.xiamu.repository;

import org.springframework.stereotype.Repository;

/**
 * @author roudoukou
 * @date 2025/6/13
 */
@Repository
public class BookRepository {

    public Integer label = 1;

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "BookRepository{" +
                "label=" + label +
                '}';
    }
}
