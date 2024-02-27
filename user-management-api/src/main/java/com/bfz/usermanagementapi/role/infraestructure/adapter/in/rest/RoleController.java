package com.bfz.usermanagementapi.role.infraestructure.adapter.in.rest;

import com.bfz.usermanagementapi.common.dto.ApiResponseDto;
import com.bfz.usermanagementapi.role.core.application.port.in.usecase.IRoleService;
import com.bfz.usermanagementapi.role.infraestructure.adapter.in.rest.dto.RoleRequestDto;
import com.bfz.usermanagementapi.role.infraestructure.adapter.in.rest.dto.RoleResponseDto;
import com.bfz.usermanagementapi.role.infraestructure.adapter.common.mapper.IRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author bruferper
 */

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final IRoleService roleService;
    private final IRoleMapper roleMapper;

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<RoleResponseDto>>> findAll() {
        List<RoleResponseDto> roleResponseDtoList = roleService.findAll().stream()
                .map(roleMapper::getRoleResponseDto).toList();
        ApiResponseDto<List<RoleResponseDto>> response = ApiResponseDto.<List<RoleResponseDto>>builder()
                .ok(true).message("Roles listed successfully").body(roleResponseDtoList).build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<RoleResponseDto>> findAll(@PathVariable("id") Integer id) {
        RoleResponseDto responseDto = roleMapper.getRoleResponseDto(roleService.findById(id));
        ApiResponseDto<RoleResponseDto> response = ApiResponseDto.<RoleResponseDto>builder()
                .ok(true).message("Role listed successfully").body(responseDto).build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponseDto<Void>> create(@RequestBody RoleRequestDto requestDto) {
        roleService.create(roleMapper.getRoleFromDto(requestDto));
        return new ResponseEntity<>(ApiResponseDto.<Void>builder().ok(true).message("Role created successfully").build(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Void>> update(@PathVariable("id") Integer id, @RequestBody RoleRequestDto requestDto) {
        roleService.update(id, roleMapper.getRoleFromDto(requestDto));
        return ResponseEntity.ok(ApiResponseDto.<Void>builder().ok(true).message("Role updated successfully").build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Void>> deleteById(@PathVariable("id") Integer id) {
        roleService.deleteById(id);
        return ResponseEntity.ok(ApiResponseDto.<Void>builder().ok(true).message("Role deleted successfully").build());
    }

}
