package com.e.model.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.e.model.entity.UserEntity;
import com.e.model.mapper.UserMapper;
import com.e.model.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public void signup(String name, String email, String password, String tel) {
		UserEntity entity = UserEntity.builder().name(name).email(email).password(passwordEncoder.encode(password))
				.phone(tel).build();

		System.out.println(entity);
		userRepo.save(entity);

		// CSV 파일에 저장
		saveToCsv(name, email, password, tel);
	}

	private void saveToCsv(String name, String email, String password, String tel) {
		try {
			String desktopPath = System.getProperty("user.home") + "\\Desktop\\movie_users.csv";
			File csvFile = new File(desktopPath);

			if (!csvFile.exists()) {
				try (FileOutputStream fos = new FileOutputStream(csvFile);
						OutputStreamWriter writer = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {

					fos.write(new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF });
					writer.append("등록일시,이름,이메일,비밀번호,전화번호\n");
				}
			}

			String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

			try (FileOutputStream fos = new FileOutputStream(csvFile, true);
					OutputStreamWriter writer = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {

				writer.append(String.format("%s,\"%s\",\"%s\",\"%s\",\"%s\"\n", currentTime, name.replace("\"", "\"\""),
						email.replace("\"", "\"\""), password.replace("\"", "\"\""), tel.replace("\"", "\"\"")));
			}

			System.out.println("CSV 파일에 저장 완료: " + desktopPath);

		} catch (IOException e) {
			System.err.println("CSV 파일 저장 중 오류 발생: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
