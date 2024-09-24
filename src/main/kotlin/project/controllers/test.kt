package db.project.ghorbanian.controllers

import db.project.ghorbanian.models.Factor
import db.project.ghorbanian.repository.FactorRepo
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rest/")
class test (
        val factorRepo: FactorRepo
){

    @PostMapping("getTest")
    fun test(@RequestBody factor : Factor){

        factorRepo.save(factor)
    }
}