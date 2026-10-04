/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.PRODUCTO;

import com.nexus.biblioNepo.UTILS.PageResponseUtils;
import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.GLOBAL.CloudinaryUploadResponse;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.PRODUCTO.ProductoAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.PRODUCTO.ProductoAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.PRODUCTO.ProductoDtoResp;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.ENTITIES.Inventario;
import com.nexus.demo.ENTITIES.InventarioProducto;
import com.nexus.demo.ENTITIES.Producto;
import com.nexus.demo.GLOBALEXCEPTIONHANDLER.exceptions.DatoInvalidoEcxeption;
import com.nexus.demo.NoDatosQueMostrarExecption;
import com.nexus.demo.REPOSITORY.CategoriaRepository;
import com.nexus.demo.REPOSITORY.InventarioProductoRepository;

import com.nexus.demo.REPOSITORY.MarcaProductoRepository;
import com.nexus.demo.REPOSITORY.ProductoRepository;
import com.nexus.demo.REPOSITORY.UnidadPesoRepository;
import com.nexus.demo.REPOSITORY.UsuarioRepository;
import com.nexus.demo.SERVICES.CLOUDINARY.ICloudinaryService;
import com.nexus.demo.SERVICES.INFORMACION_SEGURIDAD.IInformacionSeguridadService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.nexus.demo.REPOSITORY.InventarioRepository;
import com.nexus.demo.SERVICES.INVENTARIO.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

/**
 *
 * @author luis
 */
@Service
public class ProductoAdminService implements IProductoAdminService {

    private ProductoRepository productoRepository;

    private CategoriaRepository categoriaRepository;

    private IInformacionSeguridadService informacionSeguridadService;

    private MarcaProductoRepository marcaProductoRepository;

    private UnidadPesoRepository unidadPesoRepository;

    private UsuarioRepository usuarioRepository;

    private ICloudinaryService cloudinaryService;

    private InventarioRepository inventarioRepository;

    private IInventarioService inventarioService;

    private InventarioProductoRepository inventarioProductoRepo;

