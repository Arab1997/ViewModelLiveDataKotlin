package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class UserViewModel : ViewModel() {
    /*Для списка пользователей используется объект класса MutableLiveData — это подкласс LiveData,
    который является частью Архитектурных компонентов, и следует паттерну Observer (наблюдатель).
     Если вы знакомы с RxJava, класс LiveData похож на Observable.
     Но если с Observable вы должны удалять связи вручную, то класс LiveData зависит от жизненного цикла и выполняет всю очистку самостоятельно.
     Подписчиками LiveData являются активити и фрагменты. LiveData принимает подписчика и уведомляет
     его об изменениях данных, только когда он находится в состоянии STARTED или RESUMED. Состояние подписчиков определяется их объектом LifeCycle.*/
    var userList : MutableLiveData<List<User>> = MutableLiveData()

    // MutableLiveData предоставляет методы setValue и postValue (второй — поточно-безопасный), посредством которых можно получить и отправить данные любым активным подписчикам.

    //инициализируем список и заполняем его данными пользователей
    init {
        userList.value = UserData.getUsers()
    }

    fun getListUsers() = userList

    //для обновления списка передаем второй список пользователей
    fun updateListUsers() {
        userList.value = UserData.getAnotherUsers()
    }
}