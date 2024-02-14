package com.bfz.usermanagementapi.user.infraestructure.rest;

import com.bfz.usermanagementapi.common.dto.ApiResponseDto;
import com.bfz.usermanagementapi.user.application.port.input.IUserService;
import com.bfz.usermanagementapi.user.infraestructure.dto.UserRequestDto;
import com.bfz.usermanagementapi.user.infraestructure.dto.UserResponseDto;
import com.bfz.usermanagementapi.user.infraestructure.mapper.IUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author bruferper
 */

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;
    private final IUserMapper userMapper;

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<UserResponseDto>>> findAll() {
        List<UserResponseDto> userResponseDtoList = userService.findAll().stream()
                .map(userMapper::getUserResponseDto).toList();
        ApiResponseDto<List<UserResponseDto>> response = ApiResponseDto.<List<UserResponseDto>>builder()
                .ok(true).message("Users listed successfully").body(userResponseDtoList)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<UserResponseDto>> findAll(@PathVariable("id") Long id) {
        UserResponseDto userResponseDto = userMapper.getUserResponseDto(userService.findById(id));
        ApiResponseDto<UserResponseDto> response = ApiResponseDto.<UserResponseDto>builder()
                .ok(true).message("User listed successfully").body(userResponseDto)
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponseDto<Void>> create(@RequestBody UserRequestDto requestDto) {
        userService.create(userMapper.getUserFromDto(requestDto));
        return new ResponseEntity<>(ApiResponseDto.<Void>builder().ok(true).message("User created successfully").build(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Void>> update(@PathVariable("id") Long id, @RequestBody UserRequestDto requestDto) {
        userService.update(id, userMapper.getUserFromDto(requestDto));
        return ResponseEntity.ok(ApiResponseDto.<Void>builder().ok(true).message("User updated successfully").build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Void>> deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok(ApiResponseDto.<Void>builder().ok(true).message("User deleted successfully").build());
    }

}
