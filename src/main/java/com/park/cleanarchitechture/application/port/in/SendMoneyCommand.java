package com.park.cleanarchitechture.application.port.in;

import com.park.cleanarchitechture.common.SelfValidating;
import com.park.cleanarchitechture.domain.Account;
import com.park.cleanarchitechture.domain.Money;
import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Value;
import com.park.cleanarchitechture.domain.Account.AccountId;

@Value
@EqualsAndHashCode(callSuper = false)
public
class SendMoneyCommand extends SelfValidating<SendMoneyCommand> {

    @NotNull
    private final AccountId sourceAccountId;

    @NotNull
    private final AccountId targetAccountId;

    @NotNull
    private final Money money;

    public SendMoneyCommand(
            AccountId sourceAccountId,
            AccountId targetAccountId,
            Money money) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.money = money;
        this.validateSelf();
    }
}