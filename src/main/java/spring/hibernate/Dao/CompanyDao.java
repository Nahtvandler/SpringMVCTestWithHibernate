package spring.hibernate.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.hibernate.entity.Company;
import org.springframework.transaction.annotation.Transactional;
import spring.hibernate.repository.CompanyRepository;

import java.util.List;

@Component
@Transactional
public class CompanyDao {

    //@PersistenceContext
    //EntityManager entityManager;
    @Autowired
    CompanyRepository companyRepository;

//    public CompanyDao(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }


    public CompanyDao(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAll() {
//        return entityManager.createQuery("from Company").getResultList();
        return companyRepository.findAll();
    }

    public Company getById(Integer id) {
        return companyRepository.findById1(id);
    }


}
