package com.example.booking.specification;

import com.example.booking.entity.Event;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor
public class EventSpecification {

    public static Specification<Event> titleEqual(String userName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("userName"), userName );
    }
}
