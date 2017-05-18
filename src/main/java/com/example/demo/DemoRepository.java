package com.example.demo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jpairaiturkar on 5/17/17.
 */
@Repository
public interface DemoRepository extends PagingAndSortingRepository<DemoEntity, String> {
}
