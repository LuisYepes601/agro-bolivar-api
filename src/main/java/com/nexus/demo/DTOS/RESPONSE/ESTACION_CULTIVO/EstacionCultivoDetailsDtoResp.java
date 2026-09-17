/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.RESPONSE.ESTACION_CULTIVO;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

/**
 *
 * @author luis
 */
public class EstacionCultivoDetailsDtoResp {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime deleteAt;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Boolean isDelete;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String createBy;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String creatorName;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String updateBy;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String updateName;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String deleteBy;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String deleteName;

    public EstacionCultivoDetailsDtoResp(LocalDateTime deleteAt, Boolean isDelete, String createBy, String creatorName, String updateBy, String updateName, String deleteBy, String deleteName) {
        this.deleteAt = deleteAt;
        this.isDelete = isDelete;
        this.createBy = createBy;
        this.creatorName = creatorName;
        this.updateBy = updateBy;
        this.updateName = updateName;
        this.deleteBy = deleteBy;
        this.deleteName = deleteName;
    }

    public EstacionCultivoDetailsDtoResp() {
    }

    public LocalDateTime getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(LocalDateTime deleteAt) {
        this.deleteAt = deleteAt;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getDeleteBy() {
        return deleteBy;
    }

    public void setDeleteBy(String deleteBy) {
        this.deleteBy = deleteBy;
    }

    public String getDeleteName() {
        return deleteName;
    }

    public void setDeleteName(String deleteName) {
        this.deleteName = deleteName;
    }
    
    
}
