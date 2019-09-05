package com.example.httpoperations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.httpoperations.model.Employee
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetActivity : AppCompatActivity() {
    lateinit var employeesService: JsonPlaceHolderApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get)
        employeesService = JsonPlaceHolderApi.Factory.create()

        val type = intent.getStringExtra("get")
        if (type == "simple") {
            title = "GET - Simple Request"
            getEmployees()
        } else if (type == "path") {
            title = "GET - Path Parameter: EmployeeId - 1"
            getEmployeesById("1")
        }
        else{
            title = "GET - Query Parameter: Age - 55"
            getEmployeesByAge("55")
        }
    }

    private fun getEmployees(){
        // TODO: Write the call for getting all employees
        employeesService.getEmployees().enqueue(object : Callback<List<Employee>> {
            override fun onFailure(call: Call<List<Employee>>, t: Throwable) {
                Toast.makeText(this@GetActivity, "Failed", Toast.LENGTH_LONG).show()
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<List<Employee>>, response: Response<List<Employee>>) {
                response.body()?.let {


                    Toast.makeText(this@GetActivity, it.toString(), Toast.LENGTH_SHORT).show()
                }

            }

        })

    }

    private fun getEmployeesById(employeeId: String){
        // TODO: Write the call to get an employee by id
    }

    private fun getEmployeesByAge(age: String){
        // TODO: Write the call to get an employee by age
    }

}


