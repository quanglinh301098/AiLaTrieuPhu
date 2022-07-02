package com.linhpham.ailatrieuphu.service.response.configure

import com.linhpham.ailatrieuphu.service.response.ErrorData

data class ConfigResponse(val errorData : ErrorData, val configData: ConfigureData)