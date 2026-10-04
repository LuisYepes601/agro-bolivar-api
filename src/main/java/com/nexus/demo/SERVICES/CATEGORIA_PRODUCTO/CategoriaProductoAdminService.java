/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.CATEGORIA_PRODUCTO;

import com.nexus.biblioNepo.UTILS.PageResponseUtils;
import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.CATEGORIA_PRODUCTO.CategoriaAdminProdDtoReq;
import com.nexus.demo.DTOS.RESPONSE.CATEGORIA_PRODUCTO.CategoriaProductoAdminDtoResp;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.DatoYaExistenteException;
import com.nexus.demo.ENTITIES.CategoriaProducto;
import com.nexus.demo.NoDatosQueMostrarExecption;
import com.nexus.demo.REPOSITORY.CategoriaRepository;
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
public class CategoriaProductoAdminService implements ICategoriaProductoAdminService {

    private CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaProductoAdminService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Caching(
            evict = {
                @CacheEvict(value = "categorias_producto_admin", allEntries = true),
                @CacheEvict(value = "categorias_productos", allEntries = true)
            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public CategoriaProducto create(CategoriaAdminProdDtoReq categoriaAdminProdDtoReq) {

        Optional<CategoriaProducto> existe = categoriaRepository.existeAndEstaActivo(categoriaAdminProdDtoReq.getNombre().trim());

        if (existe.isPresent()) {

            throw new DatoYaExistenteException("La categoria ya existe en el sistema.");
        }

        CategoriaProducto categoriaProducto = new CategoriaProducto();

        llenarDatos(categoriaAdminProdDtoReq, categoriaProducto);

        AuditableUtils.create(categoriaProducto, "prueba", "prueba");

        return categoriaRepository.save(categoriaProducto);
    }

    public void llenarDatos(CategoriaAdminProdDtoReq categoriaAdminProdDtoReq, CategoriaProducto categoriaProducto) {

        categoriaProducto.setNombre(categoriaAdminProdDtoReq.getNombre().trim());

        if (categoriaAdminProdDtoReq.getDescripcion() != null) {

            categoriaProducto.setDescripcion(categoriaAdminProdDtoReq.getDescripcion().trim());
        }
    }

    @Caching(
            evict = {
                @CacheEvict(value = "categorias_producto_admin", allEntries = true),
                @CacheEvict(value = "categorias_productos", allEntries = true),
                @CacheEvict(value = "categoria_producto", allEntries = true)
            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public CategoriaProducto updateById(Long id, CategoriaAdminProdDtoReq categoriaAdminProdDtoReq) {

        CategoriaProducto categoriaProducto = categoriaRepository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La categoría no existe en el sistema."));

        Optional<CategoriaProducto> existe = categoriaRepository.existeAndEstaActivo(categoriaAdminProdDtoReq.getNombre().trim());

        if (existe.isPresent()) {

            if (existe.get().getId() != categoriaProducto.getId()) {

                throw new DatoYaExistenteException("La categoria ya existe en el sistema.");
            }
        }

        llenarDatos(categoriaAdminProdDtoReq, categoriaProducto);

        AuditableUtils.update(categoriaProducto, "prueba", "prueba");

        return categoriaRepository.save(categoriaProducto);

    }

    @Cacheable(value = "categorias_producto_admin")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public PageResponse<CategoriaProductoAdminDtoResp> getAll(String nombre, Boolean delete, Pageable pageable) {

        Page<CategoriaProductoAdminDtoResp> page = categoriaRepository.getAllAdmin(nombre, delete, pageable);

        if (page.isEmpty()) {
            throw new NoDatosQueMostrarExecption("No hay categorias que mostrar.");
        }

        return PageResponseUtils.CreatePageReponse(page);
    }

    @Cacheable(value = "categoria_producto", key = "#id")
    @Transactional(readOnly = true)
    @Override
    public CategoriaProductoAdminDtoResp getCategoriaById(Long id) {

        return categoriaRepository.getCategoriaById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La categoria no existe en el sistema"));

    }

}
