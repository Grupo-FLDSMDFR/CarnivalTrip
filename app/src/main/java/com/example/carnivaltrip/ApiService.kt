package com.example.carnivaltrip

import retrofit2.http.GET

interface ApiService {
    @GET("/Grupo-FLDSMDFR/dbCarnivalTrip/CarnivalWorld")
    suspend fun requestCarnival(): List<ListPoi>
}