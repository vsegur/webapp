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
public class VehModel implements Serializable {

    private static final long serialVersionUID = -5552079673900167993L;

    private int brandId;
    private String brandName;

    private int modelId;
    private String modelName;
}