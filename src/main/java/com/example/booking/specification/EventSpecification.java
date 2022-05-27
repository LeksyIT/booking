package com.example.booking.specification;

import com.example.booking.entity.Event;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor
public class EventSpecification {

//    public static Specification<Event> titleContains(String word) {
//        return (root, query, criteriaBuilder) -> criteriaBuilder.
//                like(root.get("title"), "%" + word + "%");
//    }
//
//    public static Specification<Event> priceGreaterThanOrEqual(Integer value) {
//        return (root, query, criteriaBuilder) -> criteriaBuilder.
//                greaterThanOrEqualTo(root.get("price"), value);
//    }
//
//    public static Specification<Event> priceLesserThanOrEqual(Integer value) {
//        return (root, query, criteriaBuilder) -> criteriaBuilder.
//                lessThanOrEqualTo(root.get("price"), value);
//    }
}
