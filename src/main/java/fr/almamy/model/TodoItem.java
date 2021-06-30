package fr.almamy.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(of = "id")
public class TodoItem {

    // == Fields ==
    private int id;
    private String title;
    private String details;
    private LocalDateTime deadline;

    // == Constructor ==
    public TodoItem(String title, String details, LocalDateTime deadline) {
        this.title = title;
        this.details = details;
        this.deadline = deadline;
    }
}
