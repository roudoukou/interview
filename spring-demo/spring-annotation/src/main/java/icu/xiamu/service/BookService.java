package icu.xiamu.service;

import icu.xiamu.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author roudoukou
 * @date 2025/6/13
 */
@Service
public class BookService {

    // @Qualifier("bookRepository")
    @Autowired
    private BookRepository bookRepository;

    @Override
    public String toString() {
        return "BookService{" +
                "bookRepository=" + bookRepository +
                '}';
    }
}

