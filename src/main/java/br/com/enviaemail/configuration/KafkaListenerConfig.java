package br.com.enviaemail.configuration;

import br.com.enviaemail.EmailInput;
import br.com.enviaemail.model.MailMarket;
import br.com.enviaemail.service.EmailService;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@Log4j2
public class KafkaListenerConfig {
  private final EmailService emailService;

  Gson gson = new Gson();

  public KafkaListenerConfig(EmailService emailService) {
    this.emailService = emailService;
  }

  @KafkaListener(topics = "mail_market", groupId = "group_id_01")
  public void listener(ConsumerRecord<String, String> payload)
    throws Exception {
    final String BODY = "Seja bem-vindo à agenda digital, ";
    final String SUBJECT =
      "Você foi adicionado à agenda digital do Administrador";
    MailMarket mailMarket = gson.fromJson(payload.value(), MailMarket.class);

    if (mailMarket.getContactEmail().isEmpty()) {
      throw new Exception(
        "Mensagem do tópico não contém email do contato para enviar"
      );
    }

    log.info(payload.value());

    this.emailService.enviaEmail(
        new EmailInput(
          mailMarket.getContactEmail(),
          BODY + mailMarket.getContactEmail(),
          SUBJECT
        )
      );
  }
}
