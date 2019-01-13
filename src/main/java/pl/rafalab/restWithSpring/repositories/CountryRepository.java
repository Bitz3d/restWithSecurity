package pl.rafalab.restWithSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.rafalab.restWithSpring.Model.Country;

public interface CountryRepository extends JpaRepository<Country, Long>  {

}
