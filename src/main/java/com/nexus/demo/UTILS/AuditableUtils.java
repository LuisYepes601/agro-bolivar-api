/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.biblioNepo.UTILS;

import com.nexus.biblioNepo.AUDITORIA.Auditoria;
import java.time.LocalDateTime;

/**
 *
 * @author luis
 */
public class AuditableUtils {
    
    public static <T extends Auditoria> T update(
            T entity,
            String emailUser,
            String userName) {
        
        entity.setUpdateBy(emailUser);
        entity.setUpdateName(userName);
        entity.setUpdateAt(LocalDateTime.now());
        
        return entity;
        
    }
    
    public static <T extends Auditoria> T delete(T entity, String emailUser, String userName) {
        
        update(entity, emailUser, userName);
        entity.setDeleteAt(LocalDateTime.now());
        entity.setDeleteBy(emailUser);
        entity.setDeleteName(userName);
        entity.setIsDelete(true);
        
        return entity;
    }
    
    public static <T extends Auditoria> void create(T entity, String emailUser, String userName) {
        
        update(entity, emailUser, userName);
        entity.setCreateAt(LocalDateTime.now());
        entity.setCreateBy(emailUser);
        entity.setCreatorName(userName);
        
    }
    
    public static <T extends Auditoria> void activate(T entity, String emailUser, String userName) {
        
        update(entity, emailUser, userName);
        entity.setIsDelete(false);
        entity.setDeleteBy(null);
        entity.setDeleteName(null);
        entity.setDeleteAt(null);
        
    }
    
}
