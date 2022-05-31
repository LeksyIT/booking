package com.example.booking.repository;

import com.example.booking.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event> {
    List<Event> getByResourceTitle(String title);

    @Query("SELECT u FROM Event u WHERE  u.resourceTitle = ?1 and (u.startTime between ?2 and ?3 or u.endTime between ?2 and ?3 )")
    List<Event> findByDateInstanceDuration(String title, Date start, Date end);
}
