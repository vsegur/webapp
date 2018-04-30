package br.com.vsegur.webapp.controller;

import java.util.Collection;

import org.apache.commons.lang.StringUtils;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.vsegur.webapp.model.VehModel;
import br.com.vsegur.webapp.service.VehModelService;

/**
 * @author Jorge Takeshi Sato
 */
@Controller
public class VehModelController {

    private final Logger logger = LoggerFactory.getLogger(VehModelController.class);

    @Autowired
    protected VehModelService vehModelService;

    @RequestMapping(value = "/api/v1/models", method = { RequestMethod.POST })
    public ResponseEntity<String> processRootRedirect(final Model model, @RequestBody final String input) throws Exception {

        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        final JSONObject jsonInputObject = new JSONObject(StringUtils.stripToEmpty(input));
        final String brandId = jsonInputObject.getString("brandId");
        
		final Resources<VehModel> resourceOfVehModels = vehModelService.findByBrandIdOrderByModelName(brandId);
        final Collection<VehModel> listOfVehModels = resourceOfVehModels.getContent();

		model.addAttribute("models", listOfVehModels);

        final JSONObject jsonParent = new JSONObject();
        final JSONArray jsonArray = new JSONArray();

        for (final VehModel element : listOfVehModels) {
            final JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", element.getModelId());
            jsonObject.put("name", element.getModelName());
            jsonArray.put(jsonObject);
        }

        jsonParent.put("models", jsonArray);

        stopWatch.stop();

        logger.info("/api/v1/models :: " + stopWatch.getTime());

        return ResponseEntity.status(HttpStatus.OK).body(jsonParent.toString());
    }
}
