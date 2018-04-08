package br.com.vsegur.webapp.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.vsegur.webapp.model.VehBrand;

/**
 * @author Jorge Takeshi Sato
 */
@FeignClient(name = "vehBrands", url = "${carinfo.api.baseUrl}/vehBrands")
public interface VehBrandService {

	@RequestMapping(method = RequestMethod.GET, path = "/search/findAllByOrderByBrandName", consumes = "application/json")
	Resources<VehBrand> findAllByOrderByBrandName();
}
