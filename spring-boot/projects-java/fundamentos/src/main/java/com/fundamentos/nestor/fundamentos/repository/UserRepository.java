package com.fundamentos.nestor.fundamentos.repository;

import com.fundamentos.nestor.fundamentos.dto.UserDto;
import com.fundamentos.nestor.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    //Examples JPQL
    @Query("select u from User u where u.email=?1")
    Optional<User> findAllByUserEmail(String email);

    @Query("select u from User u where u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);

    // Examples Query method
    List<User> findByName(String name);

    Optional<User> findByEmailAndName(String email, String name);

    List<User> findByNameLike(String name);

    List<User> findByNameOrEmail(String name, String email);

    List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);

    //List<User> findByNameLikeOrderByIdDesc(String name);

    List<User> findByNameContainingOrderByIdDesc(String name);

    @Query("select new com.fundamentos.nestor.fundamentos.dto.UserDto(u.id, u.name, u.birthDate)" +
            " from User u " +
            " where u.birthDate= :parametroFecha" +
            " and u.email=:parametroEmail")
    Optional<UserDto> getAllByBirthDateAndEmail(@Param("parametroFecha") LocalDate date,
                                                @Param("parametroEmail") String email);

//    //Using Named Parameters
//    @Query("select u from User u where u.name = :name or u.email = :email")
//    Optional<User> findByNameOrEmail(@Param("name") String name,
//                                     @Param("email") String email);


    List<User> findAll();
}
