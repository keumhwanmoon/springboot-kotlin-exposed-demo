package com.demo.exposed.code.controller

import com.demo.exposed.code.models.CodeReq
import com.demo.exposed.code.models.CodeRes
import com.demo.exposed.code.service.CodeService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/codes")
class CodeController(
    private val codeService: CodeService
) {
    @GetMapping
    fun getAllCodes(): List<CodeRes> {
        return codeService.getAllCodes()
    }

    @GetMapping("/{codeId}")
    fun getCodeById(@PathVariable codeId: String): CodeRes {
        return codeService.getCodeById(codeId)
    }

    @GetMapping("/parent/{parentCodeId}")
    fun getCodesByParentId(@PathVariable parentCodeId: String): List<CodeRes> {
        return codeService.getCodesByParentId(parentCodeId)
    }

    @PostMapping
    fun createCode(@Valid @RequestBody codeReq: CodeReq): CodeRes {
        return codeService.createCode(codeReq)
    }

    @PutMapping("/{codeId}")
    fun updateCode(
        @PathVariable codeId: String,
        @Valid @RequestBody codeReq: CodeReq
    ): CodeRes {
        return codeService.updateCode(codeId, codeReq)
    }

    @DeleteMapping("/{codeId}")
    fun deleteCode(@PathVariable codeId: String) {
        codeService.deleteCode(codeId)
    }

    @GetMapping("/hierarchy")
    fun getCodeHierarchy(): List<CodeRes> {
        return codeService.getCodeHierarchy()
    }

    @GetMapping("/active")
    fun getActiveCodes(
        @RequestParam(required = false, defaultValue = "true") onlyActive: Boolean
    ): List<CodeRes> {
        return codeService.getActiveCodes(onlyActive)
    }
}
