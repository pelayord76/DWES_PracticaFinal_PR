package com.spring.start.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.spring.start.dto.usuario.UsuarioCreateRequestDto;
import com.spring.start.dto.usuario.UsuarioResponseDto;
import com.spring.start.dto.usuario.UsuarioUpdateRequestDto;
import com.spring.start.entity.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	public UsuarioResponseDto mapToUsuarioResponseDto(Usuario usuario);

	public List<UsuarioResponseDto> mapToUsuarioResponseDto(List<Usuario> usuarios);

	public Usuario mapUsuarioCreateRequestToUsuario(UsuarioCreateRequestDto dto);

	public Usuario mapUsuarioUpdateRequestToUsuario(Long id, UsuarioUpdateRequestDto dto);

	public UsuarioResponseDto mapUsuarioCreateRequestToUsuarioResponse(UsuarioCreateRequestDto dto);

	public UsuarioResponseDto mapUsuarioUpdateRequestToUsuarioResponse(UsuarioUpdateRequestDto dto);
}
