package com.example.bookshelf.classes

class Constants (val lang : String)
{
    object es
    {
        const val default_title       : String    = "Título"
        const val default_author      : String    = "Autor"
        const val default_editorial   : String    = "Editorial"
        const val default_cover       : Int       = 0
        const val default_pages       : Short     = 10
        const val def_username_hint   : String    = "Nombre de usuario"
        const val def_password_hint   : String    = "Contraseña"
        const val def_login_btn       : String    = "Ingresar"
        const val def_new_user_btn    : String    = "Nuevo Usuario"
        const val def_email_hint      : String    = "Email"
        const val def_create_btn      : String    = "Crear"
        const val error_login_msg     : String    = "Usuario o Contraseña inválidos"
    }

    object en
    {
        const val default_title       : String    = "Title"
        const val default_author      : String    = "Author"
        const val default_editorial   : String    = "Editorial"
        const val default_cover       : Int       = 0
        const val default_pages       : Short     = 10
        const val def_username_hint   : String    = "Username"
        const val def_password_hint   : String    = "Password"
        const val def_login_btn       : String    = "Login"
        const val def_new_user_btn    : String    = "New User"
        const val def_email_hint      : String    = "Email"
        const val def_create_btn      : String    = "Create"
        const val error_login_msg     : String    = "Invalid User or Password"
    }

    fun get_author (): String {
        return when (lang) {
            "es" -> {
                es.default_author
            }
            "en" -> {
                en.default_author
            }
            else -> {
                en.default_author
            }
        }
    }

    fun get_title (): String {
        return when (lang) {
            "es" -> {
                es.default_title
            }
            "en" -> {
                en.default_title
            }
            else -> {
                en.default_title
            }
        }
    }

    fun get_editorial (): String{
        return when (lang){
            "es" -> {
                es.default_editorial
            }
            "en" -> {
                en.default_editorial
            }
            else -> {
                en.default_editorial
            }
        }
    }

    fun get_cover (): Int {
        return when (lang){
            "es" -> {
                es.default_cover
            }
            "en" -> {
                en.default_cover
            }
            else -> {
                en.default_cover
            }
        }
    }

    fun get_pages (): Short {
        return when (lang){
            "es" -> {
                es.default_pages
            }
            "en" -> {
                en.default_pages
            }
            else -> {
                en.default_pages
            }
        }
    }

    fun get_user_hint () : String{
        return when (lang) {
            "es" ->{
                es.def_username_hint
            }
            "en" ->{
                en.def_username_hint
            }
            else -> {
                en.def_username_hint
            }
        }
    }

    fun get_pass_hint () : String{
        return when (lang){
            "es" ->{
                es.def_password_hint
            }
            "en" ->{
                en.def_password_hint
            }
            else ->{
                en.def_password_hint
            }
        }
    }

    fun get_login_text () : String{
        return when (lang){
            "es" -> {
                es.def_login_btn
            }
            "en" -> {
                en.def_login_btn
            }
            else -> {
                en.def_login_btn
            }
        }
    }

    fun get_new_user_text () : String{
        return when (lang){
            "es" ->{
                es.def_new_user_btn
            }
            "en" ->{
                en.def_new_user_btn
            }
            else ->{
                en.def_new_user_btn
            }
        }
    }

    fun get_email_hint () : String{
        return when (lang){
            "es" ->{
                es.def_email_hint
            }
            "en" ->{
                en.def_email_hint
            }
            else ->{
                en.def_email_hint
            }
        }
    }

    fun get_create_text () : String{
        return when (lang){
            "es" ->{
                es.def_create_btn
            }
            "en" ->{
                en.def_create_btn
            }
            else ->{
                en.def_create_btn
            }
        }
    }

    fun get_login_error_msg () : String {
        return when (lang){
            "es" -> {
                es.error_login_msg
            }
            "en" -> {
                en.error_login_msg
            }
            else -> {
                en.error_login_msg
            }

        }
    }
}