    @Autowired
    public ProductoAdminService(ProductoRepository productoRepository, CategoriaRepository categoriaRepository, IInformacionSeguridadService informacionSeguridadService, MarcaProductoRepository marcaProductoRepository, UnidadPesoRepository unidadPesoRepository, UsuarioRepository usuarioRepository, ICloudinaryService cloudinaryService, InventarioRepository inventarioRepository, IInventarioService inventarioService, InventarioProductoRepository inventarioProductoRepo) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
        this.informacionSeguridadService = informacionSeguridadService;
        this.marcaProductoRepository = marcaProductoRepository;
        this.unidadPesoRepository = unidadPesoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cloudinaryService = cloudinaryService;
        this.inventarioRepository = inventarioRepository;
        this.inventarioService = inventarioService;
        this.inventarioProductoRepo = inventarioProductoRepo;
    }

    @Caching(
            evict = {
                @CacheEvict(value = "productos_admin", allEntries = true),
                @CacheEvict(value = "productos", allEntries = true)
            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Producto create(ProductoAdminDtoReq productoAdminDtoReq, MultipartFile fotoProducto) {

        Producto producto = new Producto();

        Inventario inventario = inventarioRepository.getByIdUserAndActive(productoAdminDtoReq.getId_user())
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El Usuario no tiene inveantario en el sistema"));
        llenarDatos(producto, productoAdminDtoReq);

        AuditableUtils.create(producto, "prueba", "prueba");

        subirFotoProducto(fotoProducto, producto);

        productoRepository.save(producto);

        inventarioService.asignarProductoAInventario(producto, inventario, productoAdminDtoReq);

        return producto;

    }

    public void llenarDatos(Producto producto, ProductoAdminDtoReq productoAdminDtoReq) {

        producto.setNombre(productoAdminDtoReq.getNombre().trim());

        if (productoAdminDtoReq.getDescripcion() != null) {

            producto.setDescripcion(productoAdminDtoReq.getDescripcion().trim());

        }
        producto.setPeso(productoAdminDtoReq.getPeso());

        producto.setCategoriaProducto(categoriaRepository
                .findById(productoAdminDtoReq.getId_categoria_producto())
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La categoria no existe en el sistema.")));

        producto.setInformacionSeguridad(informacionSeguridadService.
                create(productoAdminDtoReq.getInformacionSeguridadDtoReq()));

        producto.setMarcaProducto(marcaProductoRepository.findById(productoAdminDtoReq.getId_marca_producto())
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La marca no existe en el sistema")));

        producto.setPrecioUnidad(productoAdminDtoReq.getPrecioUnidad());

        producto.setUnidadPeso(unidadPesoRepository.findById(productoAdminDtoReq.getId_unidad_peso())
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La unidad de peso no s eencuentra en el sistema")));

        producto.setUsuario(usuarioRepository.findById(
                productoAdminDtoReq.getId_user())
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El usuario no existe en el sistema")));

    }

    public void subirFotoProducto(MultipartFile file, Producto producto) {

        CloudinaryUploadResponse respCloudinary = cloudinaryService
                .uploadPrymaryFotoProduct(file, producto.getNombre().trim(), file.getOriginalFilename());

        producto.setImgProdcuto(respCloudinary.getSecureUrl());
        producto.setPublicIdImgProdcuto(respCloudinary.getSecureUrl());

    }

    @Cacheable(value = "productos_admin")
    @Transactional(readOnly = true)
    @Override
    public PageResponse<ProductoDtoResp> getAllBasic(String nombre, Long id_cat, Long id_user, Long id_marca, Double precion_min, Double precio_max, Pageable pageable) {

        Page<ProductoDtoResp> page = productoRepository.getAllBasic(nombre, id_marca, id_user, id_marca, precion_min, precio_max, pageable);

        if (page.isEmpty()) {
            throw new NoDatosQueMostrarExecption("No hay productos que mostrar");
        }

        return PageResponseUtils.CreatePageReponse(page);

    }

    @Transactional(readOnly = true)
    @Override
    public ProductoAdminDtoResp getProductoById(Long id) {

        return productoRepository.getProductoByIdAdmin(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El producto no existe en el sistema"));

    }

    @Caching(
            evict = {
                @CacheEvict(value = "productos_admin", allEntries = true),
                @CacheEvict(value = "productos", allEntries = true)
            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Producto updateById(Long id, ProductoAdminDtoReq productoAdminDtoReq, MultipartFile fotoProducto) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El producto no existe en el sistema."));

        llenarDatos(producto, productoAdminDtoReq);

        if (fotoProducto != null) {

            if (producto.getPublicIdImgProdcuto() != null) {

                cloudinaryService.deleteFile(producto.getPublicIdImgProdcuto());

            }

            subirFotoProducto(fotoProducto, producto);
        }

        AuditableUtils.update(producto, "prueba", "prueba");

        productoRepository.save(producto);

        InventarioProducto inventarioProducto = inventarioProductoRepo.getByIdProducto(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El producto no tiene inventario o no existe"));

        if (productoAdminDtoReq.getCantActual() < productoAdminDtoReq.getCantidadMinima()) {

            throw new DatoInvalidoEcxeption("La cantidad minima no puede ser menor a la cantidad actual.");
        }

        if (productoAdminDtoReq.getCantActual() > productoAdminDtoReq.getCantidadMax()) {

            throw new DatoInvalidoEcxeption("La cantidad actual no puede ser mayor a la cantidad maxima.");
        }

        if (productoAdminDtoReq.getCantidadMinima() > productoAdminDtoReq.getCantidadMax()) {

            throw new DatoInvalidoEcxeption("La cantidad minima no puede ser mayor a la cantidad maxima.");
        }

        inventarioProducto.setCantActual(productoAdminDtoReq.getCantActual());
        inventarioProducto.setCantidadMax(productoAdminDtoReq.getCantidadMax());
        inventarioProducto.setCantidadMinima(productoAdminDtoReq.getCantidadMinima());

        AuditableUtils.update(inventarioProducto, "prueba", "prueba");

        inventarioProductoRepo.save(inventarioProducto);

        return producto;
    }

}
