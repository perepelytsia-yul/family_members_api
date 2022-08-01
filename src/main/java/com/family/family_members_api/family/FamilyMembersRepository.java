package com.family.family_members_api.family;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FamilyMembersRepository
        extends JpaRepository<FamilyMembers, Integer> {

    @Query("SELECT s FROM FamilyMembers s WHERE s.id = ?1")
    Optional<FamilyMembers> findFamilyMembersById(Integer id);

    @Query("SELECT s FROM FamilyMembers s WHERE s.name = ?1")
    FamilyMembers findByName(String familyMembersName);

    @Query("SELECT s FROM FamilyMembers s WHERE s.age = ?1")
    FamilyMembers findByAge(Integer age);
}
