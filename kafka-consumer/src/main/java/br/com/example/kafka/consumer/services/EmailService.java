package br.com.example.kafka.consumer.services;

import jakarta.mail.internet.MimeMessage;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    public void enviarNotaCorretagem(String destinatario, File anexo) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(destinatario);
        helper.setSubject("Nota de Corretagem - Confirmação da Compra");
        helper.setText("<p>Olá,</p>" +
                "<p>Segue em anexo sua nota de corretagem referente à sua compra na bolsa de valores.</p>" +
                "<p>Atenciosamente,</p>" +
                "<p><b>Equipe de Investimentos</b></p>", true);

        helper.addAttachment(anexo.getName(), anexo);

        mailSender.send(message);
    }
}
