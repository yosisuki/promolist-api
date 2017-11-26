package com.tiket.tix.controllers;

import com.tiket.tix.entities.PromoList;
import com.tiket.tix.services.PromoListService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;

@RestController
@RequestMapping(path="/promo_list")
public class PromoListController {
    @Autowired
    private PromoListService promoListService;

    @GetMapping(path="",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Promo List Index", notes = "List All Available Promo Pages")
    public @ResponseBody
    Response<List<PromoList>> index() {
        Response<List<PromoList>> promoListResponse = new Response<>();
        promoListResponse.setResponseCode("200");
        promoListResponse.setLang("en");
        promoListResponse.setResponseMessage("List of All Available Promo");
        promoListResponse.setPromoLists(this.promoListService.getAllValid());
        return promoListResponse;
    }

    @GetMapping(path="/async",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DeferredResult<List<PromoList>> indexAsync() {
        DeferredResult<List<PromoList>> deffered = new DeferredResult<>();
        this.promoListService.getAllValidAsync().subscribe(promoLists -> {
            deffered.setResult(promoLists);
            System.out.print(promoLists);
        });

        return deffered;
    }

    @PostMapping(path="",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Response create(
            @RequestParam(value="title", required = true) String title,
            @RequestParam(value="promo_type", required = true) String promoType,
            @RequestParam(value="lang", required = true) String lang,
            @RequestParam(value="photo", required = true) String photo,
            @RequestParam(value="precedence", required = true) int precedence,
            @RequestParam(value="status", required = true) int status,
            @RequestParam(value="category", required = true) String category,
            @RequestParam(value="slug", required = true) String slug,
            @RequestParam(value="start_date", required = true) String startDate,
            @RequestParam(value="end_date", required = true) String endDate
    ) {
        Response response = new Response();

        if(this.promoListService.insert(title, promoType, lang, photo, precedence, status, category, slug, startDate, endDate)){
            response.setResponseCode("200");
            response.setLang("en");
            response.setResponseMessage("Promo Inserted Successfully");
            return response;
        }
        response.setResponseCode("403");
        response.setLang("en");
        response.setResponseMessage("There's an error when creating promo");
        return response;
    }

}
