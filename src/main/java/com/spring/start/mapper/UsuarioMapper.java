package com.spring.start.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.spring.start.dto.usuario.UsuarioRequestDto;
import com.spring.start.dto.usuario.UsuarioResponseDto;
import com.spring.start.entity.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	public UsuarioResponseDto mapToUsuarioResponseDto(Usuario usuario);

	public List<UsuarioResponseDto> mapToUsuarioResponseDto(List<Usuario> usuarios);

	public Usuario mapUsuarioRequestToUsuario(UsuarioRequestDto dto);

	public Usuario mapUsuarioRequestToUsuario(Long id, UsuarioRequestDto dto);

	public UsuarioResponseDto mapUsuarioRequestToUsuarioResponse(UsuarioRequestDto dto);
}
