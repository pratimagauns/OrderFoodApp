package com.pratima.foodorderapp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.pratima.foodorderapp.R
import com.pratima.foodorderapp.databinding.ActivityOtpverificationBinding
import com.pratima.foodorderapp.ui.viewmodel.OTPViewModel
import com.pratima.foodorderapp.ui.viewmodel.ViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_otpverification.*
import javax.inject.Inject


class OTPVerificationActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding: ActivityOtpverificationBinding
    private lateinit var viewModel: OTPViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_otpverification)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(OTPViewModel::class.java)
        binding.viewModel = viewModel
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        val length: Int = ("" + viewModel.otpValue).length

        return when (keyCode) {
            KeyEvent.KEYCODE_1,
            KeyEvent.KEYCODE_2,
            KeyEvent.KEYCODE_3,
            KeyEvent.KEYCODE_4,
            KeyEvent.KEYCODE_5,
            KeyEvent.KEYCODE_6,
            KeyEvent.KEYCODE_7,
            KeyEvent.KEYCODE_8,
            KeyEvent.KEYCODE_9,
            KeyEvent.KEYCODE_0 -> {
                if (length == 4) {
                    return false
                }
                val pressedKey = event.unicodeChar.toChar()

                viewModel.otpValue = (viewModel.otpValue * 10) + Character.toString(pressedKey).toInt()
                updateFocus(false)
                true
            }
            KeyEvent.KEYCODE_DEL -> {
                viewModel.otpValue = (viewModel.otpValue / 10)
                updateFocus(true)
                true
            }
            KeyEvent.KEYCODE_ENTER -> {
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                true
            }
            else -> super.onKeyUp(keyCode, event)
        }
    }

    fun updateFocus(clear:Boolean) {
        //Log.d("OTP Value is: ", viewModel.otpValue.toString())
        val length: Int = ("" + viewModel.otpValue).length
        when (length) {
            1 -> {
                if (viewModel.otpValue == 0) {
                    otp_edittext_1.requestFocus()
                    if (clear) otp_edittext_2.setText("")
                }
                else {
                    otp_edittext_2.requestFocus()
                    if (clear) otp_edittext_2.setText("")
                }
            }
            2 -> {
                otp_edittext_3.requestFocus()
                if (clear) otp_edittext_3.setText("")
            }
            3 -> {
                otp_edittext_4.requestFocus()
                if (clear) otp_edittext_4.setText("")
            }
        }
    }
}
