package com.example.booking.specification;

import com.example.booking.entity.Event;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.sql.Date;
import java.util.function.Predicate;

@NoArgsConstructor
public class EventSpecification {

    public static Specification<Event> userNameEqual(String userName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("userName"), userName);
    }

    public static Specification<Event> timeEqual(Date time) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("startTime"), time);
    }

    public static Specification<Event> findByTitle(String title) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("resourceTitle"), title);
    }

}
