package com.example.demo.repository;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

import lombok.RequiredArgsConstructor;

@Repository // Springのリポジトリコンポーネントとして登録するアノテーション
@RequiredArgsConstructor // finalフィールドを引数に持つコンストラクタを自動生成するLombokアノテーション
public class LoginRepositoryImpl implements LoginRepository {
	
	private final JdbcTemplate jdbcTemplate; // JDBC操作を簡素化するSpringのJdbcTemplateをDIで注入

	@Override
	public User equals(String id, String hashedPassword) {
		String sql =
			" SELECT ui.ID, ui.NAME " +
			" FROM USERINFO ui " +
			" WHERE ui.ID = ? AND ui.PASS = ? ";

		try {
			return jdbcTemplate.queryForObject(
				sql,
				(rs, rowNum) -> new User(
					rs.getString("ID"),
					rs.getString("NAME")
				),
				id,
				hashedPassword
			);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
	}

}