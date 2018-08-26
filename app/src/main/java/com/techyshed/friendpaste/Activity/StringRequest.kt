package com.techyshed.friendpaste.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.techyshed.friendpaste.R
import com.techyshed.volleyk.APIController
import com.techyshed.volleyk.ServiceInterface
import com.techyshed.volleyk.ServiceVolley
import kotlinx.android.synthetic.main.activity_string_request.*
import java.lang.StringBuilder
import java.util.regex.Matcher
import java.util.regex.Pattern

class StringRequest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_string_request)
    }

    fun BuShow(view:View){

        var service = ServiceVolley()

        var apiContoller = APIController(service)

        var path = "http://www.codezclub.com/c-solved-programs-examples-solutions/"

        apiContoller.getReq(path){response ->

            Log.i("Response----",response.toString())

            var str = StringBuilder()
            var p = Pattern.compile("|<td><a href=\"(.*?)\" target|noreferrer\">(.*?)</a>|")
            var m:Matcher = p.matcher(response)

            while (m.find())
            {
                Log.i("group0----",m.group(0))
                Log.i("group1----",m.group(1))

                str.append(m.group(1)+"\n")
            }

            tvShow.setText(str.toString() + "  Done!!")
        }
    }
}
