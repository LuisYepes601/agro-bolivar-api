/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.MARCA_PRODUCTO;

import com.nexus.biblioNepo.UTILS.PageResponseUtils;
import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.MARCA_PRODUCTO.MarcaProductoAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.MARCA_PRODUCTO.MarcaProductoAdminDtoResp;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.DatoYaExistenteException;
import com.nexus.demo.ENTITIES.MarcaProducto;
import com.nexus.demo.NoDatosQueMostrarExecption;
import com.nexus.demo.REPOSITORY.MarcaProductoRepository;
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
public class MarcaProductoAdminService implements IMarcaProductoAdminService {

    private MarcaProductoRepository marcaProductoRepository;

    @Autowired
    public MarcaProductoAdminService(MarcaProductoRepository marcaProductoRepository) {
        this.marcaProductoRepository = marcaProductoRepository;
    }

    @Caching(
            evict = {
                @CacheEvict(value = "marcas_productos_admin", allEntries = true),
                @CacheEvict(value = "marcas_productos", allEntries = true)
            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public MarcaProducto create(MarcaProductoAdminDtoReq marcaProductoAdminDtoReq) {

        Optional<MarcaProducto> existe = marcaProductoRepository.existeAndEstaActivo(marcaProductoAdminDtoReq.getNombre().trim());

        if (existe.isPresent()) {

            throw new DatoYaExistenteException("La marca ya existe en el sistema ");
        }

        MarcaProducto marcaProducto = new MarcaProducto();

        llenarDatos(marcaProducto, marcaProductoAdminDtoReq);

        AuditableUtils.create(marcaProducto, "prueba", "prueba");

        return marcaProductoRepository.save(marcaProducto);

    }

    public void llenarDatos(MarcaProducto marcaProducto, MarcaProductoAdminDtoReq marcaProductoAdminDtoReq) {

        marcaProducto.setNombre(marcaProductoAdminDtoReq.getNombre().trim());

        if (marcaProductoAdminDtoReq.getDescripcion() != null) {
            marcaProducto.setDescripcion(marcaProductoAdminDtoReq.getDescripcion().trim());
        }

    }

    @Caching(
            evict = {
                @CacheEvict(value = "marcas_productos_admin", allEntries = true),
                @CacheEvict(value = "marcas_productos", allEntries = true),
                @CacheEvict(value = "marca_producto", allEntries = true)
            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public MarcaProducto update(Long id, MarcaProductoAdminDtoReq marcaProductoAdminDtoReq) {

        MarcaProducto marcaProducto = marcaProductoRepository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La marca no existe en el sistema."));

        Optional<MarcaProducto> existe = marcaProductoRepository.existeAndEstaActivo(marcaProductoAdminDtoReq.getNombre().trim());

        if (existe.isPresent()) {

            if (existe.get().getId() != marcaProducto.getId()) {

                throw new DatoYaExistenteException("La marca ya existe en el sistema ");
            }
        }

        llenarDatos(marcaProducto, marcaProductoAdminDtoReq);

        AuditableUtils.update(marcaProducto, "prueba", "prueba");

        return marcaProductoRepository.save(marcaProducto);
    }

    @Cacheable(value = "marcas_productos_admin")
    @Transactional(readOnly = true)
    @Override
    public PageResponse<MarcaProductoAdminDtoResp> getAll(String nombre, Boolean delete, Pageable pageable) {

        Page<MarcaProductoAdminDtoResp> page = marcaProductoRepository.getAllAdmin(nombre, delete, pageable);

        if (page.isEmpty()) {

            throw new NoDatosQueMostrarExecption("No hay marcas que mostrar.");
        }

        return PageResponseUtils.CreatePageReponse(page);

    }

    @Cacheable(value = "marca_producto")
    @Transactional(readOnly = true)
    @Override
    public MarcaProductoAdminDtoResp getByID(Long id) {

        return marcaProductoRepository.getMarcaById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La marac no existe en el sistema"));

    }

}
