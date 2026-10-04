/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.ROL;

import com.nexus.biblioNepo.UTILS.PageResponseUtils;
import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.ROL.RolAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.ROL.RolAdminDtoResp;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.DatoYaExistenteException;
import com.nexus.demo.ENTITIES.Rol;
import com.nexus.demo.REPOSITORY.RolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author luis
 */
@Service
public class RolAdminService implements IRolAdminService {

    private RolRepository rolRepository;

    @Autowired
    public RolAdminService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Caching(
            evict = {
                @CacheEvict(value = "roles_admin", allEntries = true),
                @CacheEvict(value = "roles", allEntries = true)
            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Rol create(RolAdminDtoReq rolAdminDtoReq) {

        Optional<Rol> existe = rolRepository.existeAndEstaActivo(rolAdminDtoReq.getNombre().trim());

        if (existe.isPresent()) {

            throw new DatoYaExistenteException("El rol ya existe en el sistema");
        }

        Rol rol = new Rol();

        rol.setNombre(rolAdminDtoReq.getNombre().trim());

        if (rolAdminDtoReq.getDescripcion() != null) {

            rol.setDescripcion(rolAdminDtoReq.getDescripcion().trim());
        }

        AuditableUtils.create(rol, "prueba", "prueba");

        return rolRepository.save(rol);
    }

    @Caching(
            evict = {
                @CacheEvict(value = "roles_admin", allEntries = true),
                @CacheEvict(value = "roles", allEntries = true)
            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Rol update(Long id, RolAdminDtoReq rolAdminDtoReq) {

        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El rol no existe en el sistema"));

        Optional<Rol> existe = rolRepository.existeAndEstaActivo(rolAdminDtoReq.getNombre().trim());

        if (existe.isPresent()) {

            if (existe.get().getId() != rol.getId()) {

                throw new DatoYaExistenteException("Ya existe un rol con ese nombre.");
            }
        }

        rol.setNombre(rolAdminDtoReq.getNombre().trim());

        if (rolAdminDtoReq.getDescripcion() != null) {

            rol.setDescripcion(rolAdminDtoReq.getDescripcion().trim());
        }

        AuditableUtils.update(rol, "prueba", "prueba");

        return rolRepository.save(rol);
    }

    @Cacheable(value = "roles_admin")
    @Transactional(readOnly = true)
    @Override
    public PageResponse<RolAdminDtoResp> getAll(String nombre, Boolean active, Pageable pageable) {

        Page<RolAdminDtoResp> page = rolRepository.getAllAdmin(nombre, active, pageable);

        if (page.isEmpty()) {
            throw new DatoNoExistenteEcxeption("No hay roles que mostrar");
        }

        return PageResponseUtils.CreatePageReponse(page);

    }

    @Transactional(readOnly = true)
    @Override
    public RolAdminDtoResp getRolById(Long id) {

        return rolRepository.obternerRolById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El rol no existe en el sistema"));

    }

}
