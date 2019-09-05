package com.example.httpoperations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.httpoperations.model.Employee
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostActivity : AppCompatActivity(), Callback<Employee> {


    override fun onFailure(call: Call<Employee>, t: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResponse(call: Call<Employee>, response: Response<Employee>) {
        response.body().let {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        }
    }
    lateinit var employeesService: JsonPlaceHolderApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        title = "Post Request: New Employee David"

        // TODO: create the API object
        employeesService = JsonPlaceHolderApi.Factory.create()
        addnewEmployee()
    }

    private fun addnewEmployee(){
        // TODO: Write the call to add a new employee
        val employee = Employee("Brain",6,40,"Instructor")
        employeesService.addNewEmployee(employee).enqueue(this)
    }
}
