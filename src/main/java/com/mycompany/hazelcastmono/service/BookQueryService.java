package com.mycompany.hazelcastmono.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import com.mycompany.hazelcastmono.domain.Book;
import com.mycompany.hazelcastmono.domain.*; // for static metamodels
import com.mycompany.hazelcastmono.repository.BookRepository;
import com.mycompany.hazelcastmono.service.dto.BookCriteria;
import com.mycompany.hazelcastmono.service.dto.BookDTO;
import com.mycompany.hazelcastmono.service.mapper.BookMapper;

/**
 * Service for executing complex queries for {@link Book} entities in the database.
 * The main input is a {@link BookCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link BookDTO} or a {@link Page} of {@link BookDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class BookQueryService extends QueryService<Book> {

    private final Logger log = LoggerFactory.getLogger(BookQueryService.class);

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    public BookQueryService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    /**
     * Return a {@link List} of {@link BookDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<BookDTO> findByCriteria(BookCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Book> specification = createSpecification(criteria);
        return bookMapper.toDto(bookRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link BookDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<BookDTO> findByCriteria(BookCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Book> specification = createSpecification(criteria);
        return bookRepository.findAll(specification, page)
            .map(bookMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(BookCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Book> specification = createSpecification(criteria);
        return bookRepository.count(specification);
    }

    /**
     * Function to convert {@link BookCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Book> createSpecification(BookCriteria criteria) {
        Specification<Book> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Book_.id));
            }
            if (criteria.getIsbn() != null) {
                specification = specification.and(buildStringSpecification(criteria.getIsbn(), Book_.isbn));
            }
            if (criteria.getName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getName(), Book_.name));
            }
            if (criteria.getPublishYear() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPublishYear(), Book_.publishYear));
            }
            if (criteria.getCopies() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCopies(), Book_.copies));
            }
            if (criteria.getPublisherId() != null) {
                specification = specification.and(buildSpecification(criteria.getPublisherId(),
                    root -> root.join(Book_.publisher, JoinType.LEFT).get(Publisher_.id)));
            }
            if (criteria.getAuthorId() != null) {
                specification = specification.and(buildSpecification(criteria.getAuthorId(),
                    root -> root.join(Book_.authors, JoinType.LEFT).get(Author_.id)));
            }
        }
        return specification;
    }
}
