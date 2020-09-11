package controller;

import java.sql.SQLException;
import java.util.List;

import dao.SkillDAO;
import model.Skill;

public class Main {

	public static void main(String[] args) throws Exception {
		
		SkillDAO skillDAO = new SkillDAO();
		List<Skill> skills;
		
		try {
			skills = skillDAO.listAllSkills();
			for(Skill skill : skills) {
				System.out.println(skill.getSkilld()+"."+" "+skill.getSkillName());
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}	
		

	}
}