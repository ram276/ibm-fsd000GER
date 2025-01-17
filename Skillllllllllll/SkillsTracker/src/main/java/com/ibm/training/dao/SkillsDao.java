package com.ibm.training.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.training.model.AssociateInfo;
import com.ibm.training.model.AssociateSkills;
import com.ibm.training.model.SkillsInfo;
import com.ibm.training.repo.AssociateSkillsInt;
import com.ibm.training.repo.AssociateSkillsRepository;
import com.ibm.training.repo.SkillsInfoRepository;
import com.ibm.training.repo.SkillsRepository;

@Repository
public class SkillsDao 
{
	@Autowired
	SkillsRepository skillsRepo;
	
	@Autowired
	AssociateSkillsRepository assoRepo;
	
	@Autowired
	SkillsInfoRepository skillInfoRepo;
	
	@Autowired
	AssociateSkillsInt assoSkillsRepo;
	
	public Optional<AssociateInfo> getAssociateInfo(String id)
	{
		System.out.println("In skills dao");
		return skillsRepo.findById(id);
	}

	public Iterable<AssociateInfo> getAllAssociates() 
	{
		System.out.println("dao hit for all");
		return skillsRepo.findAll();
	}

	public List<AssociateSkills> getAllAssociatesSkills(String id) {
		return assoRepo.findByAidAssociateId(id);
	}

	public Iterable<SkillsInfo> getAllSkills() {
		return skillInfoRepo.findAll();
	}

	public Iterable<AssociateSkills> getAssociatesSkills() {
		
		return assoRepo.findAll();
	}

	public void updateAssociate(AssociateInfo associate) {
		skillsRepo.save(associate);
		
	}

	public void updateAssociateSkills(AssociateSkills skills) 
	{
		assoRepo.save(skills);
	}

	public void deleteAssociate(String id) {
		skillsRepo.deleteById(id);
		
	}

	public void deleteAssociateSkill(Integer id) {
		assoSkillsRepo.deleteById(id);
		
	}

	@Transactional
	public Iterable<AssociateSkills> deleteAssociatesSkillsByAid(String id) {
		return assoRepo.deleteByAidAssociateId(id);
	}

	public void saveAssociate(AssociateInfo associate) {
		skillsRepo.save(associate);
		
	}

	public void saveSkills(List<SkillsInfo> skillInfo) {
		skillInfoRepo.saveAll(skillInfo);
	}

		
	
}
