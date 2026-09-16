/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.biblioNepo.UTILS;

import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import org.springframework.data.domain.Page;


/**
 *
 * @author luis
 */
public class PageResponseUtils {

    public static PageResponse CreatePageReponse(Page page) {

        PageResponse pageResponse = new PageResponse();

        pageResponse.setContent(page.getContent());
        pageResponse.setEmpty(page.isEmpty());
        pageResponse.setNumber(page.getNumber());
        pageResponse.setNumberOfElements(page.getNumberOfElements());
        pageResponse.setPageSize(page.getPageable().getPageSize());
        pageResponse.setPageNumber(page.getPageable().getPageNumber());
        pageResponse.setSize(page.getSize());
        pageResponse.setTotalElements(page.getTotalElements());
        pageResponse.setTotalPages(page.getTotalPages());

        return pageResponse;

    }
}
