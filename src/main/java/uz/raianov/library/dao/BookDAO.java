package uz.raianov.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.raianov.library.models.Book;

import java.util.List;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO book(title, year, author) VALUES(?,?,?)", book.getTitle(), book.getYear(), book.getAuthor());
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE book Set title=?, year=?, author=? WHERE id=?", updatedBook.getTitle(), updatedBook.getYear(), updatedBook.getAuthor(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
    }
}
