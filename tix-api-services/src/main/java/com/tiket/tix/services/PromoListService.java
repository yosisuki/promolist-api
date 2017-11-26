package com.tiket.tix.services;

import com.tiket.tix.entities.PromoList;
import org.springframework.stereotype.Service;
import rx.Single;

import java.util.List;

@Service
public interface PromoListService {
    List<PromoList> getAllActive();
    List<PromoList> getAllInactive();
    List<PromoList> getAllValid();
    Single<List<PromoList>> getAllValidAsync();
    boolean insert(String title, String promoType, String lang, String photo, int precedence, int status, String category, String slug, String startDate, String endDate);
}
