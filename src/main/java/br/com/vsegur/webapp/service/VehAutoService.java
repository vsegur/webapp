package br.com.vsegur.webapp.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.vsegur.webapp.model.VehAuto;

/**
 * @author Jorge Takeshi Sato
 */
@FeignClient(name = "vehAutos", url = "${carinfo.api.baseUrl}/vehAutos")
public interface VehAutoService {

	@RequestMapping(method = RequestMethod.GET, path = "/search/findByModelIdOrderByAutoId", consumes = "application/json")
	Resources<VehAuto> findByModelIdOrderByAutoId(@RequestParam(value = "modelId") Integer modelId);
}