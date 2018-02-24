package com.interglobe.test.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.interglobe.test.entity.Note;

/**
 * 
 * @author Sanjib Pramanick
 *
 */
@RepositoryRestResource
public interface NoteRepository extends JpaRepository<Note, BigInteger> {

}
