package cm.ben.companyservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import cm.ben.companyservice.entities.Company;

@RepositoryRestResource
public interface CompanyRepository extends JpaRepository<Company, Long> {

}