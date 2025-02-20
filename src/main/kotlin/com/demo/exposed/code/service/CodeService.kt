package com.demo.exposed.code.service

import com.demo.exposed.code.models.CodeReq
import com.demo.exposed.code.models.CodeRes
import com.demo.exposed.code.domain.repositories.CodeDao
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CodeService(
    private val codeDao: CodeDao
) {
    // 전체 코드 조회
    fun getAllCodes(): List<CodeRes> {
        return codeDao.findAll()
    }

    // 코드 ID로 코드 조회
    fun getCodeById(codeId: String): CodeRes {
        return codeDao.findByCodeId(codeId)
            ?: throw NoSuchElementException("코드를 찾을 수 없습니다: $codeId")
    }

    // 상위 코드 ID로 하위 코드 조회
    fun getCodesByParentId(parentCodeId: String): List<CodeRes> {
        return codeDao.findByParentCodeId(parentCodeId)
    }

    // 코드 생성
    @Transactional
    fun createCode(codeReq: CodeReq): CodeRes {
        if (codeDao.findByCodeId(codeReq.codeId) != null) {
            throw IllegalArgumentException("이미 존재하는 코드 ID입니다: ${codeReq.codeId}")
        }
        return codeDao.create(codeReq)
    }

    // 코드 수정
    @Transactional
    fun updateCode(codeId: String, codeReq: CodeReq): CodeRes {
        return codeDao.update(codeId, codeReq)
            ?: throw NoSuchElementException("수정할 코드를 찾을 수 없습니다: $codeId")
    }

    // 코드 삭제
    @Transactional
    fun deleteCode(codeId: String) {
        codeDao.delete(codeId)
    }

    // 계층형 코드 구조 반환
    fun getCodeHierarchy(): List<CodeRes> {
        val allCodes = getAllCodes()
        return buildHierarchy(allCodes)
    }

    // 활성화된 코드 조회 또는 전체 코드 조회
    fun getActiveCodes(onlyActive: Boolean): List<CodeRes> {
        return if (onlyActive) {
            codeDao.getActiveCodesOnly()
        } else {
            getAllCodes()
        }
    }

    // 코드 리스트를 계층 구조로 변환
    private fun buildHierarchy(codes: List<CodeRes>): List<CodeRes> {
        val codeMap = codes.associateBy { it.codeId }
        val rootCodes = codes.filter { it.parCodeId == null }.toMutableList()

        codes.forEach { code ->
            code.parCodeId?.let { parentId ->
                codeMap[parentId]?.let { parent ->
                    if (parent.subCodes == null) {
                        parent.subCodes = mutableListOf()
                    }
                    parent.subCodes?.add(code)
                }
            }
        }

        return rootCodes
    }
}
