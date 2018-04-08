package br.com.vsegur.webapp.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Jorge Takeshi Sato
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehAuto implements Serializable {

    private static final long serialVersionUID = -6105762650716988783L;

    private Integer brandId;
    private String brandName;

    private Integer modelId;
    private String modelName;

    private Integer autoId;
    private Integer autoYearNumber;

    private String autoExternalCode;
    private String autoFuelid;
    private String autoFuelname;
    private String autoType;

    private Float autoValue;
}