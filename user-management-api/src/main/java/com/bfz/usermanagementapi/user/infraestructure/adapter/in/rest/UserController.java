package com.bfz.usermanagementapi.user.infraestructure.adapter.in.rest;

import com.bfz.usermanagementapi.common.dto.ApiResponseDto;
import com.bfz.usermanagementapi.user.core.application.port.in.usecase.IUserService;
import com.bfz.usermanagementapi.user.infraestructure.adapter.in.rest.dto.UserRequestDto;
import com.bfz.usermanagementapi.user.infraestructure.adapter.in.rest.dto.UserResponseDto;
import com.bfz.usermanagementapi.user.infraestructure.adapter.common.mapper.IUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author bruferper
 */

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
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

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<ApiResponseDto<Void>> create(
            @RequestPart("user") UserRequestDto requestDto,
            @RequestPart("photo") MultipartFile photo
    ) throws IOException {
        userService.create(userMapper.getUserFromDto(requestDto), photo);
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
