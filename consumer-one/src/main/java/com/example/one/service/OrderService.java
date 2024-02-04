package com.example.one.service;

import com.example.one.domain.Order;
import com.example.one.service.dto.OrderDto;

public interface OrderService {
    Order save(OrderDto clientDto);
}
