package spring.hibernate.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import spring.hibernate.entity.Company;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Integer> {

    List<Company> findAll();

    @Query("SELECT company FROM Company company WHERE company.id=:id")
    Company findById1(@Param("id") Integer id);
}
