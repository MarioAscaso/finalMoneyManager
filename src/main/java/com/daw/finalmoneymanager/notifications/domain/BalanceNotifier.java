package com.daw.finalmoneymanager.notifications.domain;

import java.math.BigDecimal;

public interface BalanceNotifier {
    void notifyNegativeBalance(BigDecimal newBalance);
}