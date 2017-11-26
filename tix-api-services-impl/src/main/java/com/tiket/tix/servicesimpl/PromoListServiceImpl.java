package com.tiket.tix.servicesimpl;

import com.tiket.tix.entities.PromoList;
import com.tiket.tix.repositories.PromoListRepository;
import com.tiket.tix.services.PromoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Single;
import rx.SingleSubscriber;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PromoListServiceImpl implements PromoListService {
    @Autowired
    private PromoListRepository promoListRepository;

    @Override
    public List<PromoList> getAllActive(){
        return this.promoListRepository.findByStatus(1);
    }

    @Override
    public List<PromoList> getAllInactive(){
        return this.promoListRepository.findByStatus(0);
    }

    @Override
    public List<PromoList> getAllValid(){

        return this.promoListRepository.findByStatusAndStartDateLessThanAndEndDateGreaterThan(1, new Date(), new Date());
    }

    @Override
    public Single<List<PromoList>> getAllValidAsync(){
        return Single.create(new Single.OnSubscribe<List<PromoList>>() {
            @Override
            public void call(SingleSubscriber<? super List<PromoList>> singleSubscriber) {
                List<PromoList> promoLists = getAllValid();
                singleSubscriber.onSuccess(promoLists);
            }
        });
    }

    @Override
    public boolean insert(String title, String promoType, String lang, String photo, int precedence, int status, String category, String slug, String startDate, String endDate){

        PromoList promoList = new PromoList();
        promoList.setTitle(title);
        promoList.setPromoType(promoType);
        promoList.setLang(lang);
        promoList.setCategory(category);
        promoList.setPhoto(photo);
        promoList.setSlug(slug);
        promoList.setStatus(status);
        promoList.setPrecedence(precedence);
        promoList.setStartDate(this.parseDate(startDate));
        promoList.setEndDate(this.parseDate(endDate));
        promoList.setCreatedBy(1);
        promoList.setCreatedDatetime(new Date());
        promoList.setUpdatedBy(1);
        promoList.setUpdatedDatetime(new Date());
        this.promoListRepository.insert(promoList);

        return true;
    }

    private Date parseDate(String date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate;
        try {
            startDate = df.parse(date);
        } catch (ParseException e) {
            startDate = new Date();
        }

        return startDate;
    }
}
