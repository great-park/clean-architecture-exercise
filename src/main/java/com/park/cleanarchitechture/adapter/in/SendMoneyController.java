package com.park.cleanarchitechture.adapter.in;

import com.park.cleanarchitechture.application.port.in.SendMoneyCommand;
import com.park.cleanarchitechture.application.port.in.SendMoneyUseCase;
import com.park.cleanarchitechture.common.WebAdapter;
import com.park.cleanarchitechture.domain.Account;
import com.park.cleanarchitechture.domain.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
class SendMoneyController {

    private final SendMoneyUseCase sendMoneyUseCase;

    @PostMapping(path = "/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
    void sendMoney(
            @PathVariable("sourceAccountId") Long sourceAccountId,
            @PathVariable("targetAccountId") Long targetAccountId,
            @PathVariable("amount") Long amount) {

        // 입력을 use case의 입력 모델로 맵핑
        SendMoneyCommand command = new SendMoneyCommand(
                new Account.AccountId(sourceAccountId),
                new Account.AccountId(targetAccountId),
                Money.of(amount));

        // use case 호출
        sendMoneyUseCase.sendMoney(command);
    }

}