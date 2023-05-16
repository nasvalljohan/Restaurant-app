package com.nasvalljohan.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nasvalljohan.myapplication.di.AppModule
import com.nasvalljohan.myapplication.ui.theme.UmainCodeTestTheme
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidLogger()
            androidContext(applicationContext)
            koin.loadModules(listOf(AppModule))
        }

        setContent {
            UmainCodeTestTheme {
                Root()
            }
        }
    }
}
