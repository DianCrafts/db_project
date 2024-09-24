package db.project.ghorbanian.controllers

import db.project.ghorbanian.models.RawMatFactor
import db.project.ghorbanian.models.RawMaterial
import db.project.ghorbanian.models.Store
import db.project.ghorbanian.repository.RawMatFactorRepo
import db.project.ghorbanian.repository.RawMaterialRepo
import db.project.ghorbanian.repository.StoreRepo
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rest/store/")
class StoreCtrl(
        val rawMaterialRepo: RawMaterialRepo,
        val storeRepo: StoreRepo,
        val rawMatFactorRepo : RawMatFactorRepo

) {

    @PostMapping("add-store")
    fun addStore(@RequestBody store :Store){
        storeRepo.save(store)
    }

    @PostMapping("add-raw-material")
    fun addRawMaterial(@RequestBody rawMaterial: RawMaterial){
        if (rawMaterial.store.isActive)
          rawMaterialRepo.save(rawMaterial)
        else println("store is not active")
    }
    @GetMapping("get-stores")
    fun getStores():List<Store>{
        return storeRepo.findAllByIsActive(true)
    }

    @GetMapping("get-raw-materials/{storeId}")
    fun getRawMaterials(@PathVariable storeId: Long):List<RawMaterial>{
        return rawMaterialRepo.findAllByIsAvailableAndStoreDbIdAndStoreIsActive(true , storeId, true)
    }

    @PostMapping("buy-material")
    fun buy(@RequestBody rawMatFactor: RawMatFactor){
        for (i in rawMatFactor.rawMaterials){
            i.hasBeenSold = true
        }
        rawMatFactorRepo.save(rawMatFactor)
    }

    @PutMapping("update-materials")
    fun updateRawMaterials(@RequestBody rawMaterial: RawMaterial){
        val tmpMat = rawMaterialRepo.findById(rawMaterial.dbId).orElseThrow()
        if (tmpMat.hasBeenSold){
            tmpMat.isAvailable = false
            rawMaterialRepo.save(tmpMat)
            rawMaterialRepo.save(RawMaterial(rawMaterial.name ,rawMaterial.price,rawMaterial.store , rawMaterial.number , rawMaterial.isAvailable , rawMaterial.hasBeenSold))
        }
        else {
            tmpMat.updateValues(rawMaterial)
            rawMaterialRepo.save(tmpMat)
        }
    }

    @PutMapping("update-store")
    fun updateStore(@RequestBody store: Store){
        var tmpStore = storeRepo.findById(store.dbId)
        tmpStore.orElseThrow().updateValues(store)
    }
}