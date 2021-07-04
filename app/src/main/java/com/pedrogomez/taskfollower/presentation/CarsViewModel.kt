package com.pedrogomez.taskfollower.presentation

import androidx.lifecycle.*
import com.pedrogomez.taskfollower.domian.db.DailyTime
import com.pedrogomez.taskfollower.domian.view.CarModel
import com.pedrogomez.taskfollower.repository.RepositoryContract
import kotlinx.coroutines.launch

class CarsViewModel(
    private val contract: RepositoryContract
) : ViewModel() {

    val carsList : LiveData<List<CarModel>> = contract.getCars()

    val categoriesList : LiveData<List<DailyTime>> = contract.getCategories()

    private var carDetailToView : MutableLiveData<CarModel> = MutableLiveData()

    private var carDetailToEdit : MutableLiveData<CarModel?> = MutableLiveData()

    fun addCar(carFromView: CarModel) {
        viewModelScope.launch {
            contract.addCar(carFromView)
        }
    }

    fun addCategory(dailyTime: DailyTime) {
        viewModelScope.launch {
            contract.addCategory(dailyTime)
        }
    }

    fun updateCar(carFromView: CarModel) {
        viewModelScope.launch {
            contract.updateCar(carFromView)
        }
    }

    fun setCarToView(carFromView: CarModel){
        carDetailToView.postValue(
            carFromView
        )
    }

    fun getCarToView() = carDetailToView

    fun setCarToEdit(carFromView: CarModel?){
        carDetailToEdit.postValue(
            carFromView
        )
    }

    fun getCarToEdit() = carDetailToEdit

    fun saveCar(carFromView: CarModel) {
        viewModelScope.launch {
            if(carDetailToEdit.value!=null){
                contract.updateCar(carFromView)
            }else{
                contract.addCar(carFromView)
            }
        }

    }

}