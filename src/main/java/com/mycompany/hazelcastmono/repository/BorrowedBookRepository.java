package com.mycompany.hazelcastmono.repository;

import com.mycompany.hazelcastmono.domain.BorrowedBook;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the BorrowedBook entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long>, JpaSpecificationExecutor<BorrowedBook> {
}
