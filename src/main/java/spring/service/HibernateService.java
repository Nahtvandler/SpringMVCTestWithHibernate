package spring.service;

import spring.hibernate.Dao.CompanyDao;
import spring.hibernate.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HibernateService {

    @Autowired
    CompanyDao companyDao;

    public HibernateService(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public List<Company> getAllCompany() {
        return companyDao.getAll();
    }

    public Company getById(Integer id) {
        return companyDao.getById(id);
    }
}
