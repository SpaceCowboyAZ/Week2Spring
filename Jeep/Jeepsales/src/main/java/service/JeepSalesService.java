package service;



import java.util.List;

import entity.Jeep;

public interface JeepSalesService {

	List<Jeep> fetchJeeps(String model, String trim);
}