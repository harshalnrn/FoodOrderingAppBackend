package com.upgrad.FoodOrderingApp.service.business;

import com.upgrad.FoodOrderingApp.service.entity.PaymentEntity;
import com.upgrad.FoodOrderingApp.service.dao.PaymentsRepository;
import com.upgrad.FoodOrderingApp.service.exception.PaymentMethodNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaymentService {

    @Autowired
    private PaymentsRepository paymentsRepository;


    public List<PaymentEntity> getAllPaymentMethods() {

        return paymentsRepository.getPaymentMediums();
    }


    public PaymentEntity getPaymentEntityFromUuid(String id) throws PaymentMethodNotFoundException{


      PaymentEntity paymentEntity= paymentsRepository.getPayment(id);

      if(paymentEntity==null){
          throw new PaymentMethodNotFoundException("PNF-002","No payment method found by this id");
      }
      return paymentEntity;
    }
}
