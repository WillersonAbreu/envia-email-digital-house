package br.com.enviaemail.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class MailMarket implements Serializable {
  private final String contactEmail;
}
