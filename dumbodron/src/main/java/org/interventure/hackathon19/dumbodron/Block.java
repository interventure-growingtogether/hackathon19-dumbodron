package org.interventure.hackathon19.dumbodron;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2019-12-24
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Block {

  private String name;
  private String data;
  private Integer arg;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getArg() {
    return arg;
  }

  public void setArg(Integer arg) {
    this.arg = arg;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }
}
