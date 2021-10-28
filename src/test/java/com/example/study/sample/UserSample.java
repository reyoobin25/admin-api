package com.example.study.sample;

import com.example.study.StudyApplicationTests;
import com.example.study.component.LoginUserAuditorAware;
import com.example.study.config.JpaConfig;
import com.example.study.model.entity.AdminUser;
import com.example.study.model.entity.User;
import com.example.study.model.enumclass.UserStatus;
import com.example.study.repository.AdminUserRepository;
import com.example.study.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest                                                                    // JPA 테스트 관련 컴포넌트만 Import
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // 실제 db 사용
//@DisplayName("UserSample 생성")
//@Import({JpaConfig.class, LoginUserAuditorAware.class})
//@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class UserSample extends StudyApplicationTests {

    private Random random;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void sampleCreate(){

        random = new Random();

        for(int i = 1 ; i < 1001; i++){
            // 가입 상태 랜덤
            int div = (random.nextInt(10)+1) % 2;
            UserStatus status = (div == 0 ? UserStatus.REGISTERED : UserStatus.UNREGISTERED);

            User user = User.builder()
                    .account("TestUser"+i)
                    .password("password"+i)
                    .status(status)
                    .email("TestUser"+i+"@gmail.com")
                    .phoneNumber("010-1111-"+String.format("%04d", i))
                    .registeredAt(getRandomDate())
                    .unregisteredAt(status.equals(UserStatus.UNREGISTERED) ? getRandomDate() : null )
                    .build();

            System.out.println(user);
            userRepository.save(user);
        }


    }


    private LocalDateTime getRandomDate(){
        return LocalDateTime.of(2019,getRandomNumber(),getRandomNumber(),getRandomNumber(),getRandomNumber(),getRandomNumber());
    }

    private int getRandomNumber(){
        return random.nextInt(11)+1;
    }
}
