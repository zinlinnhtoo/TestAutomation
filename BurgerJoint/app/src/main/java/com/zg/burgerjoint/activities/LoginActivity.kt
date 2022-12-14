package com.zg.burgerjoint.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import com.google.android.material.snackbar.Snackbar
import com.zg.burgerjoint.R
import com.zg.burgerjoint.mvp.presenters.LoginPresenter
import com.zg.burgerjoint.mvp.presenters.impls.LoginPresenterImpl
import com.zg.burgerjoint.mvp.views.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginView {


    private lateinit var mPresenter: LoginPresenter
    val REQUEST_CODE = 111
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setUpPresenter()
        setUpListeners()
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<LoginPresenterImpl, LoginView>()
    }

    private fun setUpListeners() {
        btnLogin.setOnClickListener {
            mPresenter.onTapLogin(etUserName.text.toString(), etPassword.text.toString())
        }
    }

    override fun navigateToMainScreen() {
        startActivity(MainActivity.newIntent(this))
    }

    override fun showErrorMessage(message: String) {
        Snackbar.make(window.decorView, message, Snackbar.LENGTH_LONG).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE && data != null) {
//
//        }
    }}