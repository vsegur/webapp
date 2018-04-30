package br.com.vsegur.webapp.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.vsegur.webapp.model.VehModel;

/**
 * @author Jorge Takeshi Sato
 */
@FeignClient(name = "vehModels", url = "${carinfo.api.baseUrl}/vehModels")
public interface VehModelService {

	@RequestMapping(method = RequestMethod.GET, path = "/search/findByBrandIdOrderByModelId", consumes = "application/json")
	Resources<VehModel> findByBrandIdOrderByModelId(@RequestParam(value = "brandId") String brandId);
	
	@RequestMapping(method = RequestMethod.GET, path = "/search/findByBrandIdOrderByModelName", consumes = "application/json")
	Resources<VehModel> findByBrandIdOrderByModelName(@RequestParam(value = "brandId") String brandId);
}