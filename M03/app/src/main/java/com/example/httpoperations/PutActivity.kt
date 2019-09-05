package com.example.httpoperations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.httpoperations.model.Employee
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PutActivity : AppCompatActivity(), Callback<Employee> {

    override fun onFailure(call: Call<Employee>, t: Throwable) {

    }

    override fun onResponse(call: Call<Employee>, response: Response<Employee>) {
        response.body().let {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        }
    }
    lateinit var employeesService: JsonPlaceHolderApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_picker)

        title = "Put Request: Update existing Employee Steve"

        // TODO: Create the API object
        employeesService = JsonPlaceHolderApi.Factory.create()
        updateEmployee()
    }


    private fun updateEmployee(){
        // TODO: Write the call to update an employee
        val employee = Employee("Brain",6,40,"Instructor")
        employeesService.updateEmployee(employee).enqueue(this)
    }
}
