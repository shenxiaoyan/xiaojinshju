/*
package apifengkong.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;

public interface PersonWebRepository extends JpaRepository<PersonWeb, Integer>,JpaSpecificationExecutor {
	
	Page<PersonWeb> findByCompany(Company company,Pageable page);
	Page<PersonWeb> findByUser(User user,Pageable page);
	PersonWeb findFirstByNameAndMobileAndIdCardAndCacheAndStatusOrderByIdDesc(String name,String mobile,String idCard,boolean cache,String status);
	Long countByIdCardAndCreateAtGreaterThan(String idCard, Date date);
	

}
*/
