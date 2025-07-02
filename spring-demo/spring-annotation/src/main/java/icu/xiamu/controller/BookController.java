package icu.xiamu.controller;

import icu.xiamu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author roudoukou
 * @date 2025/6/13
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

}
