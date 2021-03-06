package fengkongweishi.entity.company;

import fengkongweishi.enums.CompanyStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer>,JpaSpecificationExecutor<Company> {
	public Company findByAppCode(String appCode);

	@Query("select c from Company as c where c.parent is null and c.status='ENABLED' or c.status= 'DISABLED'")
	Page<Company> findByStatus(Pageable page);

	Company findByCompanyNameAndParent(String companyName,Company company);

	List<Company> findByParent(Company company);
//	@Query(value="select COUNT(*) from customer ",nativeQuery=true)
//    public Integer getAllCustomerCount();

//	@Modifying
//	@Query(value="update Company c set c.status = 'ENABLED' where c.id = ?1")
//	@Transactional
//	public void companyModify(@Param("id") Integer id);
}
