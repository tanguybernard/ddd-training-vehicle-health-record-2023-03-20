package com.zenika.vhr.inscription.infrastructure.bus;

import com.zenika.vhr.shared_kernel.infrastructure.EventBus;
import com.zenika.vhr.shared_kernel.infrastructure.IntegrationEvent;

public class RabbitMqBus implements EventBus {
    @Override
    public void emit(IntegrationEvent e) {
        //channel, topic, queue


    }
}
