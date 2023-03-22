package com.zenika.vhr.shared_kernel.infrastructure;

public interface EventBus {

    void emit(IntegrationEvent e);
}
