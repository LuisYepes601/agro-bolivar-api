/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.USUARIO;

import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.RESPONSE.USUARIO.UsuarioDtoReq;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.DatoYaExistenteException;
import com.nexus.demo.ENTITIES.Inventario;
import com.nexus.demo.ENTITIES.Usuario;
import com.nexus.demo.REPOSITORY.RolRepository;
import com.nexus.demo.REPOSITORY.TipoDocumentoRepository;
import com.nexus.demo.REPOSITORY.UsuarioRepository;
import com.nexus.demo.SERVICES.CLOUDINARY.ICloudinaryService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nexus.demo.REPOSITORY.InventarioRepository;

/**
 *
 * @author luis
 */
@Service
public class UsuarioService implements IUsuarioService {

    private UsuarioRepository usuarioRepository;

    private RolRepository rolRepository;

    private TipoDocumentoRepository tipoDocumentoRepository;

    private ICloudinaryService cloudinaryService;

    private PasswordEncoder passWordEncoder;

    private InventarioRepository inventarioProductoRepo;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, RolRepository rolRepository, TipoDocumentoRepository tipoDocumentoRepository, ICloudinaryService cloudinaryService, PasswordEncoder passWordEncoder, InventarioRepository inventarioProductoRepo) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.tipoDocumentoRepository = tipoDocumentoRepository;
        this.cloudinaryService = cloudinaryService;
        this.passWordEncoder = passWordEncoder;
        this.inventarioProductoRepo = inventarioProductoRepo;
    }

    @Caching(
            evict = {
                @CacheEvict(value = "usuarios_admin", allEntries = true),
                @CacheEvict(value = "usuarios", allEntries = true)

            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Usuario registrarce(UsuarioDtoReq usuarioDtoReq) {

        Usuario usuario = new Usuario();

        Optional<Usuario> emailEnUso = usuarioRepository.emailEnUso(usuarioDtoReq.getEmail().trim());

        if (emailEnUso.isPresent()) {
            throw new DatoYaExistenteException("El email ya se encuentra en uso.");

        }

        llenarDatosBasicos(usuario, usuarioDtoReq);

        String contraseniaEncriptada = passWordEncoder.encode(usuarioDtoReq.getContrasenia().trim());

        usuario.setContrasenia(contraseniaEncriptada);

        AuditableUtils.create(usuario, "prueba", "prueba");

        usuarioRepository.save(usuario);

        Inventario inventarioProducto = new Inventario();

        inventarioProducto.setUsuario(usuario);

        AuditableUtils.create(inventarioProducto, "prueba", "prueba");

        inventarioProductoRepo.save(inventarioProducto);

        return usuario;

    }

    public void llenarDatosBasicos(Usuario usuario, UsuarioDtoReq usuarioDtoReq) {

        usuario.setRol(rolRepository.findById(usuarioDtoReq.getId_rol())
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El rol no existe en el sistema")));

        usuario.setTelefono(usuarioDtoReq.getTelefono().trim());

        usuario.setApellidoPaterno(usuarioDtoReq.getApellidoPaterno().trim());
        usuario.setApellidoMaterno(usuarioDtoReq.getApellidoMaterno());

        usuario.setEstado(true);

        usuario.setTipoDocumento(tipoDocumentoRepository.findById(usuarioDtoReq.getId_tipo_doc())
                .orElseThrow(()
                        -> new DatoNoExistenteEcxeption("El tipo de documento no existe en el sistema")));

        usuario.setNumDocumento(usuarioDtoReq.getNumDocumento().trim());

        usuario.setEmail(usuarioDtoReq.getEmail().trim());

        usuario.setPrimerNombre(usuarioDtoReq.getPrimerNombre().trim());

        if (usuarioDtoReq.getSegundoNombre() != null) {
            usuario.setSegundoNombre(usuarioDtoReq.getSegundoNombre().trim());

        }

    }

}
