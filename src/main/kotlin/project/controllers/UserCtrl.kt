package db.project.ghorbanian.controllers

import db.project.ghorbanian.models.Address
import db.project.ghorbanian.models.Customer
import db.project.ghorbanian.models.Delivery
import db.project.ghorbanian.repository.*
import org.springframework.web.bind.annotation.*
import java.time.LocalDate


@RestController
@RequestMapping("/rest/user")
class UserCtrl (
        val userRepo: UserRepo,
        val addressRepo: AddressRepo,
        val deliveryRepo: DeliveryRepo,
        val rawMatFactorRepo: RawMatFactorRepo,
        val foodReservationRepo: FoodReservationRepo
){


    @PostMapping("add-address")
    fun addAddress(@RequestBody address: Address){
        addressRepo.save(address)
    }


    @PostMapping("add-delivery")
    fun addDelivery(@RequestBody delivery: Delivery){
        deliveryRepo.save(delivery)
    }

    @PostMapping("create-account")
    fun createAccount(@RequestBody customer: Customer){
   //     if (customer.phoneNumber.toString().length == 10) {
            userRepo.save(customer)
   //     }
     //   else println("not valid")
    }

    @PostMapping("get-profit")
    fun getProfit(@RequestBody date :Date):Long{
        var rawPrices : Long = 0
        var reservePrices : Long = 0
        val dailyRawFactors = rawMatFactorRepo.findAllByDate(date.date)
        val dailyReservationFactors = foodReservationRepo.findAllByDate(date.date)
        for (rawFactors in dailyRawFactors) {
            for (materials in rawFactors.rawMaterials) {
                rawPrices += materials.number * materials.price
            }
        }
        for (reserveFactors in dailyReservationFactors) {
            for (materials in reserveFactors.reservations) {
                reservePrices += materials.number * materials.price
            }
        }
        return reservePrices - rawPrices
    }


    data class Date(
            var date : LocalDate
    )

}