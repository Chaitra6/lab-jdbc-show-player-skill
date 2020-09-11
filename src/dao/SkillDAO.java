package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utility.ConnectionManager;
import model.Skill;

public class SkillDAO {

	public List<Skill> listAllSkills() throws SQLException, Exception {
		String query = "SELECT * FROM SKILL ORDER BY SKILL_NAME ASC";
		ConnectionManager con = new ConnectionManager();

		List<Skill> list = new ArrayList<Skill>();
		Skill skill = null;
		ResultSet rs = null;

		try {
			Statement st = con.getConnection().createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				skill = new Skill();

				/*
				 * Retrieve one skill details and store it in skill object
				 */

				skill.setSkilld(rs.getLong("SKILL_ID"));
				skill.setSkillName(rs.getString("SKILL_NAME"));

				// add each SKILL to the list
				list.add(skill);
			}

		} finally {
			con.getConnection().close();
		}

		return list;

	}

}
