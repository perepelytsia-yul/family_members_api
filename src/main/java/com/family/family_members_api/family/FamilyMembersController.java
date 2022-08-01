package com.family.family_members_api.family;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/family")
public class FamilyMembersController {

    public FamilyMembersService familyMembersService;

    @Autowired
    public FamilyMembersController(FamilyMembersService familyMembersService) {
        this.familyMembersService = familyMembersService;
    }

    @GetMapping
    public List<FamilyMembers> getFamilyMembers() {
        return familyMembersService.getFamilyMembers();
    }

    @GetMapping("/{id}")
    public Optional<FamilyMembers> getFamilyMembers(@PathVariable("id") Integer familyMembersId) {
        return familyMembersService.getFamilyMembersById(familyMembersId);
    }

    @GetMapping("/age")
    public Optional<Integer> getFamilyMembers(@RequestParam String name) {
        return Optional.of(familyMembersService.getFamilyMembersByName(name));
    }

    @GetMapping("/name")
    public Optional<Object> getFamilyMembersAge(@RequestParam Integer age) {
        return Optional.of(familyMembersService.getFamilyMembersByAge(age));
    }

    @PostMapping(value = "/url")
    public void registerV2NewFamilyMember(@RequestParam FamilyMembers familyMembers) {
        familyMembersService.addNewFamilyMember(familyMembers);
    }

    @PostMapping(value = "/json", consumes = {"application/json"})
    public void registerV1NewFamilyMember(@RequestBody FamilyMembers familyMembers) {
        familyMembersService.addNewFamilyMember(familyMembers);
    }

    @PutMapping(path = "{familyMemberId}")
    public void updateFamilyMembers(
            @PathVariable("familyMemberId") Integer familyMemberId,
            @RequestParam(required = false) Integer age) {
                familyMembersService.updateFamilyMembers(familyMemberId, age);
    }

    @DeleteMapping(path = "{familyMemberId}")
    public void cleanFamilyMembers(@PathVariable("familyMemberId") Integer familyMemberId) {
        familyMembersService.deleteFamilyMembers(familyMemberId);
    }
}
