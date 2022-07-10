package org.cds.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
public class DataContent implements Serializable {
   private String header;
   private String backgroundImg;
   private String text;
}
