package com.tiket.tix.repositories;

import com.tiket.tix.entities.PromoList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PromoListRepository extends MongoRepository<PromoList, Long>{
    List<PromoList> findAll();
    List<PromoList> findByStatus(int status);
    List<PromoList> findByStatusAndStartDateLessThanAndEndDateGreaterThan(int status, Date startDate, Date endDate);
    PromoList save(PromoList promoList);
    PromoList insert(PromoList promoList);
}
