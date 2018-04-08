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
public class VehBrand implements Serializable {

    private static final long serialVersionUID = 348789021792381949L;

    private int brandId;
    private String brandName;
}