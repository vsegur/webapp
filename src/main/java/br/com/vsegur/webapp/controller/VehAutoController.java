package br.com.vsegur.webapp.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.time.StopWatch;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.vsegur.webapp.model.VehBrand;
import br.com.vsegur.webapp.service.VehAutoService;
import br.com.vsegur.webapp.service.VehBrandService;
import br.com.vsegur.webapp.service.VehModelService;

/**
 * @author Jorge Takeshi Sato
 */
@Controller
public class VehAutoController {

    private final Logger logger = LoggerFactory.getLogger(VehAutoController.class);

    @Autowired
    protected HttpServletRequest httpServletRequest;

    @Autowired
    protected VehBrandService vehBrandService;

    @Autowired
    protected VehModelService vehModelService;

    @Autowired
    protected VehAutoService vehAutoService;

    @RequestMapping(value = "/api/v1/brands", method = { RequestMethod.GET })
    public ResponseEntity<String> processRootRedirect(final Model model) throws Exception {

        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        final Resources<VehBrand> resourceOfVehBrands = vehBrandService.findAllByOrderByBrandName();
        final Collection<VehBrand> listOfVehBrands = resourceOfVehBrands.getContent();

		model.addAttribute("brands", listOfVehBrands);

        final JSONObject jsonParent = new JSONObject();
        final JSONArray jsonArray = new JSONArray();

        for (final VehBrand element : listOfVehBrands) {
            final JSONObject jsonObject = new JSONObject();
            jsonObject.put("brandId", element.getBrandId());
            jsonObject.put("brandName", element.getBrandName());
            jsonArray.put(jsonObject);
        }

        jsonParent.put("brands", jsonArray);

        stopWatch.stop();

        logger.info("/api/v1/brands :: " + stopWatch.getTime());

        return ResponseEntity.status(HttpStatus.OK).body(jsonParent.toString());
    }
}
