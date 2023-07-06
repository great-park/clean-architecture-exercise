package com.park.cleanarchitechture.application.service;

import com.park.cleanarchitechture.application.port.in.SendMoneyCommand;
import com.park.cleanarchitechture.application.port.in.SendMoneyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class SendMoneyService implements SendMoneyUseCase {
    @Override
    public boolean sendMoney(SendMoneyCommand command) {
        return false;
    }
}
