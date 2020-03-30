package id.project.skripsi.manzone.dao;

import com.java.common.lib.domain.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserData,String> {

    UserData findUserDataByUserEmail(String userEmail);

}
