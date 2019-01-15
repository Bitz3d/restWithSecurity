package pl.rafalab.restWithSpring.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.rafalab.restWithSpring.Model.Country;
import pl.rafalab.restWithSpring.repositories.CountryRepository;


@Service
@Transactional
public class CountryServicesImp implements CountryService {

	@Autowired
	private CountryRepository crepo;
	
	public List<Country> findAll() {
		return crepo.findAll();
	}

}
