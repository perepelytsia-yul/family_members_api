package com.family.family_members_api.family;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class FamilyMembersService {

    private final FamilyMembersRepository familyMembersRepository;

    @Autowired
    public FamilyMembersService(FamilyMembersRepository familyMembersRepository) {
        this.familyMembersRepository = familyMembersRepository;
    }

    public List<FamilyMembers> getFamilyMembers() {
        return familyMembersRepository.findAll();
    }

    public void addNewFamilyMember(FamilyMembers familyMembers) {
            familyMembersRepository.save(familyMembers);
    }

    public void deleteFamilyMembers(Integer familyMemberId) {
        boolean exists = familyMembersRepository.existsById(familyMemberId);
        if (!exists) {
            throw new IllegalStateException(
                    "Smth went wrong. Family member with id " + familyMemberId + "doesn't exist");
        } else {
            familyMembersRepository.deleteById(familyMemberId);
        }
    }

    @Transactional
    public void updateFamilyMembers(Integer familyMemberId, Integer age) {
        boolean exists = familyMembersRepository.existsById(familyMemberId);
        FamilyMembers familyMembers = familyMembersRepository.findById(familyMemberId)
                .orElseThrow(() -> new IllegalStateException(
                        "familyMember with id " + familyMemberId + "doesn't exist"));

        if (age != null && !Objects.equals(familyMembers.getAge(), age)) {
            familyMembers.setAge(age);
        };
    }

    public Optional <FamilyMembers> getFamilyMembersById(Integer familyMembersId) {
        if (familyMembersRepository.existsById(familyMembersId)) {
            return familyMembersRepository.findById(familyMembersId);
        } else {
            throw new IllegalStateException("family member with id " + familyMembersId + " doesn't exist");
        }
    }

    public int getFamilyMembersByName(String name) {
        return familyMembersRepository.findByName(name).getAge();
    }

    public Object getFamilyMembersByAge(Integer age) {
        return familyMembersRepository.findByAge(age).getName();
    }
}
