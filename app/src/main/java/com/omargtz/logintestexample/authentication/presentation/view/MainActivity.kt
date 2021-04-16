package com.omargtz.logintestexample.authentication.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.omargtz.logintestexample.BuildConfig
import com.omargtz.logintestexample.R
import com.omargtz.logintestexample.authentication.domain.entity.driver.EmptyEmailError
import com.omargtz.logintestexample.authentication.domain.entity.driver.EmptyPasswordError
import com.omargtz.logintestexample.authentication.domain.entity.driver.InvalidEmailError
import com.omargtz.logintestexample.authentication.presentation.viewmodel.LoginViewModel
import com.omargtz.logintestexample.base.LoginResult
import com.omargtz.logintestexample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val viewModel by viewModels<LoginViewModel>()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        subscribeLoginSuccess()
        with(binding) {
            viewmodel = viewModel
            email = getString(R.string.login_text_email)
            version = "v${BuildConfig.VERSION_NAME}"
            btnLogin.setOnClickListener {
                authenticate()
            }
        }
    }

    private fun authenticate() {
        val user = binding.inputName.text.toString()
        val password = binding.inputPassword.text.toString()
        viewModel.login(user, password)
    }

    private fun subscribeLoginSuccess() {
        viewModel.driver.observe(this, Observer {
            when (it) {
                is LoginResult.Success -> {
                    navigateToHome()
                    binding.loading.visibility = View.GONE
                }
                is LoginResult.Error -> {
                    showError(it.exception)
                    binding.loading.visibility = View.GONE
                }
                is LoginResult.Loading -> {
                    binding.loading.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun showError(error: Throwable) {
        when (error) {
            is EmptyEmailError -> { showMessage(R.string.invalid_email) }
            is EmptyPasswordError -> { showMessage(R.string.empty_password) }
            is InvalidEmailError ->  { showMessage(R.string.auth_error) }
            else -> { showMessage(R.string.unknown_error)}
        }
    }

    private fun showMessage(@StringRes message: Int) {
        Toast.makeText(this, getString(message), Toast.LENGTH_SHORT ).show()
    }

    private fun navigateToHome() {
        showMessage(R.string.go_to_home)
    }

}