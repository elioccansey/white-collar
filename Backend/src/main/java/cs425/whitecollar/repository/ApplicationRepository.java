package cs425.whitecollar.repository;

import cs425.whitecollar.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long> {
}
