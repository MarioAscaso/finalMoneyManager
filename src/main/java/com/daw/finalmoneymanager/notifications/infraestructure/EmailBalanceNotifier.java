package com.daw.finalmoneymanager.notifications.infraestructure;

import com.daw.finalmoneymanager.notifications.domain.BalanceNotifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EmailBalanceNotifier implements BalanceNotifier {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Value("${moneymanager.admin-email}")
    private String adminEmail;

    public EmailBalanceNotifier(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void notifyNegativeBalance(BigDecimal newBalance) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(adminEmail);

            message.setSubject("¡Alerta de Saldo Negativo!");
            message.setText("Hola,\n\nTu saldo en Money Manager ha caído a negativo." +
                            "\n\nSaldo actual: " + newBalance.toString() + "€" +
                            "\n\nRevisa tus movimientos!");
            mailSender.send(message);

            System.out.println("Email de alerta enviado a: " + adminEmail);
        } catch (Exception e) {
            System.err.println("Error al enviar el email de alerta: " + e.getMessage());
        }
    }
}