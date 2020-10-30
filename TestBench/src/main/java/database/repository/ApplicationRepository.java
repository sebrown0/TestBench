/**
 * 
 */
package database.repository;

import org.springframework.data.repository.CrudRepository;

import database.enity.application.Application;

/**
 * @author SteveBrown
 *
 */
public interface ApplicationRepository extends CrudRepository<Application, Integer>{
	Application findByName(String name);
}
