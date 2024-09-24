package db.project.ghorbanian.controllers

import db.project.ghorbanian.models.Food
import db.project.ghorbanian.models.FoodReservation
import db.project.ghorbanian.repository.*
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/rest/food/")
class FoodCtrl(
        val foodRepo: FoodRepo,
        val foodReservationRepo: FoodReservationRepo,
        val addressRepo: AddressRepo,
        val deliveryRepo: DeliveryRepo
) {

    @PostMapping("add-food")
    fun addFood(@RequestBody food :Food){
        foodRepo.save(food)
    }

    @PostMapping("reserve-food/")
    fun reserveFood(@RequestBody foodReservation: FoodReservation){
        for (reserve in foodReservation.reservations){
            reserve.hasBeenSold = true
        }
        if (foodReservation.address != null){
            val randDelivery = deliveryRepo.findDelivery()
            foodReservation.delivery = randDelivery
        }
        foodReservationRepo.save(foodReservation)
    }

    @GetMapping("get-factors")
    fun getFactors():List<FoodReservation>{
        return foodReservationRepo.findAll()
    }

    @GetMapping("getMenu")
    fun getMenu():MutableList<Food>{
        return foodRepo.findAll()
    }


    @PutMapping("updateMenu")
    fun updateMenu(@RequestBody food: Food):String{
            val tempFood = foodRepo.findById(food.dbId).orElseThrow()
        if (tempFood.hasBeenSold) {
            foodRepo.save(food)
            food.isAvailable = false
        }
        else {
            food.updateValues(food)
        }
            foodRepo.save(food)
            return "ok"
    }

}