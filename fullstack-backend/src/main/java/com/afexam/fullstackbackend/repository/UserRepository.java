package com.afexam.fullstackbackend.repository;

import com.afexam.fullstackbackend.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{

}
